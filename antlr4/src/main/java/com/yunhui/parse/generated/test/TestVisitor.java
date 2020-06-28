// Generated from /Users/dushaoyun/work/workspace/java/yun/javaer/antlr4/src/main/java/com/yunhui/parse/Test.g4 by ANTLR 4.8
package com.yunhui.parse.generated.test;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestParser#calc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalc(TestParser.CalcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(TestParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(TestParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link TestParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(TestParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(TestParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(TestParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(TestParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(TestParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TestParser.LiteralContext ctx);
}