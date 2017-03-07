/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import exceptions.LoggerException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;

/**
 *
 * @author tcloss
 */
public class LoggerComp {

    private static BufferedWriter buffer;
    private static LoggerComp instacia;
    private Calendar dateTime;
    private DateFormat dFormat= new SimpleDateFormat("H:m:ss - d/MM/y");
    private static boolean verbose=false;
    private LoggerComp() throws LoggerException {
        try {
            buffer = new BufferedWriter(new FileWriter("/home/tcloss/Documentos/IFMT/Compiladores/logger.log", true));
            dateTime=Calendar.getInstance(Locale.getDefault());
        } catch (IOException ex) {
            throw new LoggerException("Erro ao abrir o arquivo de log ", ex);
        }
    }

    public static LoggerComp getInstace() throws LoggerException {
        if (instacia == null) {
            instacia = new LoggerComp();
        }
        return instacia;
    }
    public static LoggerComp getInstace(boolean verbose) throws LoggerException{
        LoggerComp.verbose=verbose;
        return LoggerComp.getInstace();
    }

    public void closeLogger() throws LoggerException {
        try {
            buffer.close();
        } catch (IOException ex) {
            throw new LoggerException("Erro ao fechar o arquivo de log", ex);
        } finally {
            instacia = null;
        }
    }
    
    public void escreverLog(String log) throws LoggerException{
        
        try {
            String logger=dFormat.format(dateTime.getTimeInMillis())+" - "+log+"\n";
            if(LoggerComp.verbose)
                System.out.print(logger);
            buffer.write(logger);
            buffer.flush();
        } catch (IOException ex) {
            throw new LoggerException("Erro ao escrever log", ex);
        }
    }
}
