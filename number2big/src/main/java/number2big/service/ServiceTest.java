package number2big.service;

import com.google.common.base.Strings;
import number2big.constant.Number;
import number2big.constant.Unit;

import java.util.Objects;

/**
 * Created by chendong on 2017/9/6.
 * <p>
 * translate to number to Chinese number
 */
public class ServiceTest {


    public static void main(String[] args) {
        double input = 1234319.123;
        System.out.println(translate("1800002733300328311110"));
        System.out.println(translate("1800000000000000000000"));
        System.out.println(translate(1234319.123));
    }

    private static String translate(double number) {
        String numberStr = String.valueOf(number);
        return translate(numberStr);
    }

    private static String translate(String numberStr) {
        boolean negative = false;
        if (numberStr.startsWith("-")) {
            numberStr = numberStr.replaceFirst("-", "");
            negative = true;
        }
        String[] beforeAndAfter = numberStr.split("\\.");
        String before = new StringBuilder(beforeAndAfter[0]).reverse().toString();
        char[] charsBefore = before.toCharArray();
        StringBuilder ssb = new StringBuilder();
        for (int i = 0; i < charsBefore.length; i++) {
            String unit = Unit.getUnitByPosition(i);
            String numStr = Number.getNumByVal(Character.digit(charsBefore[i], 10));
            if (numStr.equals(Number._0.getNum()) && !Strings.isNullOrEmpty(unit)) {
                if (ssb.lastIndexOf(Number._0.getNum()) != ssb.length() - 1) {
                    if (Objects.equals(unit, Unit.__BILLION.getUnit()))
                        ssb.append(unit);
                    ssb.append(numStr);
                }
            } else {
                ssb.append(unit);
                ssb.append(numStr);
            }
        }
        before = ssb.reverse().toString();
        String after = beforeAndAfter.length > 1 ? beforeAndAfter[1] : "";
        if (!Strings.isNullOrEmpty(after)) {
            char[] chars = after.toCharArray();
            StringBuilder sb = new StringBuilder();
            sb.append(Unit.POINT.getUnit());
            for (char c : chars) {
                sb.append(Number.getNumByVal(Character.digit(c, 10)));
            }
            after = sb.toString();
        }
        String result = before + after;
        if (result.startsWith(Number._1.getNum() + Unit.TEN.getUnit())) {
            result = result.replaceFirst(Number._1.getNum(), "");
        }
        if (negative)
            result = Unit.NEGATIVE.getUnit() + result;

        return result;
    }
}
