package com.compiler.compiler_app.Service;

import com.compiler.compiler_app.Parser.gramaticaBaseVisitor;
import com.compiler.compiler_app.Parser.gramaticaParser;

import java.util.HashMap;
import java.util.Map;

public class EvaluadorVisitor extends gramaticaBaseVisitor<Double>{
    private final Map<String, Double> memoria = new HashMap<>();

    public Map<String, Double> getMemoria(){
        return memoria;
    }

    @Override
    public Double visitProgram(gramaticaParser.ProgramContext ctx){
        for(gramaticaParser.StatContext stat : ctx.stat()){
            visit(stat);
        }
        return null;
    }

    @Override
    public Double visitStat(gramaticaParser.StatContext ctx){
        return visit(ctx.asignacion());
    }

    @Override
    public Double visitAsignacion(gramaticaParser.AsignacionContext ctx){
        String varNombre = ctx.ID().getText();
        Double valor = visit(ctx.expr());
        memoria.put(varNombre, valor);
        return valor;
    }

    @Override
    public Double visitSumaRestaExpr(gramaticaParser.SumaRestaExprContext ctx){
        Double izquierdo = visit(ctx.expr(0));
        Double derecho = visit(ctx.expr(1));
        return ctx.getChild(1).getText().equals("+") ? izquierdo + derecho : izquierdo - derecho;
    }

    @Override
    public Double visitMultiplicacionExpr(gramaticaParser.MultiplicacionExprContext ctx){
        Double izquierdo = visit(ctx.expr(0));
        Double derecho = visit(ctx.expr(1));
        return ctx.getChild(1).getText().equals("*") ? izquierdo * derecho : izquierdo / derecho;
    }

    @Override
    public Double visitPotenciaExpr(gramaticaParser.PotenciaExprContext ctx){
        Double base = visit(ctx.expr(0));
        Double exponente = visit(ctx.expr(1));
        return Math.pow(base, exponente);
    }

    @Override
    public Double visitParenExpr(gramaticaParser.ParenExprContext ctx){
        return visit(ctx.expr());
    }

    @Override
    public Double visitIdExpr(gramaticaParser.IdExprContext ctx){
        String varNombre = ctx.ID().getText();
        if(!memoria.containsKey(varNombre)){
            throw new RuntimeException("Variable no definida: " + varNombre);
        }
        return memoria.get(varNombre);
    }

    @Override
    public Double visitNumExpr(gramaticaParser.NumExprContext ctx){
        return Double.parseDouble(ctx.NUM().getText());
    }
}
