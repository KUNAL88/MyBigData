/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.kunal.ingestion.schema.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class RawMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RawMessage\",\"namespace\":\"com.kunal.ingestion.schema.avro\",\"fields\":[{\"name\":\"data_blob\",\"type\":[\"null\",\"bytes\"]},{\"name\":\"publish_ts\",\"type\":[\"null\",\"long\"]},{\"name\":\"source\",\"type\":\"string\",\"default\":\"kunal_host\"},{\"name\":\"country\",\"type\":[\"null\",\"string\"],\"default\":\"IN\"},{\"name\":\"city\",\"type\":[\"null\",\"string\"],\"default\":\"blr\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.nio.ByteBuffer data_blob;
  @Deprecated public java.lang.Long publish_ts;
  @Deprecated public java.lang.CharSequence source;
  @Deprecated public java.lang.CharSequence country;
  @Deprecated public java.lang.CharSequence city;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public RawMessage() {}

  /**
   * All-args constructor.
   */
  public RawMessage(java.nio.ByteBuffer data_blob, java.lang.Long publish_ts, java.lang.CharSequence source, java.lang.CharSequence country, java.lang.CharSequence city) {
    this.data_blob = data_blob;
    this.publish_ts = publish_ts;
    this.source = source;
    this.country = country;
    this.city = city;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return data_blob;
    case 1: return publish_ts;
    case 2: return source;
    case 3: return country;
    case 4: return city;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: data_blob = (java.nio.ByteBuffer)value$; break;
    case 1: publish_ts = (java.lang.Long)value$; break;
    case 2: source = (java.lang.CharSequence)value$; break;
    case 3: country = (java.lang.CharSequence)value$; break;
    case 4: city = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'data_blob' field.
   */
  public java.nio.ByteBuffer getDataBlob() {
    return data_blob;
  }

  /**
   * Sets the value of the 'data_blob' field.
   * @param value the value to set.
   */
  public void setDataBlob(java.nio.ByteBuffer value) {
    this.data_blob = value;
  }

  /**
   * Gets the value of the 'publish_ts' field.
   */
  public java.lang.Long getPublishTs() {
    return publish_ts;
  }

  /**
   * Sets the value of the 'publish_ts' field.
   * @param value the value to set.
   */
  public void setPublishTs(java.lang.Long value) {
    this.publish_ts = value;
  }

  /**
   * Gets the value of the 'source' field.
   */
  public java.lang.CharSequence getSource() {
    return source;
  }

  /**
   * Sets the value of the 'source' field.
   * @param value the value to set.
   */
  public void setSource(java.lang.CharSequence value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'country' field.
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'city' field.
   */
  public java.lang.CharSequence getCity() {
    return city;
  }

  /**
   * Sets the value of the 'city' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.city = value;
  }

  /** Creates a new RawMessage RecordBuilder */
  public static com.kunal.ingestion.schema.avro.RawMessage.Builder newBuilder() {
    return new com.kunal.ingestion.schema.avro.RawMessage.Builder();
  }
  
  /** Creates a new RawMessage RecordBuilder by copying an existing Builder */
  public static com.kunal.ingestion.schema.avro.RawMessage.Builder newBuilder(com.kunal.ingestion.schema.avro.RawMessage.Builder other) {
    return new com.kunal.ingestion.schema.avro.RawMessage.Builder(other);
  }
  
  /** Creates a new RawMessage RecordBuilder by copying an existing RawMessage instance */
  public static com.kunal.ingestion.schema.avro.RawMessage.Builder newBuilder(com.kunal.ingestion.schema.avro.RawMessage other) {
    return new com.kunal.ingestion.schema.avro.RawMessage.Builder(other);
  }
  
  /**
   * RecordBuilder for RawMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RawMessage>
    implements org.apache.avro.data.RecordBuilder<RawMessage> {

    private java.nio.ByteBuffer data_blob;
    private java.lang.Long publish_ts;
    private java.lang.CharSequence source;
    private java.lang.CharSequence country;
    private java.lang.CharSequence city;

    /** Creates a new Builder */
    private Builder() {
      super(com.kunal.ingestion.schema.avro.RawMessage.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.kunal.ingestion.schema.avro.RawMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.data_blob)) {
        this.data_blob = data().deepCopy(fields()[0].schema(), other.data_blob);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.publish_ts)) {
        this.publish_ts = data().deepCopy(fields()[1].schema(), other.publish_ts);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.source)) {
        this.source = data().deepCopy(fields()[2].schema(), other.source);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.country)) {
        this.country = data().deepCopy(fields()[3].schema(), other.country);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.city)) {
        this.city = data().deepCopy(fields()[4].schema(), other.city);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing RawMessage instance */
    private Builder(com.kunal.ingestion.schema.avro.RawMessage other) {
            super(com.kunal.ingestion.schema.avro.RawMessage.SCHEMA$);
      if (isValidValue(fields()[0], other.data_blob)) {
        this.data_blob = data().deepCopy(fields()[0].schema(), other.data_blob);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.publish_ts)) {
        this.publish_ts = data().deepCopy(fields()[1].schema(), other.publish_ts);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.source)) {
        this.source = data().deepCopy(fields()[2].schema(), other.source);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.country)) {
        this.country = data().deepCopy(fields()[3].schema(), other.country);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.city)) {
        this.city = data().deepCopy(fields()[4].schema(), other.city);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'data_blob' field */
    public java.nio.ByteBuffer getDataBlob() {
      return data_blob;
    }
    
    /** Sets the value of the 'data_blob' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder setDataBlob(java.nio.ByteBuffer value) {
      validate(fields()[0], value);
      this.data_blob = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'data_blob' field has been set */
    public boolean hasDataBlob() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'data_blob' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder clearDataBlob() {
      data_blob = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'publish_ts' field */
    public java.lang.Long getPublishTs() {
      return publish_ts;
    }
    
    /** Sets the value of the 'publish_ts' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder setPublishTs(java.lang.Long value) {
      validate(fields()[1], value);
      this.publish_ts = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'publish_ts' field has been set */
    public boolean hasPublishTs() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'publish_ts' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder clearPublishTs() {
      publish_ts = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'source' field */
    public java.lang.CharSequence getSource() {
      return source;
    }
    
    /** Sets the value of the 'source' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder setSource(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.source = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'source' field has been set */
    public boolean hasSource() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'source' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder clearSource() {
      source = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'country' field */
    public java.lang.CharSequence getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.country = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'country' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder clearCountry() {
      country = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'city' field */
    public java.lang.CharSequence getCity() {
      return city;
    }
    
    /** Sets the value of the 'city' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.city = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'city' field has been set */
    public boolean hasCity() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'city' field */
    public com.kunal.ingestion.schema.avro.RawMessage.Builder clearCity() {
      city = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public RawMessage build() {
      try {
        RawMessage record = new RawMessage();
        record.data_blob = fieldSetFlags()[0] ? this.data_blob : (java.nio.ByteBuffer) defaultValue(fields()[0]);
        record.publish_ts = fieldSetFlags()[1] ? this.publish_ts : (java.lang.Long) defaultValue(fields()[1]);
        record.source = fieldSetFlags()[2] ? this.source : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.country = fieldSetFlags()[3] ? this.country : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.city = fieldSetFlags()[4] ? this.city : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
