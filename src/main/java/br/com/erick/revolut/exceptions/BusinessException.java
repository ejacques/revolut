package br.com.erick.revolut.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final String... args) {
        super(String.format(message, args));
    }

}
