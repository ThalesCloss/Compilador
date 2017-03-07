/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tcloss
 */
public class Lexico {

    private List<Token> tokens;
    private List<TokenGramatica> tokensGramatica;
    private SimbolosTerminais terminais;

    public Lexico() {
        tokensGramatica = new ArrayList<TokenGramatica>();
        tokensGramatica.add(new TokenGramatica(TipoToken.PROGRAMA, "programa"));
        tokensGramatica.add(new TokenGramatica(TipoToken.FIM, "fim"));
        tokensGramatica.add(new TokenGramatica(TipoToken.INICIO, "inicio"));
        tokensGramatica.add(new TokenGramatica(TipoToken.INTEIRO, "inteiro"));
        tokensGramatica.add(new TokenGramatica(TipoToken.LEIA, "leia"));
        tokensGramatica.add(new TokenGramatica(TipoToken.ESCREVA, "escreva"));
        tokensGramatica.add(new TokenGramatica(TipoToken.CONDICIONAL, "\\$se"));
        tokensGramatica.add(new TokenGramatica(TipoToken.REPETICAO, "\\$enquanto"));
        tokensGramatica.add(new TokenGramatica(TipoToken.ABRE_PARENTESES, "\\("));
        tokensGramatica.add(new TokenGramatica(TipoToken.FECHA_PARENTESES, "\\)"));
        tokensGramatica.add(new TokenGramatica(TipoToken.MULTIPLICACAO, "\\*"));
        tokensGramatica.add(new TokenGramatica(TipoToken.MAIS, "\\+"));
        tokensGramatica.add(new TokenGramatica(TipoToken.MENOS, "\\-"));
        tokensGramatica.add(new TokenGramatica(TipoToken.PONTO_VIRGULA, "\\;"));
        tokensGramatica.add(new TokenGramatica(TipoToken.VIRGULA, "\\,"));
        tokensGramatica.add(new TokenGramatica(TipoToken.BLOCO, "\\$\\$"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$e"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$ou"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$menor_que"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$maior_que"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$maior_igual_que"));
        tokensGramatica.add(new TokenGramatica(TipoToken.COMPARADOR, "\\$menor_igual_que"));
        tokensGramatica.add(new TokenGramatica(TipoToken.NUMERICO, "\\d+"));
        tokensGramatica.add(new TokenGramatica(TipoToken.IDENTIFICADOR, "[a-z](\\w*)"));
        tokensGramatica.add(new TokenGramatica(TipoToken.STRING, "(\'([^\']*)\')"));
        tokensGramatica.add(new TokenGramatica(TipoToken.ATRIBUICAO, "(\\<-)"));
        terminais = new SimbolosTerminais(tokensGramatica);
    }

    public List<Token> analisarArquivo(File arquivo) throws FileNotFoundException {
        tokens = new ArrayList<Token>();
        String pattern = "(\\$\\$)|(\\<-)|[a-z](\\w*)|(\\d+)|(\'([^\']*)\')|(\\$([a-z\\_]+))|(\\p{Punct})";
        Pattern r = Pattern.compile(pattern);
        Scanner leitor = new Scanner(arquivo);
        int linha = 0;
        while (leitor.hasNextLine()) {
            Matcher m = r.matcher(leitor.nextLine());
            while (m.find()) {
                TokenGramatica tmp = terminais.encontrarToken(m.group());
                if (tmp != null) {
                    tokens.add(new Token(tmp.getToken(), m.group(), m.start(), linha, m.end()));
                } else {
                    tokens.add(new Token(TipoToken.INVALIDO, m.group(), m.start(), linha, m.end()));
                }
            }
            linha++;
        }

        return tokens;
    }

}
