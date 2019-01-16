package by.zapolski.exeptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogginException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public LogginException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class LoggingException2{
    private static Logger logger = Logger.getLogger("LoggingException2");
    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LogginExceptions{
    public static void main(String[] args) {
        try {
            throw new LogginException();
        }catch (LogginException e){
            System.err.println("Перехвачено "+e);
        }

        try {
            throw new LogginException();
        }catch (LogginException e){
            System.err.println("Перехвачено "+e);
        }

        try {
            throw new NullPointerException();
        }catch (NullPointerException e){
            LoggingException2.logException(e);
        }

    }
}

