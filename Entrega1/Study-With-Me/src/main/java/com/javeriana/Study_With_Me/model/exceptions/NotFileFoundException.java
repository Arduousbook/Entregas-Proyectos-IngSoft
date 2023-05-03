package com.javeriana.Study_With_Me.model.exceptions;

import java.io.IOException;

public class NotFileFoundException extends IOException {
    public NotFileFoundException(String message) {
        super(message);
    }
}
