// Generated from /home/wiktor/IdeaProjects/Optimizer/src/main/antlr4/Python.g4 by ANTLR 4.3
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonParser#key_datum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey_datum(@NotNull PythonParser.Key_datumContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#lpar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLpar(@NotNull PythonParser.LparContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull PythonParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#opt_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt_comma(@NotNull PythonParser.Opt_commaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(@NotNull PythonParser.Expr_listContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Small_statement_1}
	 * labeled alternative in {@link PythonParser#small_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_statement_1(@NotNull PythonParser.Small_statement_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(@NotNull PythonParser.While_stmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Target_1}
	 * labeled alternative in {@link PythonParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_1(@NotNull PythonParser.Target_1Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Small_statement_2}
	 * labeled alternative in {@link PythonParser#small_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_statement_2(@NotNull PythonParser.Small_statement_2Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Small_statement_3}
	 * labeled alternative in {@link PythonParser#small_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_statement_3(@NotNull PythonParser.Small_statement_3Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Small_statement_4}
	 * labeled alternative in {@link PythonParser#small_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_statement_4(@NotNull PythonParser.Small_statement_4Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Target_2}
	 * labeled alternative in {@link PythonParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_2(@NotNull PythonParser.Target_2Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(@NotNull PythonParser.ModuleContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Target_3}
	 * labeled alternative in {@link PythonParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_3(@NotNull PythonParser.Target_3Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Statement_1}
	 * labeled alternative in {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_1(@NotNull PythonParser.Statement_1Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Statement_2}
	 * labeled alternative in {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_2(@NotNull PythonParser.Statement_2Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_3}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_3(@NotNull PythonParser.Expression_3Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_23}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_23(@NotNull PythonParser.Expression_23Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_4}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_4(@NotNull PythonParser.Expression_4Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_24}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_24(@NotNull PythonParser.Expression_24Context ctx);

	/**
	 * Visit a parse tree produced by the {@code IfInstr}
	 * labeled alternative in {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfInstr(@NotNull PythonParser.IfInstrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_5}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_5(@NotNull PythonParser.Expression_5Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(@NotNull PythonParser.Id_listContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_6}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_6(@NotNull PythonParser.Expression_6Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Compound_statement_2}
	 * labeled alternative in {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement_2(@NotNull PythonParser.Compound_statement_2Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Compound_statement_3}
	 * labeled alternative in {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement_3(@NotNull PythonParser.Compound_statement_3Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_1}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_1(@NotNull PythonParser.Expression_1Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Compound_statement_1}
	 * labeled alternative in {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement_1(@NotNull PythonParser.Compound_statement_1Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_2}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_2(@NotNull PythonParser.Expression_2Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(@NotNull PythonParser.ClassdefContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#simple_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_statement(@NotNull PythonParser.Simple_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#key_datum_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey_datum_list(@NotNull PythonParser.Key_datum_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#subscription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscription(@NotNull PythonParser.SubscriptionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_20}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_20(@NotNull PythonParser.Expression_20Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_21}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_21(@NotNull PythonParser.Expression_21Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_22}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_22(@NotNull PythonParser.Expression_22Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Compound_statement_4}
	 * labeled alternative in {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement_4(@NotNull PythonParser.Compound_statement_4Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#rpar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpar(@NotNull PythonParser.RparContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_7}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_7(@NotNull PythonParser.Expression_7Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_8}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_8(@NotNull PythonParser.Expression_8Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(@NotNull PythonParser.FuncdefContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_9}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_9(@NotNull PythonParser.Expression_9Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(@NotNull PythonParser.Statement_listContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_12}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_12(@NotNull PythonParser.Expression_12Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_13}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_13(@NotNull PythonParser.Expression_13Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#expr_list_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list_comma(@NotNull PythonParser.Expr_list_commaContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_14}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_14(@NotNull PythonParser.Expression_14Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_15}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_15(@NotNull PythonParser.Expression_15Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_16}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_16(@NotNull PythonParser.Expression_16Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_17}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_17(@NotNull PythonParser.Expression_17Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_18}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_18(@NotNull PythonParser.Expression_18Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_19}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_19(@NotNull PythonParser.Expression_19Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_10}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_10(@NotNull PythonParser.Expression_10Context ctx);

	/**
	 * Visit a parse tree produced by the {@code Expression_11}
	 * labeled alternative in {@link PythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_11(@NotNull PythonParser.Expression_11Context ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#small_statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_statement_list(@NotNull PythonParser.Small_statement_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(@NotNull PythonParser.SuiteContext ctx);

	/**
	 * Visit a parse tree produced by {@link PythonParser#opt_semicolon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt_semicolon(@NotNull PythonParser.Opt_semicolonContext ctx);
}