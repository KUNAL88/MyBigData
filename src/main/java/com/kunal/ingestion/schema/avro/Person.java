/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.kunal.ingestion.schema.avro;

import java.io.Serializable;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord,Serializable{
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"com.kunal.ingestion.schema.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"username\",\"type\":[\"string\",\"null\"]},{\"name\":\"email_address\",\"type\":[\"string\",\"null\"]},{\"name\":\"phone_number\",\"type\":[\"string\",\"null\"]},{\"name\":\"first_name\",\"type\":[\"string\",\"null\"]},{\"name\":\"last_name\",\"type\":[\"string\",\"null\"]},{\"name\":\"middle_name\",\"type\":[\"string\",\"null\"]},{\"name\":\"sex\",\"type\":[\"string\",\"null\"]},{\"name\":\"birthdate\",\"type\":[\"string\",\"null\"]},{\"name\":\"join_date\",\"type\":[\"string\",\"null\"]},{\"name\":\"previous_logins\",\"type\":[\"int\",\"null\"]},{\"name\":\"last_ip\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int id;
  @Deprecated public java.lang.CharSequence username;
  @Deprecated public java.lang.CharSequence email_address;
  @Deprecated public java.lang.CharSequence phone_number;
  @Deprecated public java.lang.CharSequence first_name;
  @Deprecated public java.lang.CharSequence last_name;
  @Deprecated public java.lang.CharSequence middle_name;
  @Deprecated public java.lang.CharSequence sex;
  @Deprecated public java.lang.CharSequence birthdate;
  @Deprecated public java.lang.CharSequence join_date;
  @Deprecated public java.lang.Integer previous_logins;
  @Deprecated public java.lang.CharSequence last_ip;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Person() {}

  /**
   * All-args constructor.
   */
  public Person(java.lang.Integer id, java.lang.CharSequence username, java.lang.CharSequence email_address, java.lang.CharSequence phone_number, java.lang.CharSequence first_name, java.lang.CharSequence last_name, java.lang.CharSequence middle_name, java.lang.CharSequence sex, java.lang.CharSequence birthdate, java.lang.CharSequence join_date, java.lang.Integer previous_logins, java.lang.CharSequence last_ip) {
    this.id = id;
    this.username = username;
    this.email_address = email_address;
    this.phone_number = phone_number;
    this.first_name = first_name;
    this.last_name = last_name;
    this.middle_name = middle_name;
    this.sex = sex;
    this.birthdate = birthdate;
    this.join_date = join_date;
    this.previous_logins = previous_logins;
    this.last_ip = last_ip;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return username;
    case 2: return email_address;
    case 3: return phone_number;
    case 4: return first_name;
    case 5: return last_name;
    case 6: return middle_name;
    case 7: return sex;
    case 8: return birthdate;
    case 9: return join_date;
    case 10: return previous_logins;
    case 11: return last_ip;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: username = (java.lang.CharSequence)value$; break;
    case 2: email_address = (java.lang.CharSequence)value$; break;
    case 3: phone_number = (java.lang.CharSequence)value$; break;
    case 4: first_name = (java.lang.CharSequence)value$; break;
    case 5: last_name = (java.lang.CharSequence)value$; break;
    case 6: middle_name = (java.lang.CharSequence)value$; break;
    case 7: sex = (java.lang.CharSequence)value$; break;
    case 8: birthdate = (java.lang.CharSequence)value$; break;
    case 9: join_date = (java.lang.CharSequence)value$; break;
    case 10: previous_logins = (java.lang.Integer)value$; break;
    case 11: last_ip = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'username' field.
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }

  /**
   * Sets the value of the 'username' field.
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'email_address' field.
   */
  public java.lang.CharSequence getEmailAddress() {
    return email_address;
  }

  /**
   * Sets the value of the 'email_address' field.
   * @param value the value to set.
   */
  public void setEmailAddress(java.lang.CharSequence value) {
    this.email_address = value;
  }

  /**
   * Gets the value of the 'phone_number' field.
   */
  public java.lang.CharSequence getPhoneNumber() {
    return phone_number;
  }

  /**
   * Sets the value of the 'phone_number' field.
   * @param value the value to set.
   */
  public void setPhoneNumber(java.lang.CharSequence value) {
    this.phone_number = value;
  }

  /**
   * Gets the value of the 'first_name' field.
   */
  public java.lang.CharSequence getFirstName() {
    return first_name;
  }

  /**
   * Sets the value of the 'first_name' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.first_name = value;
  }

  /**
   * Gets the value of the 'last_name' field.
   */
  public java.lang.CharSequence getLastName() {
    return last_name;
  }

  /**
   * Sets the value of the 'last_name' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.last_name = value;
  }

  /**
   * Gets the value of the 'middle_name' field.
   */
  public java.lang.CharSequence getMiddleName() {
    return middle_name;
  }

  /**
   * Sets the value of the 'middle_name' field.
   * @param value the value to set.
   */
  public void setMiddleName(java.lang.CharSequence value) {
    this.middle_name = value;
  }

  /**
   * Gets the value of the 'sex' field.
   */
  public java.lang.CharSequence getSex() {
    return sex;
  }

  /**
   * Sets the value of the 'sex' field.
   * @param value the value to set.
   */
  public void setSex(java.lang.CharSequence value) {
    this.sex = value;
  }

  /**
   * Gets the value of the 'birthdate' field.
   */
  public java.lang.CharSequence getBirthdate() {
    return birthdate;
  }

  /**
   * Sets the value of the 'birthdate' field.
   * @param value the value to set.
   */
  public void setBirthdate(java.lang.CharSequence value) {
    this.birthdate = value;
  }

  /**
   * Gets the value of the 'join_date' field.
   */
  public java.lang.CharSequence getJoinDate() {
    return join_date;
  }

  /**
   * Sets the value of the 'join_date' field.
   * @param value the value to set.
   */
  public void setJoinDate(java.lang.CharSequence value) {
    this.join_date = value;
  }

  /**
   * Gets the value of the 'previous_logins' field.
   */
  public java.lang.Integer getPreviousLogins() {
    return previous_logins;
  }

  /**
   * Sets the value of the 'previous_logins' field.
   * @param value the value to set.
   */
  public void setPreviousLogins(java.lang.Integer value) {
    this.previous_logins = value;
  }

  /**
   * Gets the value of the 'last_ip' field.
   */
  public java.lang.CharSequence getLastIp() {
    return last_ip;
  }

  /**
   * Sets the value of the 'last_ip' field.
   * @param value the value to set.
   */
  public void setLastIp(java.lang.CharSequence value) {
    this.last_ip = value;
  }

  /** Creates a new Person RecordBuilder */
  public static com.kunal.ingestion.schema.avro.Person.Builder newBuilder() {
    return new com.kunal.ingestion.schema.avro.Person.Builder();
  }
  
  /** Creates a new Person RecordBuilder by copying an existing Builder */
  public static com.kunal.ingestion.schema.avro.Person.Builder newBuilder(com.kunal.ingestion.schema.avro.Person.Builder other) {
    return new com.kunal.ingestion.schema.avro.Person.Builder(other);
  }
  
  /** Creates a new Person RecordBuilder by copying an existing Person instance */
  public static com.kunal.ingestion.schema.avro.Person.Builder newBuilder(com.kunal.ingestion.schema.avro.Person other) {
    return new com.kunal.ingestion.schema.avro.Person.Builder(other);
  }
  
  /**
   * RecordBuilder for Person instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
    implements org.apache.avro.data.RecordBuilder<Person> {

    private int id;
    private java.lang.CharSequence username;
    private java.lang.CharSequence email_address;
    private java.lang.CharSequence phone_number;
    private java.lang.CharSequence first_name;
    private java.lang.CharSequence last_name;
    private java.lang.CharSequence middle_name;
    private java.lang.CharSequence sex;
    private java.lang.CharSequence birthdate;
    private java.lang.CharSequence join_date;
    private java.lang.Integer previous_logins;
    private java.lang.CharSequence last_ip;

    /** Creates a new Builder */
    private Builder() {
      super(com.kunal.ingestion.schema.avro.Person.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.kunal.ingestion.schema.avro.Person.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.username)) {
        this.username = data().deepCopy(fields()[1].schema(), other.username);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email_address)) {
        this.email_address = data().deepCopy(fields()[2].schema(), other.email_address);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.phone_number)) {
        this.phone_number = data().deepCopy(fields()[3].schema(), other.phone_number);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.first_name)) {
        this.first_name = data().deepCopy(fields()[4].schema(), other.first_name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.last_name)) {
        this.last_name = data().deepCopy(fields()[5].schema(), other.last_name);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.middle_name)) {
        this.middle_name = data().deepCopy(fields()[6].schema(), other.middle_name);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.sex)) {
        this.sex = data().deepCopy(fields()[7].schema(), other.sex);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.birthdate)) {
        this.birthdate = data().deepCopy(fields()[8].schema(), other.birthdate);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.join_date)) {
        this.join_date = data().deepCopy(fields()[9].schema(), other.join_date);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.previous_logins)) {
        this.previous_logins = data().deepCopy(fields()[10].schema(), other.previous_logins);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.last_ip)) {
        this.last_ip = data().deepCopy(fields()[11].schema(), other.last_ip);
        fieldSetFlags()[11] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Person instance */
    private Builder(com.kunal.ingestion.schema.avro.Person other) {
            super(com.kunal.ingestion.schema.avro.Person.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.username)) {
        this.username = data().deepCopy(fields()[1].schema(), other.username);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email_address)) {
        this.email_address = data().deepCopy(fields()[2].schema(), other.email_address);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.phone_number)) {
        this.phone_number = data().deepCopy(fields()[3].schema(), other.phone_number);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.first_name)) {
        this.first_name = data().deepCopy(fields()[4].schema(), other.first_name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.last_name)) {
        this.last_name = data().deepCopy(fields()[5].schema(), other.last_name);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.middle_name)) {
        this.middle_name = data().deepCopy(fields()[6].schema(), other.middle_name);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.sex)) {
        this.sex = data().deepCopy(fields()[7].schema(), other.sex);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.birthdate)) {
        this.birthdate = data().deepCopy(fields()[8].schema(), other.birthdate);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.join_date)) {
        this.join_date = data().deepCopy(fields()[9].schema(), other.join_date);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.previous_logins)) {
        this.previous_logins = data().deepCopy(fields()[10].schema(), other.previous_logins);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.last_ip)) {
        this.last_ip = data().deepCopy(fields()[11].schema(), other.last_ip);
        fieldSetFlags()[11] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.Integer getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'username' field */
    public java.lang.CharSequence getUsername() {
      return username;
    }
    
    /** Sets the value of the 'username' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.username = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'username' field has been set */
    public boolean hasUsername() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'username' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearUsername() {
      username = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'email_address' field */
    public java.lang.CharSequence getEmailAddress() {
      return email_address;
    }
    
    /** Sets the value of the 'email_address' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setEmailAddress(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.email_address = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'email_address' field has been set */
    public boolean hasEmailAddress() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'email_address' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearEmailAddress() {
      email_address = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'phone_number' field */
    public java.lang.CharSequence getPhoneNumber() {
      return phone_number;
    }
    
    /** Sets the value of the 'phone_number' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setPhoneNumber(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.phone_number = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'phone_number' field has been set */
    public boolean hasPhoneNumber() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'phone_number' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearPhoneNumber() {
      phone_number = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'first_name' field */
    public java.lang.CharSequence getFirstName() {
      return first_name;
    }
    
    /** Sets the value of the 'first_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.first_name = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'first_name' field has been set */
    public boolean hasFirstName() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'first_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearFirstName() {
      first_name = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'last_name' field */
    public java.lang.CharSequence getLastName() {
      return last_name;
    }
    
    /** Sets the value of the 'last_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.last_name = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'last_name' field has been set */
    public boolean hasLastName() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'last_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearLastName() {
      last_name = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'middle_name' field */
    public java.lang.CharSequence getMiddleName() {
      return middle_name;
    }
    
    /** Sets the value of the 'middle_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setMiddleName(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.middle_name = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'middle_name' field has been set */
    public boolean hasMiddleName() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'middle_name' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearMiddleName() {
      middle_name = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'sex' field */
    public java.lang.CharSequence getSex() {
      return sex;
    }
    
    /** Sets the value of the 'sex' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setSex(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.sex = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'sex' field has been set */
    public boolean hasSex() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'sex' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearSex() {
      sex = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'birthdate' field */
    public java.lang.CharSequence getBirthdate() {
      return birthdate;
    }
    
    /** Sets the value of the 'birthdate' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setBirthdate(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.birthdate = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'birthdate' field has been set */
    public boolean hasBirthdate() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'birthdate' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearBirthdate() {
      birthdate = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'join_date' field */
    public java.lang.CharSequence getJoinDate() {
      return join_date;
    }
    
    /** Sets the value of the 'join_date' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setJoinDate(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.join_date = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'join_date' field has been set */
    public boolean hasJoinDate() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'join_date' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearJoinDate() {
      join_date = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'previous_logins' field */
    public java.lang.Integer getPreviousLogins() {
      return previous_logins;
    }
    
    /** Sets the value of the 'previous_logins' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setPreviousLogins(java.lang.Integer value) {
      validate(fields()[10], value);
      this.previous_logins = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'previous_logins' field has been set */
    public boolean hasPreviousLogins() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'previous_logins' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearPreviousLogins() {
      previous_logins = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'last_ip' field */
    public java.lang.CharSequence getLastIp() {
      return last_ip;
    }
    
    /** Sets the value of the 'last_ip' field */
    public com.kunal.ingestion.schema.avro.Person.Builder setLastIp(java.lang.CharSequence value) {
      validate(fields()[11], value);
      this.last_ip = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'last_ip' field has been set */
    public boolean hasLastIp() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'last_ip' field */
    public com.kunal.ingestion.schema.avro.Person.Builder clearLastIp() {
      last_ip = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    public Person build() {
      try {
        Person record = new Person();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.username = fieldSetFlags()[1] ? this.username : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.email_address = fieldSetFlags()[2] ? this.email_address : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.phone_number = fieldSetFlags()[3] ? this.phone_number : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.first_name = fieldSetFlags()[4] ? this.first_name : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.last_name = fieldSetFlags()[5] ? this.last_name : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.middle_name = fieldSetFlags()[6] ? this.middle_name : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.sex = fieldSetFlags()[7] ? this.sex : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.birthdate = fieldSetFlags()[8] ? this.birthdate : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.join_date = fieldSetFlags()[9] ? this.join_date : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.previous_logins = fieldSetFlags()[10] ? this.previous_logins : (java.lang.Integer) defaultValue(fields()[10]);
        record.last_ip = fieldSetFlags()[11] ? this.last_ip : (java.lang.CharSequence) defaultValue(fields()[11]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
