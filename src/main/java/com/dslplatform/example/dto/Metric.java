/*
* Created by DSL Platform
* v1.4.5862.604
*/

package com.dslplatform.example.dto;

public final class Metric implements java.lang.Cloneable, java.io.Serializable, com.dslplatform.json.JsonObject {
    public Metric(final String name, final String metricType, final long[] snapshot) {
        setName(name);
        setMetricType(metricType);
        setSnapshot(snapshot);
    }

    public Metric() {
        this.name = "";
        this.metricType = "";
        this.snapshot = new long[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1239037095;
        result = prime * result + (this.name.hashCode());
        result = prime * result + (this.metricType.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Metric)) return false;
        return deepEquals((Metric) obj);
    }

    public boolean deepEquals(final Metric other) {
        if (other == null) return false;

        if (!(this.name.equals(other.name))) return false;
        if (!(this.metricType.equals(other.metricType))) return false;
        if (!(java.util.Arrays.equals(this.snapshot, other.snapshot))) return false;
        return true;
    }

    private Metric(Metric other) {
        this.name = other.name;
        this.metricType = other.metricType;
        this.snapshot = java.util.Arrays.copyOf(other.snapshot, other.snapshot.length);
    }

    @Override
    public Object clone() {
        return new Metric(this);
    }

    @Override
    public String toString() {
        return "Metric(" + name + ',' + metricType + ',' + snapshot + ')';
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Metric(
            @com.fasterxml.jackson.annotation.JsonProperty("_helper") final boolean _helper,
            @com.fasterxml.jackson.annotation.JsonProperty("name") final String name,
            @com.fasterxml.jackson.annotation.JsonProperty("metricType") final String metricType,
            @com.fasterxml.jackson.annotation.JsonProperty("snapshot") final long[] snapshot) {
        this.name = name == null ? "" : name;
        this.metricType = metricType == null ? "" : metricType;
        this.snapshot = snapshot == null ? new long[] {} : snapshot;
    }

    private static final long serialVersionUID = 4627251773141654374L;

    private String name;

    @com.fasterxml.jackson.annotation.JsonProperty("name")
    public String getName() {
        return name;
    }

    public Metric setName(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"name\" cannot be null!");
        this.name = value;

        return this;
    }

    private String metricType;

    @com.fasterxml.jackson.annotation.JsonProperty("metricType")
    public String getMetricType() {
        return metricType;
    }

    public Metric setMetricType(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"metricType\" cannot be null!");
        this.metricType = value;

        return this;
    }

    private static final long[] _defaultsnapshot = new long[] {};

    private long[] snapshot;

    @com.fasterxml.jackson.annotation.JsonProperty("snapshot")
    public long[] getSnapshot() {
        return snapshot;
    }

    public Metric setSnapshot(final long[] value) {
        if (value == null) throw new IllegalArgumentException("Property \"snapshot\" cannot be null!");
        this.snapshot = value;

        return this;
    }

    public void serialize(final com.dslplatform.json.JsonWriter sw, final boolean minimal) {
        sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
        if (minimal) {
            __serializeJsonObjectMinimal(this, sw, false);
        } else {
            __serializeJsonObjectFull(this, sw, false);
        }
        sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
    }

    static void __serializeJsonObjectMinimal(
            final Metric self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        if (!(self.name.length() == 0)) {
            hasWrittenProperty = true;
            sw.writeAscii("\"name\":", 7);
            sw.writeString(self.name);
        }

        if (!(self.metricType.length() == 0)) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"metricType\":", 13);
            sw.writeString(self.metricType);
        }

        if (self.snapshot.length != 0) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"snapshot\":[", 12);
            com.dslplatform.json.NumberConverter.serialize(self.snapshot[0], sw);
            for (int i = 1; i < self.snapshot.length; i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                com.dslplatform.json.NumberConverter.serialize(self.snapshot[i], sw);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        }
    }

    static void __serializeJsonObjectFull(
            final Metric self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        sw.writeAscii("\"name\":", 7);
        sw.writeString(self.name);

        sw.writeAscii(",\"metricType\":", 14);
        sw.writeString(self.metricType);

        if (self.snapshot.length != 0) {
            sw.writeAscii(",\"snapshot\":[", 13);
            com.dslplatform.json.NumberConverter.serialize(self.snapshot[0], sw);
            for (int i = 1; i < self.snapshot.length; i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                com.dslplatform.json.NumberConverter.serialize(self.snapshot[i], sw);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        } else sw.writeAscii(",\"snapshot\":[]", 14);
    }

    public static final com.dslplatform.json.JsonReader.ReadJsonObject<Metric> JSON_READER = new com.dslplatform.json.JsonReader.ReadJsonObject<Metric>() {
        @Override
        public Metric deserialize(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
            return new com.dslplatform.example.dto.Metric(reader);
        }
    };

    private Metric(final com.dslplatform.json.JsonReader<com.dslplatform.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        String _name_ = "";
        String _metricType_ = "";
        long[] _snapshot_ = _defaultsnapshot;
        byte nextToken = reader.last();
        if (nextToken != '}') {
            int nameHash = reader.fillName();
            nextToken = reader.getNextToken();
            if (nextToken == 'n') {
                if (reader.wasNull()) {
                    nextToken = reader.getNextToken();
                } else {
                    throw new java.io.IOException("Expecting 'u' (as null) at position " + reader.positionInStream()
                            + ". Found " + (char) nextToken);
                }
            } else {
                switch (nameHash) {
                    case -1925595674:
                        _name_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -1033972887:
                        _metricType_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 715361165:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                java.util.ArrayList<Long> __res = com.dslplatform.json.NumberConverter
                                        .deserializeLongCollection(reader);
                                long[] __resUnboxed = new long[__res.size()];
                                for (int _i = 0; _i < __res.size(); _i++)
                                    __resUnboxed[_i] = __res.get(_i);
                                _snapshot_ = __resUnboxed;
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            while (nextToken == ',') {
                nextToken = reader.getNextToken();
                nameHash = reader.fillName();
                nextToken = reader.getNextToken();
                if (nextToken == 'n') {
                    if (reader.wasNull()) {
                        nextToken = reader.getNextToken();
                        continue;
                    } else {
                        throw new java.io.IOException("Expecting 'u' (as null) at position "
                                + reader.positionInStream() + ". Found " + (char) nextToken);
                    }
                }
                switch (nameHash) {
                    case -1925595674:
                        _name_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -1033972887:
                        _metricType_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 715361165:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                java.util.ArrayList<Long> __res = com.dslplatform.json.NumberConverter
                                        .deserializeLongCollection(reader);
                                long[] __resUnboxed = new long[__res.size()];
                                for (int _i = 0; _i < __res.size(); _i++)
                                    __resUnboxed[_i] = __res.get(_i);
                                _snapshot_ = __resUnboxed;
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            if (nextToken != '}') { throw new java.io.IOException("Expecting '}' at position "
                    + reader.positionInStream() + ". Found " + (char) nextToken); }
        }

        this.name = _name_;
        this.metricType = _metricType_;
        this.snapshot = _snapshot_;
    }

    public static Object deserialize(
            final com.dslplatform.json.JsonReader<com.dslplatform.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        switch (reader.getNextToken()) {
            case 'n':
                if (reader.wasNull()) return null;
                throw new java.io.IOException("Invalid null value found at: " + reader.positionInStream());
            case '{':
                reader.getNextToken();
                return new com.dslplatform.example.dto.Metric(reader);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream()
                        + ". Expecting null, { or [. Found: " + (char) reader.last());
        }
    }
}
