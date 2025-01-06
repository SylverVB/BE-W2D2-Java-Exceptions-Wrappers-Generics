// Errors, Exceptions, and Compilation Errors

// In Java, both errors and exceptions are subclasses of the java.lang.Throwable class. An error in Java signifies a critical issue that typically arises from factors beyond the control of the application, leading to abnormal program behavior. These errors can manifest as compile-time issues, hindering successful compilation, or as run-time issues, impacting program execution. It is essential to address errors, encompassing both compile-time and run-time, before entering the compilation and execution phases. It is important to note you should never handle an error even though it is possible.

// Alternatively, exceptions in Java denote unexpected or undesirable events that occur during program execution (run-time), causing a disruption in the regular flow of program instructions. Unlike errors, exceptions do not necessarily indicate critical issues but rather unexpected conditions that the program can handle. It is crucial to distinguish between errors, which are categorized as compile-time, run-time, or logical, and exceptions, which represent unforeseen events during runtime. Addressing both errors and exceptions appropriately contributes to the overall robustness and reliability of the Java application.

// In the Java compilation process, the compiler checks that any checked exceptions that could be thrown are handled (via either try/catch block or the throws declaration on the method signature). If this is not the case, the compiler cannot compile the code. This is an example of a compilation error - not an exception. Exceptions are never thrown during the compilation process - they can only be thrown when the code is executing (running). Compilation errors generally occur due to improper syntax, like calling a method that doesn't exist, forgetting a semicolon on a line, using the wrong data type, using a reserved keyword incorrectly, and as we've shown, not handling checked exceptions properly.

// Checked Exceptions vs Unchecked Exceptions

// Checked Exceptions

// Checked exceptions must be handled at compile-time using a try-catch block or declared with the throws keyword. They typically occur due to external issues outside the program’s control (e.g., file I/O, database access).

// Examples of Checked Exceptions

// 	1.	IOException
// 	    •	Explanation: This occurs when an input or output operation fails, such as reading from a file that does not exist.
// 	    •	Example:

import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent_file.txt");
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}


//  2.	FileNotFoundException
//      •	Explanation: A subclass of IOException, this is thrown specifically when attempting to open a file that does not exist.
//      •	Example:

try {
    FileReader reader = new FileReader("nonexistent.txt");
} catch (FileNotFoundException e) {
    System.out.println("Error: File not found");
}


//  3.	SQLException
//      •	Explanation: This occurs during database access errors, such as an invalid query or inability to connect to the database.
//      •	Example:

import java.sql.*;

public class DatabaseExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}


//  4.	ClassNotFoundException
//      •	Explanation: Thrown when a required class is not found at runtime.
//      •	Example:

try {
    Class.forName("com.unknown.Class");
} catch (ClassNotFoundException e) {
    System.out.println("Class not found: " + e.getMessage());
}


//  5.	InterruptedException
//      •	Explanation: Thrown when a thread is interrupted while sleeping, waiting, or otherwise paused.
//      •	Example:

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        });
        thread.start();
    }
}


//  6.  MalformedURLException
//      •   Explanation: Thrown when a URL is not correctly formatted or invalid.
//      •   Example:

import java.net.*;

public class URLExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("htt://invalid-url");
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }
}


//  7.  NoSuchMethodException
//      •   Explanation: Thrown when trying to access a method that doesn't exist in the specified class.
//      •   Example:

import java.lang.reflect.*;

public class NoSuchMethodExample {
    public static void main(String[] args) {
        try {
            Method method = String.class.getMethod("nonExistentMethod");
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + e.getMessage());
        }
    }
}


//  8.  InstantiationException
//      •   Explanation: Thrown when trying to instantiate an abstract class or an interface.
//      •   Example:

public class InstantiationExample {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("java.util.List");
            Object obj = cls.newInstance(); // InstantiationException
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}


//  9.  BindException
//      •   Explanation: Thrown when an attempt to bind a socket to a specific port fails because the port is already in use.
//      •   Example:

import java.net.*;

