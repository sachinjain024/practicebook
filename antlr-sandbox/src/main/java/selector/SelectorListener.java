// Generated from Selector.g4 by ANTLR 4.5.3

package selector;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SelectorParser}.
 */
public interface SelectorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SelectorParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(SelectorParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectorParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(SelectorParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectorParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(SelectorParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectorParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(SelectorParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectorParser#pathComponent}.
	 * @param ctx the parse tree
	 */
	void enterPathComponent(SelectorParser.PathComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectorParser#pathComponent}.
	 * @param ctx the parse tree
	 */
	void exitPathComponent(SelectorParser.PathComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectorParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(SelectorParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectorParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(SelectorParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectorParser#fieldWithIndex}.
	 * @param ctx the parse tree
	 */
	void enterFieldWithIndex(SelectorParser.FieldWithIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectorParser#fieldWithIndex}.
	 * @param ctx the parse tree
	 */
	void exitFieldWithIndex(SelectorParser.FieldWithIndexContext ctx);
}