package com.dslplatform.example;

import com.dslplatform.json.JsonWriterScala;
import com.dslplatform.json.NumberConverterScala;
import scala.collection.Seq;

import java.io.UnsupportedEncodingException;

public final class ApiJson {
    private ApiJson() {}

    private static final byte[] Tag(final String tag) {
        try {
            return tag.replace('\'', '"').getBytes("ISO-8859-1");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static final byte[] ApiEntitySnapshotEntityCategoryTag1 = Tag("[{'entity':{'category':");
    private static final byte[] ApiEntitySnapshotEntityCategoryTagN = Tag("}]},{'entity':{'category':");
    private static final byte[] ApiEntitySnapshotEntityCategoryTagEnd = Tag("}]}]");
    private static final byte[] ApiEntitySnapshotEntityNameTag = Tag(",'name':");
    private static final byte[] ApiMetricNameTag1 = Tag("[{'name':");
    private static final byte[] ApiMetricNameTagN = Tag("},{'name':");
    private static final byte[] ApiMetricMetricTypeTag = Tag(",'metricType':");
    private static final byte[] ApiEntitySnapshotTag = Tag(",'snapshot':");
    private static final byte[] ApiEntitySnapshotMetricsTag = Tag("},'metrics':");

    public static void serialize(final JsonWriterScala sw, final Seq<EntitySnapshot> entitySnapshots) {
        byte[] loop1 = ApiEntitySnapshotEntityCategoryTag1;
        for (int i0 = 0; i0 < entitySnapshots.size(); i0++) {
            final EntitySnapshot entitySnapshot = entitySnapshots.apply(i0);
            sw.writeAscii(loop1);
            loop1 = ApiEntitySnapshotEntityCategoryTagN;
            final Entity entity = entitySnapshot.entity();
            sw.writeString(entity.category());
            sw.writeAscii(ApiEntitySnapshotEntityNameTag);
            sw.writeString(entity.name());
            final Seq<Metric> metrics = entitySnapshot.metrics();
            final int metricsSize = metrics.size();
            sw.writeAscii(ApiEntitySnapshotMetricsTag);

            byte[] loop2 = ApiMetricNameTag1;
            for (int i1 = 0; i1 < metricsSize; i1++) {
                final Metric metric = metrics.apply(i1);
                sw.writeAscii(loop2);
                loop2 = ApiMetricNameTagN;
                sw.writeString(metric.name());
                sw.writeAscii(ApiMetricMetricTypeTag);
                sw.writeString(metric.metricType());
                sw.writeAscii(ApiEntitySnapshotTag);
                NumberConverterScala.serialize(metric.snapshot(), sw);
            }
        }
        sw.writeAscii(ApiEntitySnapshotEntityCategoryTagEnd);
    }
}
