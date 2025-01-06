// Exercises: Write a Java program that has an example of handling an exception and an example of "ducking" an exception.

package com.example.exceptions;

import java.io.IOException;

public class ExceptionExercise {

    public static void main(String[] args) {
        // Example of handling an exception
        try {
            int result = divide(10, 0); // This will throw an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Example of "ducking" an exception
        try {
            readFile("nonexistent_file.txt"); // Ducking IOException to main method
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Method to demonstrate handling an exception
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Method to demonstrate "ducking" an exception
    public static void readFile(String filePath) throws IOException {
        // Simulating an I/O operation that can throw an IOException
        throw new IOException("File not found: " + filePath);
    }
}

// Explanation:
// 	1.	Handling an Exception:
// 	    •	The divide method throws an ArithmeticException when trying to divide by zero.
// 	    •	In main, we use a try-catch block to handle this exception and print an error message.
// 	2.	Ducking an Exception:
// 	    •	The readFile method declares throws IOException, meaning it “ducks” the responsibility of handling the exception to the caller (main in this case).
// 	    •	In main, we use another try-catch block to handle the exception when calling readFile.

// This approach highlights both handling an exception locally and propagating it to the caller for handling.


// The reason the divide method does not need to declare an exception in its signature (using throws) is because ArithmeticException is an unchecked exception.

// Key Points:
// 	1.	Unchecked Exceptions:
// 	    •	ArithmeticException is a subclass of RuntimeException, which is part of the unchecked exceptions in Java.
// 	    •	Unchecked exceptions do not need to be declared in the method signature using throws.
// 	    •	They are typically programming errors (e.g., dividing by zero, null pointer access) that the Java compiler does not require you to explicitly handle or propagate.
// 	2.	Checked Exceptions:
// 	    •	These exceptions (e.g., IOException) must be declared in the method signature if they are not handled within the method. This is because the Java compiler enforces handling or propagation of checked exceptions to ensure safe and predictable behavior.

// Example:

// Unchecked Exception (ArithmeticException) - No "throws" required
// public static int divide(int a, int b) {
//     if (b == 0) {
//         throw new ArithmeticException("Cannot divide by zero");
//     }
//     return a / b;
// }

// Checked Exception (IOException) - "throws" is required
// public static void readFile(String filePath) throws IOException {
//     throw new IOException("File not found: " + filePath);
// }

// Why No throws in divide:
// 	•	ArithmeticException is part of unchecked exceptions, so Java does not enforce the method to declare it with throws in the method signature.
// 	•	The exception can still propagate to the caller, but the caller does not have to handle it explicitly unless needed.


// Ducking vs Handling

// When risky code is written that has the possibility of throwing an exception, it can be dealt with in one of two ways:

// 	•   Handling means that the risky code is placed inside a try/catch block
//  •   Declaring means that the type of exception to be thrown is listed in the method signature with the throws keyword. This is also called "ducking" the exception - you let the code which calls the method deal with it.

// 1. Throwing and Ducking an Exception

// When you throw an exception, you’re essentially “raising” it. If you also include throws in the method signature, you’re indicating that this method is ducking responsibility for handling the exception, passing it up to the calling method to handle.

// Example of Throwing and Ducking:

// Method throws the exception (ducks handling it)
public static void divideNumbers(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero"); // Throwing an exception
    }
    System.out.println("Result: " + (a / b));
}

// In this case:
// 	•	The method throws an exception when dividing by zero.
// 	•	The method ducks the responsibility to handle the exception because it declares throws ArithmeticException in the signature.

// 2. Handling with Try-Catch

// When you call a method that throws an exception, you need to either:
// 	1.	Handle it with a try-catch block, or
// 	2.	Continue ducking it by adding throws in your method’s signature.

// Example of Handling with Try-Catch:

public static void main(String[] args) {
    try {
        divideNumbers(10, 0); // Calling a method that throws an exception
    } catch (ArithmeticException e) {
        System.out.println("Caught Exception: " + e.getMessage()); // Handling the exception
    }
}

// Here:
// 	•	The exception is handled inside the try-catch block.
// 	•	Instead of propagating the exception further, the program gracefully recovers by printing an error message.

// Summary
// 	1.	Throwing: Raising an exception when an error occurs (throw new Exception();).
// 	2.	Ducking: Declaring the exception in the method signature (throws Exception), passing responsibility to the caller.
// 	3.	Handling: Using a try-catch block to catch and respond to the exception, preventing it from crashing the program.

// Can You Throw, Duck, and Handle in One Program?

// Yes! Here’s a full example:

public static void main(String[] args) {
    try {
        riskyOperation(); // Calls a method that ducks the exception
    } catch (IOException e) { // Handles the exception here
        System.out.println("Handled IOException: " + e.getMessage());
    }
}

// Ducks the IOException
public static void riskyOperation() throws IOException {
    // Throws the actual exception
    throw new IOException("Something went wrong!");
}

// This demonstrates the complete flow:
// 	1.	The exception is thrown in riskyOperation.
// 	2.	It is ducked by riskyOperation, passing it to main.
// 	3.	The exception is finally handled in the try-catch block in main.


// When an exceptional condition occurs in the course of a Java program, a special class called an Exception can be thrown, which indicates that something went wrong during the execution of the program. If the exception is not handled anywhere in the program, it will propagate up through the call stack until it is handled by the JVM which then terminates the program.