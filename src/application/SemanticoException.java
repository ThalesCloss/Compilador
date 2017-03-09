/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import exceptions.LoggerException;

/**
 *
 * @author tcloss
 */
public class SemanticoException extends Exception{

    public SemanticoException(String message) throws LoggerException {
        super(message);
        LoggerComp.getInstace().escreverLog("Erro semântico "+message);
    }

    public SemanticoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
