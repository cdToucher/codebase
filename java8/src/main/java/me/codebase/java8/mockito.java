package me.codebase.java8;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by chendong on 2017/3/7.
 * <p>
 * junit test tool try
 */
public class mockito {

    @Test
    public void test1() {

        //mock creation
        List<Object> mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList, atLeastOnce()).add("one");
        verify(mockedList).clear();

        inOrder(mockedList).verify(mockedList).add("one");
        //verify the args length is longer than 5 chars
//        verify(mockedList, times(2)).add(argThat(string -> string.length() < 5));
    }
}
