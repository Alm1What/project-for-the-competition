package org.example.projectforthecompetition.exception;

public class AdminSelfDeletionException extends CustomException {
    public AdminSelfDeletionException(String message) {
        super(message, 400); // 400 - Bad Request
    }
}
