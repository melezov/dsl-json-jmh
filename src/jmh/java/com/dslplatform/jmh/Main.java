package com.dslplatform.jmh;

import com.dslplatform.example.HelloWorld;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class Main {
    @Benchmark
    public static void testSleep(final Blackhole bh) {
        bh.consume(HelloWorld.sleepWorld(100));
    }
}
