/*
* Created by DSL Platform
* v1.4.5862.604
*/

package com.dslplatform.example.dto;

public final class Entity implements java.lang.Cloneable, java.io.Serializable, com.dslplatform.json.JsonObject {
    public Entity(final String category, final String name) {
        setCategory(category);
        setName(name);
    }

    public Entity() {
        this.category = "";
        this.name = "";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1018307290;
        result = prime * result + (this.category.hashCode());
        result = prime * result + (this.name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Entity)) return false;
        return deepEquals((Entity) obj);
    }

    public boolean deepEquals(final Entity other) {
        if (other == null) return false;

        if (!(this.category.equals(other.category))) return false;
        if (!(this.name.equals(other.name))) return false;
        return true;
    }

    private Entity(Entity other) {
        this.category = other.category;
        this.name = other.name;
    }

    @Override
    public Object clone() {
        return new Entity(this);
    }

    @Override
    public String toString() {
        return "Entity(" + category + ',' + name + ')';
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Entity(
            @com.fasterxml.jackson.annotation.JsonProperty("_helper") final boolean _helper,
            @com.fasterxml.jackson.annotation.JsonProperty("category") final String category,
            @com.fasterxml.jackson.annotation.JsonProperty("name") final String name) {
        this.category = category == null ? "" : category;
        this.name = name == null ? "" : name;
    }

    private static final long serialVersionUID = -1507345205085907728L;

    private String category;

    @com.fasterxml.jackson.annotation.JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public Entity setCategory(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"category\" cannot be null!");
        this.category = value;

        return this;
    }

    private String name;

    @com.fasterxml.jackson.annotation.JsonProperty("name")
    public String getName() {
        return name;
    }

    public Entity setName(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"name\" cannot be null!");
        this.name = value;

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
            final Entity self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        if (!(self.category.length() == 0)) {
            hasWrittenProperty = true;
            sw.writeAscii("\"category\":", 11);
            sw.writeString(self.category);
        }

        if (!(self.name.length() == 0)) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"name\":", 7);
            sw.writeString(self.name);
        }
    }

    static void __serializeJsonObjectFull(
            final Entity self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        sw.writeAscii("\"category\":", 11);
        sw.writeString(self.category);

        sw.writeAscii(",\"name\":", 8);
        sw.writeString(self.name);
    }

    public static final com.dslplatform.json.JsonReader.ReadJsonObject<Entity> JSON_READER = new com.dslplatform.json.JsonReader.ReadJsonObject<Entity>() {
        @Override
        public Entity deserialize(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
            return new com.dslplatform.example.dto.Entity(reader);
        }
    };

    private Entity(final com.dslplatform.json.JsonReader<com.dslplatform.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        String _category_ = "";
        String _name_ = "";
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
                    case -818986383:
                        _category_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -1925595674:
                        _name_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
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
                    case -818986383:
                        _category_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -1925595674:
                        _name_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            if (nextToken != '}') { throw new java.io.IOException("Expecting '}' at position "
                    + reader.positionInStream() + ". Found " + (char) nextToken); }
        }

        this.category = _category_;
        this.name = _name_;
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
                return new com.dslplatform.example.dto.Entity(reader);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream()
                        + ". Expecting null, { or [. Found: " + (char) reader.last());
        }
    }
}