public class BindExceptionExample {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            ServerSocket anotherSocket = new ServerSocket(8080); // BindException
        } catch (BindException e) {
            System.out.println("Port already in use: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}


//  10.  SocketException
//      •   Explanation: Thrown when there is an error in creating or using a socket.
//      •   Example:

import java.net.*;

public class SocketExceptionExample {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
        } catch (SocketException e) {
            System.out.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}


// Unchecked Exceptions

// Unchecked exceptions occur at runtime and are generally caused by programming errors, such as invalid logic or improper usage of APIs. These are subclasses of RuntimeException. The compiler does not enforce handling these exceptions.

// Examples of Unchecked Exceptions

// 	1.	ArithmeticException
// 	    •	Explanation: This occurs when an illegal arithmetic operation, such as division by zero, is performed.
// 	    •	Example:

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int result = 10 / 0; // ArithmeticException
    }
}


//  2.	NullPointerException
//      •	Explanation: This occurs when attempting to access a method or field on a null object reference.
//      •	Example:

public class NullPointerExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length()); // NullPointerException
    }
}


//  3.	ArrayIndexOutOfBoundsException
//      •	Explanation: This is thrown when trying to access an invalid index in an array.
//      •	Example:

public class ArrayExceptionExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
    }
}


//  4.	ClassCastException
//      •	Explanation: Thrown when attempting to cast an object to a subclass it doesn’t belong to.
//      •	Example:

public class CastExample {
    public static void main(String[] args) {
        Object obj = "String";
        Integer num = (Integer) obj; // ClassCastException
    }
}


//  5.	NumberFormatException
//      •	Explanation: This occurs when trying to convert a string into a numeric type, but the string is not properly formatted.
//      •	Example:

public class NumberFormatExample {
    public static void main(String[] args) {
        int num = Integer.parseInt("abc"); // NumberFormatException
    }
}

//  6.   IllegalArgumentException
//      •    Explanation: Thrown when a method receives an illegal or inappropriate argument.
//      •    Example:

public class IllegalArgumentExample {
    public static void main(String[] args) {
        setAge(-5); // IllegalArgumentException
    }
    
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}

//  7.   IllegalStateException
//      •    Explanation: Thrown when a method is invoked at an illegal or inappropriate time, such as calling a method when the object is in an invalid state.
//      •    Example:

public class IllegalStateExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Element");
        list.clear();
        list.get(0); // IllegalStateException
    }
}

//  8.   UnsupportedOperationException
//      •    Explanation: Thrown to indicate that the requested operation is not supported.
//      •    Example:

public class UnsupportedOperationExample {
    public static void main(String[] args) {
        List<String> list = Collections.unmodifiableList(new ArrayList<>());
        list.add("New Element"); // UnsupportedOperationException
    }
}

//  9.   NoSuchElementException
//      •    Explanation: Thrown when one tries to access an element that is not present, such as when calling next() on an iterator that has no more elements.
//      •    Example:

public class NoSuchElementExample {
    public static void main(String[] args) {
        Iterator<String> iterator = new ArrayList<String>().iterator();
        iterator.next(); // NoSuchElementException
    }
}

//  10.   ConcurrentModificationException
//      •    Explanation: Thrown when a collection is modified concurrently while it is being iterated.
//      •    Example:

public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Item1");
        Iterator<String> iterator = list.iterator();
        list.add("Item2");  // ConcurrentModificationException
    }
}

//  11.   StackOverflowError
//      •    Explanation: Occurs when the call stack overflows, usually due to deep or infinite recursion.
//      •    Example:

public class StackOverflowExample {
    public static void main(String[] args) {
        recursiveMethod(); // StackOverflowError
    }
    
    public static void recursiveMethod() {
        recursiveMethod(); // Recursive call
    }
}

//  12.   IllegalMonitorStateException
//      •    Explanation: Thrown when a thread has attempted to wait on an object’s monitor or notify other threads without owning the appropriate lock.
//      •    Example:

public class IllegalMonitorStateExample {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        obj.wait();  // IllegalMonitorStateException
    }
}

// Comparison Table

// Aspect	| Checked Exceptions                                    |   Unchecked Exceptions                      |
// Hierarchy| Subclasses of Exception (excluding RuntimeException)  |	Subclasses of RuntimeException            |
// Compiler Enforcement |	Must be handled or declared             |	No need to handle or declare              |
// Examples	| IOException, SQLException	                            |   NullPointerException, ArithmeticException |
// Cause	| External issues (I/O, DB access, etc.)	            |   Logical/programming errors                |

// Key Takeaway
// 	•	Handle checked exceptions because they are expected to occur due to external factors and require planned recovery.
// 	•	Avoid handling unchecked exceptions unless absolutely necessary; instead, focus on fixing the code logic that causes them.

