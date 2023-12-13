package es.playNcompete.backend.lib.exceptions;

public class ParameterCantBeBlankException extends RuntimeException {
    public ParameterCantBeBlankException(String parameter) {
        super(String.format("Parameter %s can't be blank", parameter));
    }
}
