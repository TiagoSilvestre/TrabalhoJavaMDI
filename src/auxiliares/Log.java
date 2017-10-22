/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.text.SimpleDateFormat;

/**
 *
 * @author ts
 */
public class Log {

    public Log() {
    }
    
    private static String generateCurrentDateTime(){
        String data = "dd/MM/yyyy";
	String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();;
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        
        return data1 + " as " + hora1;
    }
    
    public static void addToFile(String user, String text){
      //  return this.generateCurrentDateTime() + " - " + user + " " + text;
    }
}
