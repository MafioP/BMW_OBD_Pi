import time, serial
import socket



def checksum(data):
    hexData = [chr(int(x, 16)) for x in data.split(' ')]
    sum = 0
    for i in hexData:
        sum ^= ord(i)
    sum = hex(sum)[2:]
    if sum.__len__() < 2:
            sum = '0'+sum
    return sum 


#Connect to serial port COM1
ser = serial.Serial('COM1', 9600,bytesize=8,
                    parity=serial.PARITY_EVEN,
                    stopbits=serial.STOPBITS_ONE)
print(ser)
# Request
def sendRequest(pid):
    request = 'B8 12 F1 04 2C 10 00 ' + pid
    xorSum = checksum(request)
    request += ' ' + xorSum.__str__()
    print("Request: " + request)
    ser.write(bytes.fromhex(request))
    time.sleep(0.5)

# Read
def readResponse():
    readRaw=""
    while ser.inWaiting():
        in_read = hex(int.from_bytes(ser.read(),byteorder='little'))[2:]
        if in_read.__len__() < 2:
            in_read = '0'+in_read
        readRaw += in_read
    return readRaw
    

def getRPM(data):
    rpm = int(data[4:], base=16)*4
    return "rpm:" +str(rpm)


def getAirIntakeTemp(data):
    temp = int(data[4:], base=16) - 40
    return "airInTemp:" + str(temp)


def getCoolantTemp(data):
    temp = int(data[4:], base=16) - 40
    return "coolTemp: " + str(temp)

# Analise
def parseData(response):
    size = int(response[6:8])*2         #get data size *2 to get bytes
    pid = response[8+size-2:10+size-2]      #pid is located at [address](6)+[length](2)+[data](size)-2
    response = response[18:]
    #print("Evaluable data: " + response)
    #print("Data size = " + str(size/2))
    #print("Requested PID: " + pid)
    data = response[8:8+size]
    #print("Actual data: " + data)

    value = ""
    if pid == '0c':
        value = getRPM(data)
    elif pid == '0f':
        value = getAirIntakeTemp(data)
    elif pid == '05':
        value = getCoolantTemp(data)
    else:
        print("DATA: " + data)
    return value



# PID list
pidList = [
    '0C',   #RPM
    '05',   #Coolant Temperature
    '0F'    #Intake Air Temperature
]
HOST = "Localhost"
PORT = 4000

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect((HOST, PORT))

client_socket.send(b"HELLO\n")

#print("Client is ready")

#Request main loop
#mode = input("Type 1 for auto mode, 0 for maunal: ")
mode = '1'
if mode == '1':
    try:
        while True:
            if client_socket.recv(10) == -1:
                print("Exiting script")
                break
            else:
                for pid in pidList:                         #For each pid in the available pid List
                    sendRequest(pid)                        #Request Data
                    if ser.inWaiting():                     #While time.sleep
                        readData = readResponse()           #Read incoming data
                    value = parseData(readData)
                    client_socket.send(str.encode(value))
                    print(value)
    except KeyboardInterrupt:
        print("Exiting program")
else:
    try:
        while True:
            pid = input("Input PID: ")
            sendRequest(pid)
            if ser.inWaiting():                     #While time.sleep
                readData = readResponse()           #Read incoming data
            #print(readData)
            parseData(readData)
    except KeyboardInterrupt:
        print("Exiting Program")

ser.close()
client_socket.close()

