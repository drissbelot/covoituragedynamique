/*
 * 
 */
package com.covoiturage.server;

// TODO: Auto-generated Javadoc
/**
 * Exception that gets thrown when Objectify get() returns too many results.
 */
@SuppressWarnings("serial")
public class TooManyResultsException extends Exception
{

       /**
        * Instantiates a new too many results exception.
        */
       public TooManyResultsException()
       {
               super();
       }

       /**
        * Instantiates a new too many results exception.
        *
        * @param t the t
        */
       public TooManyResultsException(Throwable t)
       {
               super(t);
       }

       /**
        * Instantiates a new too many results exception.
        *
        * @param msg the msg
        */
       public TooManyResultsException(String msg)
       {
               super(msg);
       }

       /**
        * Instantiates a new too many results exception.
        *
        * @param msg the msg
        * @param t the t
        */
       public TooManyResultsException(String msg, Throwable t)
       {
               super(msg, t);
       }

}
