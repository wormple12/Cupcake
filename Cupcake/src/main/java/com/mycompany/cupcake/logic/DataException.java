package com.mycompany.cupcake.logic;

/**
 *Custom exception. 
 *Used for the convenience of the programmers in this specific project.
 * @author Henning
 */
public class DataException extends Exception {


    public DataException() {
    }

    public DataException(String string) {
        super(string);
    }

    public DataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataException(Throwable thrwbl) {
        super(thrwbl);
    }
}