// Summary (Real World Application): 

// Checked Exceptions should be used for predictable, but unpreventable errors that are reasonable to recover from.

// Unchecked Exceptions should be used for everything else.

//  •   Predictable but unpreventable: The caller did everything within their power to validate the input parameters, but some condition outside their control has caused the operation to fail. For example, you try reading a file but someone deletes it between the time you check if it exists and the time the read operation begins. By declaring a checked exception, you are telling the caller to anticipate this failure.
//  •   Reasonable to recover from: There is no point telling callers to anticipate exceptions that they cannot recover from. If a user attempts to read from an non-existing file, the caller can prompt them for a new filename. On the other hand, if the method fails due to a programming bug (invalid method arguments or buggy method implementation) there is nothing the application can do to fix the problem in mid-execution. The best it can do is log the problem and wait for the developer to fix it at a later time.
//  •   Unless the exception you are throwing meets all of the above conditions it should use an Unchecked Exception.
//  •   Reevaluate at every level: Sometimes the method catching the checked exception isn't the right place to handle the error. In that case, consider what is reasonable for your own callers. If the exception is predictable, unpreventable and reasonable for them to recover from then you should throw a checked exception yourself. If not, you should wrap the exception in an unchecked exception. If you follow this rule you will find yourself converting checked exceptions to unchecked exceptions and vice versa depending on what layer you are in.
//  •   For both checked and unchecked exceptions, use the right abstraction level. For example, a code repository with two different implementations (database and filesystem) should avoid exposing implementation-specific details by throwing SQLException or IOException. Instead, it should wrap the exception in an abstraction that spans all implementations (e.g. RepositoryException).



// Hierarchy:

// The exception class hierarchy starts with the Throwable class which inherits from Object. Any object which is a Throwable can be "thrown" in a program by the JVM or by the programmer using the throws keyword. The Exception and Error classes both extend Throwable. An Error represents something that went so horribly wrong with your application that you should not attempt to recover from. Some examples of errors are:
// 	•	ExceptionInInitializerError
// 	•	OutOfMemoryError
// 	•	StackOverflowError
// Exception is a general exception class which provides an abstraction for all exceptions. There are many subclasses of Exception.

// Hierarchy Explanation

// 	1.	Throwable Class
// 	    •	The root of the exception hierarchy. Any object of a subclass of Throwable can be “thrown” (via throw) and caught (via try-catch).
// 	•	It is divided into two main categories:
// 	    •	Error: Represents serious problems that an application cannot reasonably recover from.
// 	    •	Exception: Represents conditions that a program might want to catch and handle.

// 	2.	Error Class
// 	    •	Subclass of Throwable.
// 	    •	Represents system-level issues beyond the program’s control.
// 	    •	These issues are critical and typically lead to program termination. They should not be handled in most cases.
// 	    •	Examples:
// 	        •	OutOfMemoryError: Thrown when the JVM runs out of memory.
// 	        •	StackOverflowError: Thrown when the call stack exceeds its limit, often due to infinite recursion.
// 	        •	ExceptionInInitializerError: Thrown if an exception occurs during static initialization of a class.

// Example of Error:

public class ErrorExample {
    public static void main(String[] args) {
        try {
            recursiveMethod(); // Will cause a StackOverflowError
        } catch (StackOverflowError e) {
            System.out.println("This should not be handled!");
        }
    }

    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }
}


// 	3.	Exception Class
// 	    •	Subclass of Throwable.
// 	    •	Represents recoverable issues in a program.
// 	    •	Exceptions can be caught and handled using a try-catch block or declared with throws.
// 	    •	Checked exceptions (e.g., IOException, SQLException) require handling at compile-time.
// 	    •	Unchecked exceptions (e.g., NullPointerException, ArithmeticException) occur at runtime and may or may not be handled.

// Example of Exception:

import java.io.*;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

// Key Concepts from the Sentence About Hierarchy

// 	1.	“Thrown by the JVM or by the programmer”
// 	    •	The JVM throws exceptions or errors automatically during runtime when certain conditions occur (e.g., ArithmeticException for division by zero, OutOfMemoryError when memory runs out).
// 	    •	Programmers can also throw exceptions using the throw keyword.

// Example:

public class ManualThrowExample {
    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("Manual exception throw");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}


