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
public class ItemRegraSintatica {
    private TipoToken simbolo;
    private int producao;

    public TipoToken getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(TipoToken simbolo) {
        this.simbolo = simbolo;
    }

    public int getProducao() {
        return producao;
    }

    public void setProducao(int producao) {
        this.producao = producao;
    }

    public ItemRegraSintatica(TipoToken simbolo, int producao) {
        this.simbolo = simbolo;
        this.producao = producao;
    }
    
}
