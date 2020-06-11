package com.yunhui.parse.main;

import com.yunhui.parse.generated.test.TestBaseVisitor;
import com.yunhui.parse.generated.test.TestParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/6/5 4:15 下午
 * @Author : dushaoyun
 */
public class TestVisitor extends TestBaseVisitor<Double> {

    public Map<String, Double> vars = new HashMap<>();

    // stmt : ID '=' expr NEWLINE ;
    @Override
    public Double visitAssign(TestParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Double val = visit(ctx.expr());
        vars.put(id, val);
        return val;
    }

    // stmt : expr NEWLINE ;
    @Override
    public Double visitPrintExpr(TestParser.PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        System.out.println(value);
        return .0;
    }

    // expr : INT ;
    @Override
    public Double visitLiteral(TestParser.LiteralContext ctx) {
        return Double.valueOf(ctx.NUMBER().getText());
    }

    // expr : ID ;
    @Override
    public Double visitId(TestParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (vars.containsKey(id)) {
            return vars.get(id);
        }
        return .0;
    }

    // expr : expr op=('*'|'/') expr ;
    @Override
    public Double visitMulDiv(TestParser.MulDivContext ctx) {
        double lhs = visit(ctx.expr(0));
        double rhs = visit(ctx.expr(1));
        if (ctx.op.getType() == TestParser.MUL) {
            return lhs * rhs;
        }
        return lhs / rhs;
    }

    // expr : expr op=('+'|'-') expr ;
    @Override
    public Double visitAddSub(TestParser.AddSubContext ctx) {
        double lhs = visit(ctx.expr(0));
        double rhs = visit(ctx.expr(1));
        if (ctx.op.getType() == TestParser.ADD) {
            return lhs + rhs;
        }
        return lhs - rhs;
    }

    // expr : '(' expr ')' ;
    @Override
    public Double visitParen(TestParser.ParenContext ctx) {
        return visit(ctx.expr());
    }
}