// 	2.	“Error represents something that went so horribly wrong”
// 	    •	Errors usually indicate severe problems such as hardware failures or JVM limitations.
// 	    •	Programs should not attempt to handle errors as they are typically unrecoverable.

// Example of OutOfMemoryError:

import java.util.*;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        try {
            List<int[]> list = new ArrayList<>();
            while (true) {
                list.add(new int[Integer.MAX_VALUE]); // Causes OutOfMemoryError
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Memory exhausted: " + e.getMessage());
        }
    }
}


// 	3.	“Exception is a general exception class”
// 	    •	The Exception class is the parent for all exceptions.
// 	    •	It provides a general abstraction for both checked and unchecked exceptions.

// Example of an Exception hierarchy:

import java.io.*;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            System.out.println("Caught IOException (parent of FileNotFoundException)");
        }
    }
}

// Summary
// 	•	Hierarchy:
// Object → Throwable → (Error, Exception)
// 	•	Errors: Serious problems (e.g., OutOfMemoryError, StackOverflowError) that should not be handled.
// 	•	Exceptions: Recoverable issues that can be handled programmatically (e.g., IOException, NullPointerException).

// By understanding the hierarchy, you can decide whether an issue should be handled (exceptions) or simply acknowledged (errors).


// Conclusion about hierarchy:

// All classes that extend Exception (except for RuntimeException and its subclasses) are checked exceptions. This means they must either be caught using a try-catch block or declared in the method signature using the throws keyword. These are the exceptions that the compiler forces you to handle or declare because they are not guaranteed to occur during runtime and could indicate problems that the developer should anticipate and handle explicitly.

// Key points:
// 	1.	Checked Exceptions:
// 	•	These are exceptions that extend Exception but do not extend RuntimeException.
// 	•	They are checked by the compiler at compile-time, which requires the programmer to either handle them with a try-catch block or declare them in the method signature using throws.
// 	•	Example: IOException, SQLException, ParseError (as in your example).
// 	2.	Unchecked Exceptions:
// 	•	These are exceptions that extend RuntimeException, which is a subclass of Exception.
// 	•	They are not checked by the compiler at compile-time, meaning the compiler does not require them to be caught or declared in the method signature.
// 	•	They usually represent programming errors, such as logic mistakes or improper API usage.
// 	•	Example: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, etc.

// To summarize:
// 	•	Checked exceptions: These extend Exception (but not RuntimeException). They must be handled or declared in the method signature.
// 	•	Unchecked exceptions: These extend RuntimeException and are not required to be handled or declared in the method signature.

// So, while the ParseError class you provided extends Exception, it is a checked exception and must be either handled with a try-catch block or declared in the method signature using throws. On the other hand, if ParseError extended RuntimeException, it would be an unchecked exception and wouldn’t require mandatory handling.

public class ParseError extends Exception {
   public ParseError(String message) {
         // Create a ParseError object containing
         // the given message as its error message.
      super(message);
   }
}


// Extends Exception Vs Extends RuntimeException

// Key Points:
// 	1.	Exception is a parent class for both checked exceptions and unchecked exceptions.
// 	•	Checked exceptions are classes that extend Exception but not RuntimeException.
// 	•	Unchecked exceptions are classes that extend RuntimeException, which in turn extends Exception.

// 2. If a class extends Exception, does it make it a checked exception?

// Yes, if a class extends Exception but not RuntimeException, it is always a checked exception.

// This is because RuntimeException is a special subclass of Exception that makes exceptions unchecked. However, any class that directly extends Exception (without extending RuntimeException) will always be a checked exception.

// 3. The relationship:
// 	•	Exception is the parent class of all exceptions (checked and unchecked).
// 	•	RuntimeException is a subclass of Exception specifically for unchecked exceptions.

// So, only classes that extend RuntimeException are unchecked exceptions.

// 4. To summarize the rule:
// 	•	Checked Exception: A class that extends Exception but not RuntimeException is a checked exception. For example, ParseError extends Exception is a checked exception.
// 	•	Unchecked Exception: A class that extends RuntimeException is an unchecked exception. For example, InvalidInputException extends RuntimeException is an unchecked exception.

// Example:
// 	•	Checked Exception:

public class ParseError extends Exception {
    public ParseError(String message) {
        super(message);
    }
}

// This is a checked exception because it extends Exception and not RuntimeException.

// 	•	Unchecked Exception:

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

// This is an unchecked exception because it extends RuntimeException.

