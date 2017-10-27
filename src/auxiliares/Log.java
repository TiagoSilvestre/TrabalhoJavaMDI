/*
 * Classe responsavel por gravar açoes em um arquivo log
 *
 */
package auxiliares;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 *
 * @author ts
 */
public class Log extends File{

    String logFileName = "d:\\logFile.txt";
    
    public Log() {
    }
    /*
    * Retorna a data e hora atual como strig
    */
    private String generateCurrentDateTime(){
        String data = "dd/MM/yyyy";
	String hora = "h:mm a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        
        return data1 + " as " + hora1;
    }
    /*
    *
    *Retorna o texto a ser impresso no arquivo
    */
    private String textToLog(String user, String text){
        return this.generateCurrentDateTime() + " - " + user + " " + text;
    }
    
     /*
    *
    *Retorna o texto a ser impresso no arquivo
    */   
    public void saveInLogFile(String user, String textToAppend) throws IOException{ 
        FileWriter arq = new FileWriter(this.logFileName);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf(this.textToLog(user, textToAppend));
        arq.close();
    }
    
    
}
