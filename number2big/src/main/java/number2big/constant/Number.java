package number2big.constant;

/**
 * Created by chendong on 2017/9/6.
 */
public enum Number {

    _0(0, "零"),
    _1(1, "一"),
    _2(2, "二"),
    _3(3, "三"),
    _4(4, "四"),
    _5(5, "五"),
    _6(6, "六"),
    _7(7, "七"),
    _8(8, "八"),
    _9(9, "九"),;

    Number(int num, String numStr) {
        this.val = num;
        this.numStr = numStr;
    }

    private int val;

    private String numStr;

    public String getNum() {
        return numStr;
    }

    public void setNum(String num) {
        this.numStr = num;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static String getNumByVal(int val) {
        for (Number number : Number.values()) {
            if (number.getVal() == val)
                return number.getNum();
        }
        return _0.getNum();
    }
}