// Answer to Your Question:

// If a class extends Exception but not RuntimeException, it is always a checked exception. So, when a class extends Exception, you must handle the exception either with a try-catch block or declare it in the method signature using throws.
// 	•	Exception → checked exception (unless it extends RuntimeException)
// 	•	RuntimeException → unchecked exception


// At the same time, you do not need to extend RuntimeException if you want to create an unchecked exception. In fact, you are free to create your own unchecked exceptions without specifically needing to extend RuntimeException.

// Here’s the reasoning:
// 	•	Unchecked exceptions in Java are typically subclasses of RuntimeException, but it’s not mandatory for your custom exception to extend RuntimeException. Any class that extends RuntimeException or one of its subclasses (like IllegalArgumentException, NullPointerException, etc.) will be an unchecked exception.
// 	•	If you don’t want to use RuntimeException and still want your exception to be unchecked, you can extend Error, but it’s rare and generally not recommended to create exceptions that extend Error.

// So, in summary:
// 	•	Unchecked exceptions: You can extend RuntimeException if you want.
// 	•	Custom unchecked exceptions: While it’s common to extend RuntimeException, you don’t have to. You can create your own exceptions without extending RuntimeException, but they won’t behave like traditional unchecked exceptions unless you do extend it.

// Example:

// Custom unchecked exception without extending RuntimeException
public class MyUncheckedException extends Exception { // Extending Exception is optional
    public MyUncheckedException(String message) {
        super(message);
    }
}

// Even though MyUncheckedException does not extend RuntimeException, 
// it can still be used as an unchecked exception (if you choose to ignore try-catch handling).

// But note, unchecked exceptions (those extending RuntimeException) still don’t require mandatory handling, while checked exceptions (those extending Exception but not RuntimeException) do require handling either with try-catch or by declaring them with throws in method signatures.



// Rules for handling exceptions in Java.

// When working with checked exceptions in Java, the general rule is as follows:

// 	1.	Declare the Exception in the method signature if the method can throw a checked exception.
// This tells the Java compiler that the method might throw a particular exception (like IOException, SQLException, etc.), and whoever calls the method must be aware of this possibility.

public static void someMethod() throws IOException {
    // Code that might throw IOException
}


// 	2.	Handle the Exception with a try-catch block if the exception occurs during execution.
// This is a way to catch the exception and handle it in the same method where it is thrown.

public static void someMethod() {
    try {
        // Code that might throw IOException
        throw new IOException("An error occurred");
    } catch (IOException e) {
        System.out.println("Exception handled: " + e.getMessage());
    }
}


// 	3.	Declare the Exception in the calling method’s signature (such as main or other methods) if you don’t handle the exception inside the method.
// When you call a method that throws a checked exception, you have two options:
// 	•	Handle it with a try-catch block (as shown above).
// 	•	Declare it in the method signature using throws (if you’re not handling it directly).
// For example, in the main method:

public static void main(String[] args) throws IOException {
    someMethod();  // You don't need a try-catch block here, but you're declaring the exception.
}

// Step-by-Step Summary:
// 	1.	Declare checked exceptions in the method that can throw them.
// 	•	This tells Java that the method might throw an exception, and the caller must either handle it or declare it.
// 	2.	In the calling method (like main), you can either:
// 	•	Use a try-catch block to handle the exception.
// 	•	Declare the exception using throws in the method signature.

// Example:

import java.io.IOException;

public class MainClass {

    // Method that throws a checked exception
    public static void readFile(String file) throws IOException {
        if (file == null) {
            throw new IOException("File cannot be null");
        }
        // Simulate file reading
        System.out.println("Reading file: " + file);
    }

    // Main method calling readFile
    public static void main(String[] args) {
        try {
            readFile(null);  // This will throw an IOException
        } catch (IOException e) {
            // Handle the exception
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Alternatively, you can declare the exception in the main method signature:
        // public static void main(String[] args) throws IOException {
        //     readFile(null);
        // }
    }
}

// Explanation:
// 	•	readFile method declares throws IOException because it can throw an IOException.
// 	•	main method:
// 	•	If you handle the exception, you use a try-catch block.
// 	•	Alternatively, if you don’t want to handle it directly, you can declare throws IOException in the main method signature, which will propagate the exception.

// Key Points:
// 	•	Checked exceptions must either be handled with a try-catch block or declared with throws in the method signature.
// 	•	Unchecked exceptions (like RuntimeException, NullPointerException) do not require declaration or handling.


// Throw vs Throws

// The keywords throw and throws in Java are related to exception handling, but they serve different purposes.

// 1. throw:
// 	•	Purpose: Used to actually throw an exception at runtime.
// 	•	Where Used: Inside a method or block of code.
// 	•	What It Does: Indicates the point in the code where an exception is explicitly raised.

// Example:

public static void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or older."); // Throws an exception at runtime
    }
    System.out.println("Age is valid.");
}

