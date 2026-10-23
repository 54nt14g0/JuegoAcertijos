package org.santi.Exception;

public class JuegoNotFoundException extends RuntimeException {
    public JuegoNotFoundException(String message) {
        super(message);
    }
}
