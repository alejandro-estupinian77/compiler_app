grammar gramatica;

// Regla inicial: un programa es una o más instrucciones
program: stat+ ;

// Una instrucción puede ser una asignación con o sin punto y coma
stat: asignacion ';'? ;

// Asignación usando ==
asignacion: ID '==' expr ;

// Expresiones con jerarquía de operadores
expr
    : expr '^' expr            # potenciaExpr
    | expr ('*' | '/') expr    # multiplicacionExpr
    | expr ('+' | '-') expr    # sumaRestaExpr
    | '(' expr ')'             # parenExpr
    | ID                       # idExpr
    | NUM                      # numExpr
    ;

// TOKENS

ID: [a-zA-Z_][a-zA-Z0-9_]* ;      // Identificadores
NUM: [0-9]+ ;                     // Números enteros

WS: [ \t\r\n]+ -> skip ;          // Espacios en blanco ignorados
