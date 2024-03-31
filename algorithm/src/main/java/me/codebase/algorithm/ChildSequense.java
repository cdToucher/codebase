package me.codebase.algorithm;

/**
 * 老本地代码提交
 * <p>
 * 验证子序列
 */
public class ChildSequense {

    public static void main(String[] args) {
        ChildSequense instance = new ChildSequense();
        System.out.println(instance.isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int i = 0;
        int j = 0;
        int arrTLength = arrT.length;
        int arrSLength = arrS.length;
        if (arrTLength == 0 && arrS.length != 0)
            return false;
        if (arrTLength == 0)
            return true;
        while (i < arrSLength) {
            if (arrS[i] != arrT[j]) {
                j++;
                if (j > arrTLength - 1)
                    return false;
                continue;
            }
            i++;
            j++;
            if (i < arrSLength && j > arrTLength - 1)
                return false;
        }
        return true;
    }
}
