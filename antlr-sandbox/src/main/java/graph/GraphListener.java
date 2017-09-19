// Generated from Graph.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphParser}.
 */
public interface GraphListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GraphParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(GraphParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(GraphParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#vertex}.
	 * @param ctx the parse tree
	 */
	void enterVertex(GraphParser.VertexContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#vertex}.
	 * @param ctx the parse tree
	 */
	void exitVertex(GraphParser.VertexContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#edge}.
	 * @param ctx the parse tree
	 */
	void enterEdge(GraphParser.EdgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#edge}.
	 * @param ctx the parse tree
	 */
	void exitEdge(GraphParser.EdgeContext ctx);
}