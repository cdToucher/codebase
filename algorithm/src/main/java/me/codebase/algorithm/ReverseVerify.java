package me.codebase.algorithm;

/**
 * 验证回文串
 * <p>
 * 提交一些以前的记忆代码
 */
public class ReverseVerify {

    public static void main(String[] args) {
        String s = "Zeus was deified, saw Suez.";
        ReverseVerify instance = new ReverseVerify();
        System.out.println(instance.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (isf(arr[i]) || arr[i] == 32) {
                i++;
                continue;
            }
            if (isf(arr[j]) || arr[j] == 32) {
                j--;
                continue;
            }
            if (toLowercase(arr[i]) != toLowercase(arr[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public char toLowercase(char c) {
        if (c >= 65 && c <= 90) {
            c += 32;
        }
        return c;
    }

    public boolean isf(char c) {
        return !((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122));
    }
}
