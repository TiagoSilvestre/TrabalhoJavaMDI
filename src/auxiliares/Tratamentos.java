/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

/**
 *
 * @author ts
 */
public class Tratamentos extends Exception {

    public Tratamentos() {
        super("Ocorreu um erro desconhecido!");
    }
    public Tratamentos(String msg) {
        super(msg);
    }

}