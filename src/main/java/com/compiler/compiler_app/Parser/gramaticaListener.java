package com.compiler.compiler_app.Parser;
// Generated from gramatica.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaParser}.
 */
public interface gramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(gramaticaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(gramaticaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(gramaticaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(gramaticaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(gramaticaParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(gramaticaParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicacionExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacionExpr(gramaticaParser.MultiplicacionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicacionExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacionExpr(gramaticaParser.MultiplicacionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumaRestaExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumaRestaExpr(gramaticaParser.SumaRestaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumaRestaExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumaRestaExpr(gramaticaParser.SumaRestaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code potenciaExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPotenciaExpr(gramaticaParser.PotenciaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code potenciaExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPotenciaExpr(gramaticaParser.PotenciaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(gramaticaParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(gramaticaParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(gramaticaParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(gramaticaParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(gramaticaParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(gramaticaParser.IdExprContext ctx);
}