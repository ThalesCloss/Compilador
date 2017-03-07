/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import exceptions.LoggerException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class Sintatico {
    private List<Token> tokens;
    private List<ItemTabelaSintatica> tabela;
    private List<List<TipoToken>> regras;
    private List<TipoToken> fila;
    private LoggerComp log;
    public void a(List<Token> tokens) throws SintaticoException, LoggerException{
        log=LoggerComp.getInstace();
        Gramatica g = new Gramatica();
        fila=new ArrayList<>();
        this.tokens=tokens;
        this.tabela=g.getTabela();
        this.regras=g.getRegras();
        fila.add(TipoToken.NT_PROGRAMA);
        fila.add(TipoToken.DOLLAR);
        int tk=0;
        while(!fila.isEmpty()){
            if(fila.get(0).equals(TipoToken.VAZIO) | fila.get(0).equals(TipoToken.DOLLAR))
            {
                log.escreverLog("Desempilhar "+fila.get(0));
                fila.remove(0);
            }else if(fila.get(0).ordinal()<TipoToken.NT_PROGRAMA.ordinal()){
                if(fila.get(0).equals(tokens.get(tk).getTipo())){
                    log.escreverLog("Token "+tokens.get(tk).getTipo()+"-> desempilha "+fila.get(0));
                    tk++;
                    fila.remove(0);
                }
                else{
                    log.escreverLog("Erro sintático: Era esperado "+fila.get(0)+" mas foi encontrado "+tokens.get(tk).getTipo()+" na linha "+tokens.get(tk).getLinha()+" coluna "+tokens.get(tk).getPosicao_inicial()+" lexema "+tokens.get(tk).getLexema() );
                    throw new SintaticoException("Erro sintático: Era esperado "+fila.get(0)+" mas foi encontrado "+tokens.get(tk).getTipo()+" na linha "+tokens.get(tk).getLinha()+" coluna "+tokens.get(tk).getPosicao_inicial()+" lexema "+tokens.get(tk).getLexema() );
                }
            }
            else{
                log.escreverLog("Simbolos-> "+fila.get(0)+":"+tokens.get(tk).getTipo()+" Aplicar Regra "+g.localizaRegra(fila.get(0), tokens.get(tk).getTipo()));
                int r=g.localizaRegra(fila.get(0), tokens.get(tk).getTipo());
                fila.remove(0);
                int x=0;
                for(TipoToken tm : g.carregarRegra(r)){
                    log.escreverLog("Empilhar "+tm);
                    fila.add(x,tm);
                    x++;
                }
                
            }
        }
    
    }
    
}
