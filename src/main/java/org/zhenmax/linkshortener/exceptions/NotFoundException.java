package org.zhenmax.linkshortener.exceptions;

public class NotFoundException extends  RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
