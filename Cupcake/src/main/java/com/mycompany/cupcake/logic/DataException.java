package com.mycompany.cupcake.logic;

/**
 *
 * @author Henning
 */
public class DataException extends Exception {

    /**
     *
     */
    public DataException() {
    }

    /**
     *
     * @param string
     */
    public DataException(String string) {
        super(string);
    }

    /**
     *
     * @param string
     * @param thrwbl
     */
    public DataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public DataException(Throwable thrwbl) {
        super(thrwbl);
    }
}