/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import exceptions.LoggerException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tcloss
 */
public class Semantico {

    private List<String> variaveis;
    private List<Token> tokens;

    public Semantico(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void analiseSemantica() throws SemanticoException, LoggerException {
        ListIterator<Token> itT = tokens.listIterator();
        variaveis = new ArrayList<>();
        while (itT.hasNext()) {
            Token ax = itT.next();
            if (ax.getTipo() == TipoToken.PROGRAMA) {
                variaveis.add(itT.next().getLexema());
            }
            if (ax.getTipo() == TipoToken.INTEIRO) {
                while (itT.hasNext()) {
                    ax = itT.next();
                    if (ax.getTipo() != TipoToken.PONTO_VIRGULA) {
                        if (ax.getTipo() == TipoToken.IDENTIFICADOR) {
                            if (variaveis.contains(ax.getLexema())) {
                                throw new SemanticoException("Variável " + ax.getLexema() + " redeclarada na linha " + ax.getLinha() + " coluna " + ax.getPosicao_inicial());
                            } else {
                                variaveis.add(ax.getLexema());
                            }
                        }
                    } else {
                        break;
                    }
                }

            }
            if (ax.getTipo() == TipoToken.IDENTIFICADOR) {
                if (!variaveis.contains(ax.getLexema())) {
                    throw new SemanticoException("Variável " + ax.getLexema() + " utilizada na linha " + ax.getLinha() + " coluna " + ax.getPosicao_inicial() + " não foi declarada");
                }
            }
            if (ax.getTipo() == TipoToken.DIVISAO) {
                Token axn = itT.next();
                if (axn.getTipo() == TipoToken.NUMERICO) {
                    if (Integer.parseInt(axn.getLexema()) == 0) {
                        throw new SemanticoException("Encontrada divisão por zero  na linha " + ax.getLinha() + " coluna " + ax.getPosicao_inicial());
                    }
                }
            }
        }

    }

}