public static void main(String[] args) {
    validateAge(16); // Will throw an IllegalArgumentException
}

// 2. throws:
// 	•	Purpose: Used in a method signature to declare the types of exceptions a method might throw.
// 	•	Where Used: In the method declaration.
// 	•	What It Does: Alerts the caller of the method that it must handle or propagate the exception.

// Example:

// Method declares it might throw IOException
public static void readFile(String filePath) throws IOException {
    throw new IOException("File not found: " + filePath); // Actual throwing of the exception
}

public static void main(String[] args) {
    try {
        readFile("nonexistent.txt");
    } catch (IOException e) {
        System.out.println("Handled IOException: " + e.getMessage());
    }
}

// Key Differences Between throw and throws:

// Aspect	    |        throw	                                  |         throws
// Purpose	    | Used to actually throw an exception at runtime. |	Used to declare that a method can throw exceptions.
// Location	    | Inside a method or block of code.	              | In the method signature.
// Exceptions	| Throws a single exception instance.	          | Declares one or more exception types.
// Compile-Time | Does not affect method signature.	              | Compiler enforces the method declaration.

// Combined Example:

// Method declares possible exception using "throws"
public static void divideNumbers(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero"); // Actually throwing the exception
    }
    System.out.println("Result: " + (a / b));
}

public static void main(String[] args) {
    try {
        divideNumbers(10, 0);
    } catch (ArithmeticException e) {
        System.out.println("Caught Exception: " + e.getMessage());
    }
}

// In this example:
// 	•	throw is used to throw the ArithmeticException when dividing by zero.
// 	•	throws is used in the method signature to declare that divideNumbers might throw an ArithmeticException.


// Try statement vs Subroutine

// 1. Handling the Exception Within the Subroutine (Exception is caught inside the subroutine)

// In this approach, the exception is handled within the subroutine itself using a try-catch block. As a result, the caller of the subroutine doesn’t need to worry about the exception, because it is caught and handled inside the subroutine.

// Example:

public class Example {

    // Method that handles the exception within itself
    public void processFile() {
        try {
            // Simulating a file operation that can throw an exception
            System.out.println("Opening file...");
            int result = 10 / 0;  // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error occurred: " + e.getMessage()); // Handling the exception
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.processFile();  // No need to handle the exception in main
    }
}

// Explanation:
// 	•	In the processFile method, the exception (ArithmeticException) is caught and handled inside the method using a try-catch block.
// 	•	The caller (in this case, the main method) does not need to do anything to handle the exception because it has already been managed within the processFile subroutine.

// 2. Declaring the Exception to Be Thrown (Exception is thrown to the caller)

// In this approach, the subroutine declares that it can throw an exception, and the caller is responsible for handling it. This is typically done by adding a throws clause in the subroutine’s method signature.

// Example:

public class Example {

    // Method that declares it can throw an exception
    public void processFile() throws ArithmeticException {
        System.out.println("Opening file...");
        int result = 10 / 0;  // This will throw an ArithmeticException
    }

