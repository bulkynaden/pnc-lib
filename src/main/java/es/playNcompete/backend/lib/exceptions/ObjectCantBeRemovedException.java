package es.playNcompete.backend.lib.exceptions;

public class ObjectCantBeRemovedException extends RuntimeException {
    public ObjectCantBeRemovedException(String entityName) {
        super("Object " + entityName + " can't be removed.");
    }
}