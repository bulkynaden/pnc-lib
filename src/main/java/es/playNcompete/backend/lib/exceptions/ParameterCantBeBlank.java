package es.playNcompete.backend.lib.exceptions;

public class ParameterCantBeBlank extends RuntimeException {
    public ParameterCantBeBlank(String parameter) {
        super(String.format("Parameter %s can't be blank", parameter));
    }
}
