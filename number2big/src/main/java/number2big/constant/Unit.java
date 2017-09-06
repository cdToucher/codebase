package number2big.constant;

/**
 * Created by chendong on 2017/9/6.
 */
public enum Unit {

    NEGATIVE(-1, "负"),
    POINT(-1, "点"),
    TEN(1, "十"),
    HUNDRED(2, "百"),
    THOUSAND(3, "千"),
    TEN_THOUSANDS(4, "万"),
    __BILLION(8, "亿");


    private String unit;

    private int position;

    Unit(int position, String unit) {
        this.unit = unit;
        this.position = position;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static String getUnitByPosition(int position) {
        for (Unit unit : values()) {
            int pos = unit.getPosition();
            if (pos < 0)
                continue;
            if (unit.getPosition() == 4 || unit.getPosition() == 8) {
                while (position >= pos) {
                    if (position == pos)
                        return unit.getUnit();
                    else
                        pos += 8;
                }
            } else {
                while (position >= pos) {
                    if (position == pos)
                        return unit.getUnit();
                    else
                        pos += 4;
                }
            }
        }
        return "";
    }
}
