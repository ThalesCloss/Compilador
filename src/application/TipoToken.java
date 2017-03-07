/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author tcloss
 */
public enum TipoToken {
     
    PROGRAMA("programa"),
    VIRGULA(","),
    INICIO("inicio"),
    FIM("fim"),
    PONTO_VIRGULA(";"),
    LEIA("leia"),
    ESCREVA("escreva"),
    INTEIRO("inteiro"),
    IDENTIFICADOR("id"),
    NUMERICO("numerico"),
    STRING("string"),
    ATRIBUICAO("<-"),
    CONDICIONAL("$se"),
    REPETICAO("$enquanto"),
    BLOCO("$$"),
    COMPARADOR("comparador"),
    ABRE_PARENTESES("("),
    FECHA_PARENTESES(")"),
    MAIS("+"),
    MENOS("-"),
    DIVISAO("/"),
    MULTIPLICACAO("*"),
    INVALIDO("inválido"),
    VAZIO("vazio"),
    DOLLAR("$"),
    NT_PROGRAMA("<PROGRAMA>"),
    NT_VARIAVEIS("<VARIAVEIS>"),
    NT_LISTA_COMANDOS("<LISTA_COMANDOS>"),
    NT_SUB_VAR("<SUB_VAR>"),
    NT_COMANDO("<COMANDO>"),
    NT_SAIDA("<SAIDA>"),
    NT_EXPRESSAO("<EXPRESSAO>"),
    NT_ATRIBUIR("<ATRIBUIR>"),
    NT_ATRIBUIR_CNT("<ATRIBUIR_CNT>"),
    NT_MULT_DIV("<MULT_DIV>"),
    NT_MAIS_MENOS("<MAIS_MENOS>"),
    NT_CONDICIONAL("<CONDICIONAL>"),
    NT_REPETICAO("<REPETICAO>"),
    NT_BLOCO("<BLOCO>"),
    NT_COMPARADOR("<COMPARADOR>"),
    NT_TERMO("<TERMO>"),
    NT_TERMO_CNT("<TERMO_CNT>"),
    NT_FATOR("<FATOR>"),
    NT_FATOR_CNT("<FATOR_CNT>"),
    NT_MAIS("<MAIS>"),
    NT_MENOS("<MENOS>"),
    NT_MULT("<MULT>"),
    NT_DIV("<DIV>"),
    NT_COMPARDOR("<COMPARADOR>"),
    NT_OPERADOR_LG("<OPERADOR_LG>");
    
    private final String nome;
    TipoToken(String nome){
       this.nome=nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
