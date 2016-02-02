package com.dslplatform.jmh;

import com.dslplatform.json.JsonWriter;
import com.dslplatform.json.NumberConverter;
import com.dslplatform.json.NumberConverter2;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@State(Scope.Thread)
public class Main {
    public static void main(final String[] args) throws IOException {
        initialize();
    }

    @Param({"positive", "negative", "any"})
    private static String always = "any";

    private static int current;

    private static ByteArrayOutputStream baos;
    private static JsonWriter dslJson;

    @Setup
    public static void initialize() throws IOException {
        final Random random = new java.util.Random();

        switch (always) {
            case "positive":
                current = Math.abs(random.nextInt());
                break;
            case "negative":
                current = - Math.abs(random.nextInt());
                break;
            default:
                current = random.nextInt();
        }

        baos = new ByteArrayOutputStream();
        dslJson = new JsonWriter();

        doTest();
    }

    private static void doTest() throws IOException {
        final Set<String> results = new LinkedHashSet<String>();

        {
            final Random random = new java.util.Random(1337);
            dslJson.reset();
            for (int i = 0; i < 100; i++) {
                NumberConverter2.serialize(random.nextInt(), dslJson);
            }
        }

        final String res1 = dslJson.toString();
        results.add(res1);

        {
            final Random random = new java.util.Random(1337);
            dslJson.reset();
            for (int i = 0; i < 100; i++) {
                NumberConverter2.serialize2(random.nextInt(), dslJson);
            }
        }
        final String res2 = dslJson.toString();
        results.add(res2);

        System.out.println(results.size());

        if (results.size() > 1) {
            System.out.println(res1 + "\n" + res2);
            throw new RuntimeException("Test failed - JSON results differ!");
        }
    }


    @Benchmark
    public static void benchDslJson(final Blackhole bh) throws IOException {
        dslJson.reset();
        NumberConverter2.serialize(current, dslJson);
        bh.consume(dslJson);
    }

    @Benchmark
    public static void benchDslJson2(final Blackhole bh) throws IOException {
        dslJson.reset();
        NumberConverter2.serialize2(current, dslJson);
        bh.consume(dslJson);
    }
}
