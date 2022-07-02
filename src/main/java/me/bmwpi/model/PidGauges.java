package me.bmwpi.model;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.Section;
import eu.hansolo.medusa.TickMarkType;
import javafx.scene.paint.Color;

public class PidGauges {
    private static final int ANIM_DURATION = 100;
    public static Gauge getRpmGauge() {
        return GaugeBuilder.create().title("Engine RPM").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(6000).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(1000).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","1","2","3","4","5","6")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .tickMarkSections(new Section(4000, 4500, Color.ORANGE), new Section(4500, 6000, Color.RED))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getCoolantTempGauge() {
        return GaugeBuilder.create().title("Coolant Temp").unit("ºC").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(200).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(40).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","","40","","80","","120","","160","","200")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .tickMarkSections(new Section(120, 160, Color.ORANGE), new Section(160, 200, Color.RED))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getBoostGauge() {
        return GaugeBuilder.create().title("Boost").unit("bar").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(3).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(0.5).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","","1","","2","","3")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(2)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getOilTempGauge() {
        return GaugeBuilder.create().title("Oil Temp").unit("ºC").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(200).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(40).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","","40","","80","","120","","160","","200")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .tickMarkSections(new Section(120, 160, Color.ORANGE), new Section(160, 200, Color.RED))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getIntakeTempGauge() {
        return GaugeBuilder.create().title("Intake Air Temp").unit("ºC").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(100).minValue(-40).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(20).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("-40","-20","0","20","40","60","80","100")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .tickMarkSections(new Section(60, 80, Color.ORANGE), new Section(80, 100, Color.RED))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getEngineLoadGauge() {
        return GaugeBuilder.create().title("Engine Load").unit("%").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(100).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(20).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","20","40","60","80","100")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .tickMarkSections(new Section(80, 90, Color.ORANGE), new Section(90, 100, Color.RED))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }

    public static Gauge getAirflowRateGauge() {
        return GaugeBuilder.create().title("Air Flow Rate").unit("g/s").prefSize(250,250).skinType(Gauge.SkinType.GAUGE)
                .animated(true).animationDuration(ANIM_DURATION).maxValue(500).tickMarkSectionsVisible(true).minorTickMarksVisible(true).mediumTickMarksVisible(false)
                .majorTickSpace(100).majorTickMarkType(TickMarkType.BOX).customTickLabelsEnabled(true).customTickLabels("0","100","200","300","400","500")
                .tickLabelColor(Color.rgb(0, 204, 255)).customTickLabelFontSize(40).majorTickMarkWidthFactor(20)
                .backgroundPaint(Color.rgb(10,10,10))
                .borderPaint(Color.rgb(200,200,200)).borderWidth(5)
                .angleRange(270).startAngle(0).tickMarkColor(Color.rgb(0, 204, 255)).titleColor(Color.rgb(0, 204, 255))
                .valueColor(Color.rgb(0, 204, 255)).decimals(0)
                .knobColor(Color.rgb(20,20,20)).needleType(Gauge.NeedleType.BIG).needleShape(Gauge.NeedleShape.ANGLED)
                .build();
    }
}
