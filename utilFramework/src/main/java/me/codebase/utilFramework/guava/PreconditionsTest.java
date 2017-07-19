package me.codebase.utilFramework.guava;

import com.google.common.base.Preconditions;

/**
 * Created by chendong on 2017/2/9.
 * <p>
 * precondtions test
 *
 * 适合在单元测试里使用， 或者在异常处理里使用
 */
public class PreconditionsTest {

    public static void main(String[] args) {
        boolean bool = Boolean.FALSE;
//        Preconditions.checkArgument(bool);
        Preconditions.checkArgument(bool, "wrong1");
        Preconditions.checkArgument(bool, "+ %s + ", "wrong2");
        Preconditions.checkElementIndex(1, 40);
        Preconditions.checkElementIndex(1,2,"List");
    }
}
