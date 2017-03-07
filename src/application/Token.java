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
public class Token {
    String lexema;
    int posicao_inicial,posicao_final,linha;
    TipoToken tipo;

    public Token(TipoToken tipo, String lexema, int posicao_inicial, int linha, int posicao_final) {
        this.lexema = lexema;
        this.posicao_inicial = posicao_inicial;
        this.posicao_final = posicao_final;
        this.tipo = tipo;
        this.linha=linha;
    }
      
    

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public void setTipo(TipoToken tipo) {
        this.tipo = tipo;
    }

    

    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getPosicao_inicial() {
        return posicao_inicial;
    }

    public void setPosicao_inicial(int posicao_inicial) {
        this.posicao_inicial = posicao_inicial;
    }

    public int getPosicao_final() {
        return posicao_final;
    }

    public void setPosicao_final(int posicao_final) {
        this.posicao_final = posicao_final;
    }
    

}
