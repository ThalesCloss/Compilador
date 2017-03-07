/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.List;

/**
 *
 * @author tcloss
 */
public class ItemTabelaSintatica {
    private TipoToken simbolo;
    private List<ItemRegraSintatica> itensSimbolo;

    public TipoToken getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(TipoToken simbolo) {
        this.simbolo = simbolo;
    }

    public List<ItemRegraSintatica> getItensSimbolo() {
        return itensSimbolo;
    }

    public void setItensSimbolo(List<ItemRegraSintatica> itensSimbolo) {
        this.itensSimbolo = itensSimbolo;
    }

    public ItemTabelaSintatica(TipoToken simbolo, List<ItemRegraSintatica> itensSimbolo) {
        this.simbolo = simbolo;
        this.itensSimbolo = itensSimbolo;
    }
    
    
}
