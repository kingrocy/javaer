// Generated from /Users/dushaoyun/work/workspace/java/yun/javaer/antlr4/src/main/java/com/yunhui/parse/Test.g4 by ANTLR 4.8
package com.yunhui.parse.generated.test;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#calc}.
	 * @param ctx the parse tree
	 */
	void enterCalc(TestParser.CalcContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#calc}.
	 * @param ctx the parse tree
	 */
	void exitCalc(TestParser.CalcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(TestParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(TestParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(TestParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(TestParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlank(TestParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlank(TestParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParen(TestParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParen(TestParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(TestParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(TestParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(TestParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(TestParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(TestParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(TestParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(TestParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(TestParser.LiteralContext ctx);
}