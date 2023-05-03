package com.javeriana.Study_With_Me.model.exceptions;

import java.io.IOException;

public class NotWindowRunningException extends IOException {
    public NotWindowRunningException(String message) {
        super(message);
    }
}
