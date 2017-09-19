package selector;

import selector.proto.output.SchemaProtos;

import java.util.HashMap;

public class Model {
  private HashMap<String, byte[]> store = new HashMap<>();

  public byte[] getValue(String key) {
    return store.get(key);
  }

  public void setValue(String key, byte[] value) {
    store.put(key, value);
  }

  public byte[] buildData() {
    SchemaProtos.Person john =
      SchemaProtos.Person.newBuilder()
        .setId(1234)
        .setName("John Doe")
        .setEmail("jdoe@example.com")
        .setGEndER("Male")
        .addPhones(
          SchemaProtos.Person.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(SchemaProtos.Person.PhoneType.HOME))
        .build();

    SchemaProtos.Person jane =
      SchemaProtos.Person.newBuilder()
        .setId(1234)
        .setName("Jane right")
        .setEmail("jright@example.com")
        .setGEndER("Female")
        .addPhones(
          SchemaProtos.Person.PhoneNumber.newBuilder()
            .setNumber("333-4321")
            .setType(SchemaProtos.Person.PhoneType.HOME))
        .build();

    SchemaProtos.Schema.Builder data = SchemaProtos.Schema.newBuilder();

    return data
      .addPeople(john)
      .addPeople(jane)
      .build()
      .toByteArray();
  }
}
