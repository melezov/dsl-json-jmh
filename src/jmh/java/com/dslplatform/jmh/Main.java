package com.dslplatform.jmh;

import com.dslplatform.example.ApiJson;
import com.dslplatform.example.dto.Entity;
import com.dslplatform.example.dto.EntitySnapshot;
import com.dslplatform.example.dto.Metric;
import com.dslplatform.json.JsonWriter;
import com.dslplatform.json.JsonWriterScala;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.scala.DefaultScalaModule$;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import scala.collection.Seq;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@State(Scope.Thread)
public class Main {
    @Param({"10", "100", "1000", "10000"})
    private static int SNAPSHOT_COUNT;

    private static int METRIC_COUNT = 4;
    private static int ENTITY_COUNT = 100;

    private static List<EntitySnapshot> payloadJava;
    private static Seq<com.dslplatform.example.EntitySnapshot> payloadScala;

    private static ByteArrayOutputStream baos;
    private static JsonWriter dslJsonJava;
    private static JsonWriterScala dslJsonScala;
    private static ObjectMapper jacksonJava;
    private static ObjectMapper jacksonScala;

    private static long[] mockSnapshots(final Random random) {
        final long[] snapshots = new long[SNAPSHOT_COUNT];
        for (int i = 0; i < snapshots.length; i++) {
            snapshots[i] = random.nextLong();
        }
        return snapshots;
    }

    private static Metric mockMetric(final Random random) {
        return new Metric()
                .setName("Metric#" + random.nextInt())
                .setMetricType("Test type")
                .setSnapshot(mockSnapshots(random));
    }

    private static Entity mockEntity(final Random random) {
        return new Entity()
                .setCategory("Test category")
                .setName("Name#" + random.nextInt());
    }

    private static List<Metric> mockMetrics(final Random random) {
        final List<Metric> metrics = new ArrayList<Metric>();
        for (int i = 0; i < METRIC_COUNT; i++) {
            metrics.add(mockMetric(random));
        }
        return metrics;
    }

    private static EntitySnapshot mockEntitySnapshot(final Random random) {
        return new EntitySnapshot()
                .setEntity(mockEntity(random))
                .setMetrics(mockMetrics(random));
    }

    private static List<EntitySnapshot> mockPayload(final Random random) {
        final List<EntitySnapshot> payload = new ArrayList<EntitySnapshot>();
        for (int i = 0; i < ENTITY_COUNT; i++) {
            payload.add(mockEntitySnapshot(random));
        }
        return payload;
    }

    @Setup
    public static void initialize() throws IOException {
        final Random random = new java.util.Random(1337);

        payloadJava = mockPayload(random);
        payloadScala = MainScala.convertPayload(payloadJava);

        baos = new ByteArrayOutputStream();

        dslJsonJava = new JsonWriter();

        dslJsonScala = new JsonWriterScala();

        jacksonJava = new ObjectMapper()
                .registerModule(new AfterburnerModule());

        jacksonScala = new ObjectMapper()
                .registerModule(new AfterburnerModule())
                .registerModule(DefaultScalaModule$.MODULE$);

        doTest();
    }

    private static void doTest() throws IOException {
        final Set<String> results = new LinkedHashSet<String>();

        baos.reset();
        dslJsonJava.reset();
        dslJsonJava.serialize(payloadJava);
        final String dslJsonJavaResult = dslJsonJava.toString();
        final String jacksonJavaResult = jacksonJava.writeValueAsString(payloadJava);

        results.add(dslJsonJavaResult);
        results.add(jacksonJavaResult);

        baos.reset();
        dslJsonScala.reset();
        ApiJson.serialize(dslJsonScala, payloadScala);
        final String dslJsonScalaResult = dslJsonJava.toString();
        final String jacksonScalaResult = jacksonJava.writeValueAsString(payloadJava);

        results.add(dslJsonScalaResult);
        results.add(jacksonScalaResult);

        if (results.size() > 1) {
            throw new RuntimeException("Test failed - JSON results differ!");
        }
    }

    @Benchmark
    public static void benchDslJsonJava(final Blackhole bh) throws IOException {
        baos.reset();
        dslJsonJava.reset();
        dslJsonJava.serialize(payloadJava);
        dslJsonJava.toStream(baos);
        bh.consume(baos);
    }

    @Benchmark
    public static void benchJacksonJava(final Blackhole bh) throws IOException {
        baos.reset();
        jacksonJava.writeValue(baos, payloadJava);
        bh.consume(baos);
    }

    @Benchmark
    public static void benchDslJsonScala(final Blackhole bh) throws IOException {
        baos.reset();
        dslJsonScala.reset();
        ApiJson.serialize(dslJsonScala, payloadScala);
        dslJsonScala.toStream(baos);
        bh.consume(baos);
    }

    @Benchmark
    public static void benchJacksonScala(final Blackhole bh) throws IOException {
        baos.reset();
        jacksonScala.writeValue(baos, payloadScala);
        bh.consume(baos);
    }
}
