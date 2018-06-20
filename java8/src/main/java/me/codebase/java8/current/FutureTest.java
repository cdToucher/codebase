package me.codebase.java8.current;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;

public class FutureTest {

    @Test
    public void testImmediateFuture() throws Exception {
        final ListenableFuture<String> hello1 = Futures.immediateFuture("hello");
        assertEquals("hello", hello1.get());

        final CompletableFuture<String> hello2 = CompletableFuture.completedFuture("hello");
        assertEquals("hello", hello2.get());
    }

    @Test
    public void testTransform() throws Exception {
        final CompletableFuture<String> result2 = CompletableFuture.completedFuture("hello").thenApply(s -> s + s);
        assertEquals("hellohello", result2.get());
    }

    @Test
    public void testCombine() throws Exception {
        final CompletableFuture<String> g1 = CompletableFuture.completedFuture("a");
        final CompletableFuture<String> g2 = CompletableFuture.completedFuture("b");
        final CompletableFuture<String> g3 = CompletableFuture.completedFuture("c");
        assertEquals("abc", g1.thenCombine(g2, (s1, s2) -> s1 + s2).thenCombine(g3, (s12, s3) -> s12 + s3).get());
    }

}