    public static void main(String[] args) {
        Example example = new Example();
        
        // The caller must handle or declare the exception
        try {
            example.processFile();  // Calling the method that throws the exception
        } catch (ArithmeticException e) {
            System.out.println("Error occurred: " + e.getMessage());  // Handling the exception in main
        }
    }
}

// Explanation:
// 	•	In the processFile method, the exception (ArithmeticException) is not caught within the method itself. Instead, it is declared using the throws keyword, which tells the caller that this method may throw an exception.
// 	•	The main method (the caller) must either handle the exception using a try-catch block or propagate it further (if the exception were a checked exception). In this case, it handles the exception inside a try-catch block.

// Summary of Differences:
// 	•	First Method (Handling inside the subroutine): The exception is caught and handled within the subroutine, so the caller doesn’t need to do anything about it.
// 	•	Second Method (Declaring to throw the exception): The subroutine declares that it might throw an exception, and the caller is responsible for handling or declaring it further.


// Custom Exception (higher-level abstraction)

// The principle of using the right abstraction level when handling exceptions means that you should design your code in a way that hides the low-level details and allows the caller to focus on higher-level concepts. In the context of handling exceptions, this principle advocates for encapsulation and abstraction to ensure that exceptions don’t leak implementation details into higher layers of your application.

// The Problem: Exposing Implementation-Specific Exceptions

// Consider a situation where you have multiple implementations for the same interface or functionality. For example, let’s say you have a repository that can interact with either a database or a filesystem. Each of these implementations might throw its own specific set of exceptions:
// 	•	The database implementation might throw a SQLException when an error occurs while interacting with the database.
// 	•	The filesystem implementation might throw an IOException when something goes wrong with reading or writing files.

// If you expose these exceptions directly to the higher layers of your application, the higher layers would have to handle implementation-specific details, making the system more tightly coupled and less flexible. For example, if the calling code has to catch both SQLException and IOException, it might make the code cumbersome and harder to maintain, especially if you decide to switch to a different implementation in the future.

// The Solution: Use a Custom Abstraction (e.g., RepositoryException)

// To avoid exposing these implementation-specific exceptions, the idea is to wrap them in a custom exception that represents the higher-level abstraction of the operation you’re performing. This custom exception would be more general and not tied to the specific implementation details (like whether it’s using a database or a filesystem). In this case, the custom exception could be something like RepositoryException.

// Example:

// Imagine you’re working with a repository interface that can use either a database or a filesystem. Instead of letting each implementation throw database-specific or file-specific exceptions, you could create a RepositoryException that abstracts both:

// Custom abstraction for repository-related errors
public class RepositoryException extends Exception {
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Now, both the database and filesystem implementations can throw this RepositoryException, which wraps the underlying exception (either SQLException or IOException).

// Database implementation
public class DatabaseRepository implements Repository {
    public void saveData(String data) throws RepositoryException {
        try {
            // Simulating a database operation
            throw new SQLException("Database error");
        } catch (SQLException e) {
            throw new RepositoryException("Error while saving data to the database", e);
        }
    }
}

// Filesystem implementation
public class FilesystemRepository implements Repository {
    public void saveData(String data) throws RepositoryException {
        try {
            // Simulating a filesystem operation
            throw new IOException("File error");
        } catch (IOException e) {
            throw new RepositoryException("Error while saving data to the filesystem", e);
        }
    }
}

// In this design, the RepositoryException serves as an abstraction that shields the caller from the details of the underlying implementation. The caller of the Repository interface doesn’t need to care whether the data is being saved to a database or a filesystem. It simply handles a RepositoryException.

// Calling code
public class App {
    public static void main(String[] args) {
        Repository repository = new DatabaseRepository(); // Or new FilesystemRepository()

        try {
            repository.saveData("some data");
        } catch (RepositoryException e) {
            System.out.println("Failed to save data: " + e.getMessage());
            // Handle the exception without worrying about whether it's a database or file error
        }
    }
}

// Why Use This Abstraction?
// 	1.	Decouples the Calling Code from Implementation Details: By throwing a general RepositoryException instead of implementation-specific exceptions like SQLException or IOException, the calling code doesn’t need to know which underlying implementation is being used. It only cares about the higher-level abstraction (saving data to a repository).
// 	2.	Increases Flexibility: If you later decide to replace the database implementation with another type of storage (e.g., a cloud-based service), the calling code does not need to change. You can just update the implementation without modifying how exceptions are handled.
// 	3.	Simplifies Exception Handling: The caller only needs to catch the RepositoryException rather than catching multiple specific exceptions (SQLException, IOException, etc.). This can reduce the number of catch blocks and make the code cleaner.
// 	4.	Provides Clearer Context: The custom exception (e.g., RepositoryException) can provide more meaningful messages that are relevant to the higher-level operation, rather than the technical details of a specific exception type.

// Summary:

// In short, when you have different implementations (like database vs filesystem), you should avoid exposing implementation-specific exceptions like SQLException or IOException to the higher levels of your application. Instead, you create a higher-level abstraction (like RepositoryException) that wraps the specific exceptions. This allows you to decouple the caller from the underlying implementation, provides more flexibility, and simplifies exception handling.