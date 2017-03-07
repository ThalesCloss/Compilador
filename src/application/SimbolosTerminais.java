/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tcloss
 */
public class SimbolosTerminais {

    private List<TokenGramatica> tokens;
    private ListIterator it;

    public SimbolosTerminais(List<TokenGramatica> tokens) {
        this.tokens = tokens;
    }

    public SimbolosTerminais() {
        tokens = new ArrayList<TokenGramatica>();
    }

    public void addToken(TokenGramatica tk) {
        tokens.add(tk);
    }

    public TokenGramatica encontrarToken(String busca) {
        it = tokens.listIterator();
        while (it.hasNext()) {
            TokenGramatica tmp = (TokenGramatica) it.next();
            if (tmp.equals(busca)) {
                return tmp;
            }
        }
        return null;
    }

}
