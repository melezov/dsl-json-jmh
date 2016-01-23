package com.dslplatform.example;

public class HelloWorld {
    public static long sleepWorld(final int ms) {
        try {
            final long startAt = System.nanoTime();
            Thread.sleep(ms);
            final long endAt = System.nanoTime();
            return endAt - startAt;
        }
        catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
