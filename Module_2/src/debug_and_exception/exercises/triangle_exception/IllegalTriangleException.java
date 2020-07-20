package debug_and_exception.exercises.triangle_exception;

import java.util.Scanner;

public class IllegalTriangleException extends RuntimeException{
    public IllegalTriangleException() {
        super("IllegalTriangleException");
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}
