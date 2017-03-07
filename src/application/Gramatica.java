/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class Gramatica {

    private final List<ItemTabelaSintatica> tabela;
    private final List<List<TipoToken>> regras;
    

    public Gramatica() {
        tabela = new ArrayList<>();
        
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_PROGRAMA,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.PROGRAMA, 0)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_LISTA_COMANDOS, 
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]
                        {
                            new ItemRegraSintatica(TipoToken.FIM, 6),
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 5),
                            new ItemRegraSintatica(TipoToken.LEIA, 5),
                            new ItemRegraSintatica(TipoToken.ESCREVA, 5),
                            new ItemRegraSintatica(TipoToken.CONDICIONAL, 5),
                            new ItemRegraSintatica(TipoToken.BLOCO, 6),
                            new ItemRegraSintatica(TipoToken.REPETICAO, 5),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_COMANDO,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 12),
                            new ItemRegraSintatica(TipoToken.LEIA, 7),
                            new ItemRegraSintatica(TipoToken.ESCREVA, 8),
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 12),
                            new ItemRegraSintatica(TipoToken.CONDICIONAL, 18),
                            new ItemRegraSintatica(TipoToken.REPETICAO, 19),
                        }))));
        
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_VARIAVEIS,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.FIM, 4),
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 4),
                            new ItemRegraSintatica(TipoToken.LEIA, 4),
                            new ItemRegraSintatica(TipoToken.ESCREVA, 4),
                            new ItemRegraSintatica(TipoToken.INTEIRO, 1),
                            new ItemRegraSintatica(TipoToken.CONDICIONAL, 4),
                            new ItemRegraSintatica(TipoToken.REPETICAO, 4),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_CONDICIONAL,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.CONDICIONAL, 20)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_REPETICAO,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.REPETICAO, 21)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_BLOCO,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.BLOCO, 22)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_SUB_VAR,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.VIRGULA, 2),
                            new ItemRegraSintatica(TipoToken.PONTO_VIRGULA, 3)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_TERMO,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 26),
                            new ItemRegraSintatica(TipoToken.NUMERICO, 26),
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 26),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_SAIDA,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 9),
                            new ItemRegraSintatica(TipoToken.STRING, 10),
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 11),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_ATRIBUIR,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 13),
                            new ItemRegraSintatica(TipoToken.NUMERICO, 14),
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 15),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_EXPRESSAO,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 23),
                            new ItemRegraSintatica(TipoToken.NUMERICO, 23),
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 23),
                        }))));
        
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_COMPARADOR,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 40)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_TERMO_CNT,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.FECHA_PARENTESES, 25),
                            new ItemRegraSintatica(TipoToken.MENOS, 24),
                            new ItemRegraSintatica(TipoToken.MAIS, 24),
                            new ItemRegraSintatica(TipoToken.COMPARADOR, 25),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_FATOR_CNT,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.FECHA_PARENTESES, 28),
                            new ItemRegraSintatica(TipoToken.MULTIPLICACAO, 27),
                            new ItemRegraSintatica(TipoToken.DIVISAO, 27),
                            new ItemRegraSintatica(TipoToken.MAIS, 28),
                            new ItemRegraSintatica(TipoToken.MENOS, 28),
                            new ItemRegraSintatica(TipoToken.COMPARADOR, 28),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_MAIS_MENOS,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MENOS, 33),
                            new ItemRegraSintatica(TipoToken.MAIS, 32),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_MAIS,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MAIS, 34)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_MENOS,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MENOS, 35)
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_MULT_DIV,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MULTIPLICACAO, 36),
                            new ItemRegraSintatica(TipoToken.DIVISAO, 37),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_MULT,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MULTIPLICACAO, 38),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_DIV,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.DIVISAO, 39),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_FATOR,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.IDENTIFICADOR, 30),
                            new ItemRegraSintatica(TipoToken.NUMERICO, 31),
                            new ItemRegraSintatica(TipoToken.ABRE_PARENTESES, 29),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_OPERADOR_LG,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.COMPARADOR, 41),
                        }))));
        tabela.add(new ItemTabelaSintatica(TipoToken.NT_ATRIBUIR_CNT,
                new ArrayList<>(Arrays.asList(
                        new ItemRegraSintatica[]{
                            new ItemRegraSintatica(TipoToken.MULTIPLICACAO, 16),
                            new ItemRegraSintatica(TipoToken.DIVISAO, 16),
                            new ItemRegraSintatica(TipoToken.MENOS, 17),
                            new ItemRegraSintatica(TipoToken.MAIS, 17),
                        }))));

        regras = new ArrayList<>();
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.PROGRAMA, TipoToken.IDENTIFICADOR, TipoToken.INICIO, TipoToken.NT_VARIAVEIS, TipoToken.NT_LISTA_COMANDOS, TipoToken.FIM})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.INTEIRO, TipoToken.IDENTIFICADOR, TipoToken.NT_SUB_VAR, TipoToken.PONTO_VIRGULA, TipoToken.NT_VARIAVEIS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VIRGULA, TipoToken.IDENTIFICADOR})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VAZIO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VAZIO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_COMANDO, TipoToken.NT_LISTA_COMANDOS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VAZIO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.LEIA, TipoToken.IDENTIFICADOR, TipoToken.PONTO_VIRGULA})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.ESCREVA, TipoToken.NT_SAIDA, TipoToken.PONTO_VIRGULA})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.IDENTIFICADOR})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.STRING})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.ABRE_PARENTESES, TipoToken.NT_EXPRESSAO, TipoToken.FECHA_PARENTESES})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.IDENTIFICADOR, TipoToken.ATRIBUICAO, TipoToken.NT_ATRIBUIR, TipoToken.PONTO_VIRGULA})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.IDENTIFICADOR})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NUMERICO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.ABRE_PARENTESES, TipoToken.NT_EXPRESSAO, TipoToken.FECHA_PARENTESES})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MULT_DIV, TipoToken.NT_EXPRESSAO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MAIS_MENOS, TipoToken.NT_EXPRESSAO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_CONDICIONAL})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_REPETICAO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.CONDICIONAL, TipoToken.NT_COMPARADOR, TipoToken.NT_BLOCO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.REPETICAO, TipoToken.NT_COMPARADOR, TipoToken.NT_BLOCO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.BLOCO, TipoToken.NT_LISTA_COMANDOS, TipoToken.BLOCO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_TERMO, TipoToken.NT_TERMO_CNT})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MAIS_MENOS, TipoToken.NT_TERMO, TipoToken.NT_TERMO_CNT})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VAZIO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_FATOR, TipoToken.NT_FATOR_CNT})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MULT_DIV, TipoToken.NT_FATOR, TipoToken.NT_FATOR_CNT})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.VAZIO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.ABRE_PARENTESES, TipoToken.NT_EXPRESSAO, TipoToken.FECHA_PARENTESES})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.IDENTIFICADOR})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NUMERICO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MAIS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MENOS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.MAIS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.MENOS})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_MULT})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.NT_DIV})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.MULTIPLICACAO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.DIVISAO})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.ABRE_PARENTESES, TipoToken.NT_EXPRESSAO, TipoToken.NT_OPERADOR_LG, TipoToken.NT_EXPRESSAO, TipoToken.FECHA_PARENTESES})));
        regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{TipoToken.COMPARADOR})));
        //regras.add(new ArrayList<>(Arrays.asList(new TipoToken[]{})));
    }

    /*/*
    list pilha inicia NT_PROGRAMA
    enquanto nao for vazia
    se for um terminal e os tk iguais remove da pilha senao erro
    senao carrega as regras na pilha
     */

    public List<ItemTabelaSintatica> getTabela() {
        return tabela;
    }

    public List<List<TipoToken>> getRegras() {
        return regras;
    }
    
    public int localizaRegra(TipoToken nt_token, TipoToken tt_token){
        for(ItemTabelaSintatica tmp : tabela)
        {
            if(tmp.getSimbolo().equals(nt_token))
            {
                for(ItemRegraSintatica tmps : tmp.getItensSimbolo()){
                    if(tmps.getSimbolo().equals(tt_token)){
                        return tmps.getProducao();
                    }
                }
            }
        }
        return -1;
    }
    public List<TipoToken> carregarRegra(int index){
        return regras.get(index);
    }
}
