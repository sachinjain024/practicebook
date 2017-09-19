package selector;

import com.google.protobuf.InvalidProtocolBufferException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import selector.proto.output.SchemaProtos;

import java.io.IOException;

public class SelectorSample {
  public static Model m = new Model();

  public static void main(String[] args) throws IOException {
    //Reading the DSL script
    //InputStream is = ClassLoader.getSystemResourceAsStream("selector/selectorInputData.txt");
    //CharStream cs = new ANTLRInputStream(is);

    String ind_players = "ind_players";
    String aus_players = "aus_players";

    // Adding some hardcoded values here. Eventually they will be written using write api
    // write api does not need to parse selector so we are statically doing it
    m.setValue(ind_players, buildData(100, "Virat Kohli", "vkohli@wrogn.com", "Male", "+91-123456789"));

    getValue(ind_players, "people[0].phones[0].number");
    getValue(ind_players, "people[0].email");

    m.setValue(aus_players, buildData(200, "Steve Smith", "ssmith@mel.com", "Male", "+65-123456789"));

    getValue(aus_players, "people[0].phones[0].number");
    getValue(aus_players, "people[0].email");
  }

  public static byte[] buildData(int id, String name, String email, String gender, String phone) {
    SchemaProtos.Person person =
      SchemaProtos.Person.newBuilder()
        .setId(id)
        .setName(name)
        .setEmail(email)
        .setGEndER(gender)
        .addPhones(
          SchemaProtos.Person.PhoneNumber.newBuilder()
            .setNumber(phone)
            .setType(SchemaProtos.Person.PhoneType.HOME))
        .build();

    SchemaProtos.Schema.Builder data = SchemaProtos.Schema.newBuilder();

    return data
      .addPeople(person)
      .build()
      .toByteArray();
  }

  public static Byte[] getValue(String keyName, String selector) throws InvalidProtocolBufferException {
    // Loading the DSL script into the ANTLR stream.
    CharStream cs = new ANTLRInputStream(selector);

    //Passing the input to the lexer to create tokens
    SelectorLexer lexer = new SelectorLexer(cs);

    CommonTokenStream tokens1 = new CommonTokenStream(lexer);

    //Passing the tokens to the parser to create the parse tree.
    SelectorParser parser = new SelectorParser(tokens1);

    MySelectorBaseListener listener = new MySelectorBaseListener(keyName, m);

    //Adding the listener to facilitate walking through parse tree.
    parser.addParseListener(listener);

    // System.out.println("Invoking parser on given input..");

    try {
      //invoking the parser.
      parser.selector();
    } catch (Exception e) {
      System.out.println("Exception in parsing given expression: " + selector);
    }

    System.out.println("Key: " + keyName + " Selector: " + selector + "       Value: " + listener.getResult());

    // Remove the listener
    parser.removeParseListener(listener);

    return null;
  }
}
