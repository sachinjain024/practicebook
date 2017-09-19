package selector;

import com.google.protobuf.InvalidProtocolBufferException;
import selector.proto.output.SchemaProtos;

/**
 * Listener used for walking through the parse tree.
 */
public class MySelectorBaseListener extends SelectorBaseListener {

  Object result;
  byte[] storeData;

  public MySelectorBaseListener(String key, Model model) throws InvalidProtocolBufferException {
    // This is an equivalent call to fetching data from actual persistent storage
    storeData = model.getValue(key);

    // Build object from byte array
    result = SchemaProtos.Schema.parseFrom(storeData);
  }

  public Object getResult() {
    return result;
  }

  @Override
  public void exitField(SelectorParser.FieldContext ctx) {
    // System.out.println("Field matched: " + ctx.FIELDNAME());
    String methodName = getMethodName(ctx.FIELDNAME().getText());

    java.lang.reflect.Method method;

    try {
      method = result.getClass().getMethod(methodName);
      result = method.invoke(result);
    } catch (Exception e) {
      System.out.println("Exception in getting methodName: " + methodName);
      e.printStackTrace();
    }
  }

  @Override
  public void exitFieldWithIndex(SelectorParser.FieldWithIndexContext ctx) {
    // System.out.println("Field with Index is matched: " + ctx.FIELDNAME() + "[" + ctx.INDEX() + "]");
    String methodName = getMethodName(ctx.FIELDNAME().getText());
    int index = Integer.parseInt(ctx.INDEX().getText());

    java.lang.reflect.Method method;

    try {
      method = result.getClass().getMethod(methodName, int.class);
      result = method.invoke(result, index);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Protobuf follows convention of get + CamelCase, we will follow the same to generate methodName
  public String getMethodName(String attribute) {
    return "get" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
  }
}
