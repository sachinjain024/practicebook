import org.antlr.v4.*;
import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

// Please resolve the imports for the classes used.
public class GraphDslAntlrSample {
  public static void main(String[] args) throws IOException {
    //Reading the DSL script
    InputStream is = ClassLoader.getSystemResourceAsStream("graphData.gr");

    //Loading the DSL script into the ANTLR stream.
    CharStream cs = new ANTLRInputStream(is);

    //Passing the input to the lexer to create tokens
    GraphLexer lexer = new GraphLexer(cs);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    //Passing the tokens to the parser to create the parse trea.
    GraphParser parser = new GraphParser(tokens);

    //Semantic model to be populated
    Graph g = new Graph();

    //Adding the listener to facilitate walking through parse tree.
    parser.addParseListener(new MyGraphBaseListener(g));

    //invoking the parser.
    parser.graph();

    Graph.printGraph(g);
  }
}
