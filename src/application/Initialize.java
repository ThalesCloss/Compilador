/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import exceptions.LoggerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tcloss
 */
public class Initialize {

    public static void main(String[] args) {
        String file = null;
        boolean lexico = false;
        for (int i = 0; i < args.length; i++) {
            
            if (args[i].contains("-f=")) {
                file=args[i].substring(3);
                
            }
            else
            if (args[i].contains("-l")) {
                lexico = true;
            }
        }
        if (file != null) {
            try {
                                            
                LoggerComp log = LoggerComp.getInstace(true);
                Lexico analisador = new Lexico();
                List<Token> tokens = analisador.analisarArquivo(new File(file));
                System.out.println("Análise Lexica em andamento...");
                if (lexico) {
                    Iterator i = tokens.iterator();
                    System.out.printf("%-20s%-20s%-10s%-10s%n", "Token", "Lexema", "Posicao", "Linha");
                    while (i.hasNext()) {
                        Token tk = (Token) i.next();
                        System.out.printf("%-20s%-20s%-10s%-10s%n", tk.getTipo().toString(), tk.getLexema(), tk.getPosicao_inicial(), tk.getLinha());
                    }
                }
                Sintatico s = new Sintatico();
                s.a(tokens);
                System.out.println("Análise Lexica concluída");
            } catch (FileNotFoundException ex) {
                System.err.println("Erro ao carregar o arquivo fonte");
            } catch (SintaticoException ex) {
                System.err.println(ex.getMessage());
            } catch (LoggerException ex) {
                System.err.println(ex.getMessage());
            }
        }
        else{
            System.out.printf("%s%n", "Compilador");
            System.out.printf("%-20s%s%n","Parâmetro","Descricao");
            System.out.printf("%-20s%s%n","-h","Exibe está tela de ajuda");
            System.out.printf("%-20s%s%n","-l","Habilita a saída da tabela do analisador lexico");
            System.out.printf("%-20s%s%n","-f=","Localização do arquivo que será analisado");
        }

    }

}
