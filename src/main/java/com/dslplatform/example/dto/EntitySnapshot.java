/*
* Created by DSL Platform
* v1.4.5862.604
*/

package com.dslplatform.example.dto;

public final class EntitySnapshot implements java.lang.Cloneable, java.io.Serializable, com.dslplatform.json.JsonObject {
    public EntitySnapshot(
            final com.dslplatform.example.dto.Entity entity,
            final java.util.List<com.dslplatform.example.dto.Metric> metrics) {
        setEntity(entity);
        setMetrics(metrics);
    }

    public EntitySnapshot() {
        this.entity = null;
        this.metrics = new java.util.ArrayList<com.dslplatform.example.dto.Metric>(4);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 661921090;
        result = prime * result + (this.entity.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntitySnapshot)) return false;
        return deepEquals((EntitySnapshot) obj);
    }

    public boolean deepEquals(final EntitySnapshot other) {
        if (other == null) return false;

        if (!(this.entity.equals(other.entity))) return false;
        if (!((this.metrics == other.metrics || this.metrics != null && this.metrics.equals(other.metrics))))
            return false;
        return true;
    }

    private EntitySnapshot(EntitySnapshot other) {
        this.entity = other.entity;
        this.metrics = new java.util.ArrayList<com.dslplatform.example.dto.Metric>(other.metrics);
    }

    @Override
    public Object clone() {
        return new EntitySnapshot(this);
    }

    @Override
    public String toString() {
        return "EntitySnapshot(" + entity + ',' + metrics + ')';
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private EntitySnapshot(
            @com.fasterxml.jackson.annotation.JsonProperty("_helper") final boolean _helper,
            @com.fasterxml.jackson.annotation.JsonProperty("entity") final com.dslplatform.example.dto.Entity entity,
            @com.fasterxml.jackson.annotation.JsonProperty("metrics") final java.util.List<com.dslplatform.example.dto.Metric> metrics) {
        this.entity = entity;
        this.metrics = metrics == null ? new java.util.ArrayList<com.dslplatform.example.dto.Metric>(4) : metrics;
    }

    private static final long serialVersionUID = 3815166988684937486L;

    private com.dslplatform.example.dto.Entity entity;

    @com.fasterxml.jackson.annotation.JsonProperty("entity")
    public com.dslplatform.example.dto.Entity getEntity() {
        return entity;
    }

    public EntitySnapshot setEntity(final com.dslplatform.example.dto.Entity value) {
        if (value == null) throw new IllegalArgumentException("Property \"entity\" cannot be null!");
        this.entity = value;

        return this;
    }

    private java.util.List<com.dslplatform.example.dto.Metric> metrics;

    @com.fasterxml.jackson.annotation.JsonProperty("metrics")
    public java.util.List<com.dslplatform.example.dto.Metric> getMetrics() {
        return metrics;
    }

    public EntitySnapshot setMetrics(final java.util.List<com.dslplatform.example.dto.Metric> value) {
        if (value == null) throw new IllegalArgumentException("Property \"metrics\" cannot be null!");
        com.dslplatform.client.Guards.checkNulls(value);
        this.metrics = value;

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
            final EntitySnapshot self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        if (self.entity != null) {
            hasWrittenProperty = true;
            sw.writeAscii("\"entity\":{", 10);

            com.dslplatform.example.dto.Entity.__serializeJsonObjectMinimal(self.entity, sw, false);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
        }

        if (self.metrics.size() != 0) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"metrics\":[", 11);
            com.dslplatform.example.dto.Metric item = self.metrics.get(0);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
            com.dslplatform.example.dto.Metric.__serializeJsonObjectMinimal(item, sw, false);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
            for (int i = 1; i < self.metrics.size(); i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                item = self.metrics.get(i);
                sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
                com.dslplatform.example.dto.Metric.__serializeJsonObjectMinimal(item, sw, false);
                sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        }
    }

    static void __serializeJsonObjectFull(
            final EntitySnapshot self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        if (self.entity != null) {
            sw.writeAscii("\"entity\":{", 10);

            com.dslplatform.example.dto.Entity.__serializeJsonObjectFull(self.entity, sw, false);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
        } else {
            sw.writeAscii("\"entity\":null", 13);
        }

        if (self.metrics.size() != 0) {
            sw.writeAscii(",\"metrics\":[", 12);
            com.dslplatform.example.dto.Metric item = self.metrics.get(0);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
            com.dslplatform.example.dto.Metric.__serializeJsonObjectFull(item, sw, false);
            sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
            for (int i = 1; i < self.metrics.size(); i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                item = self.metrics.get(i);
                sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
                com.dslplatform.example.dto.Metric.__serializeJsonObjectFull(item, sw, false);
                sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        } else sw.writeAscii(",\"metrics\":[]", 13);
    }

    public static final com.dslplatform.json.JsonReader.ReadJsonObject<EntitySnapshot> JSON_READER = new com.dslplatform.json.JsonReader.ReadJsonObject<EntitySnapshot>() {
        @Override
        public EntitySnapshot deserialize(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
            return new com.dslplatform.example.dto.EntitySnapshot(reader);
        }
    };

    private EntitySnapshot(final com.dslplatform.json.JsonReader<com.dslplatform.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        com.dslplatform.example.dto.Entity _entity_ = null;
        java.util.List<com.dslplatform.example.dto.Metric> _metrics_ = new java.util.ArrayList<com.dslplatform.example.dto.Metric>(
                4);
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
                    case -750783014:

                        if (nextToken == '{') {
                            reader.getNextToken();
                            _entity_ = com.dslplatform.example.dto.Entity.JSON_READER.deserialize(reader);
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '{' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    case -253285258:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                reader.deserializeCollection(com.dslplatform.example.dto.Metric.JSON_READER, _metrics_);
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
                    case -750783014:

                        if (nextToken == '{') {
                            reader.getNextToken();
                            _entity_ = com.dslplatform.example.dto.Entity.JSON_READER.deserialize(reader);
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '{' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    case -253285258:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                reader.deserializeCollection(com.dslplatform.example.dto.Metric.JSON_READER, _metrics_);
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

        this.entity = _entity_;
        this.metrics = _metrics_;
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
                return new com.dslplatform.example.dto.EntitySnapshot(reader);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream()
                        + ". Expecting null, { or [. Found: " + (char) reader.last());
        }
    }
}
