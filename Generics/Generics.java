// What Are Generics in Java?

// Generics in Java are a way to create classes, interfaces, and methods that can operate on any data type while providing type safety and code reusability. By using generics, you can define a class or method with placeholders for the type of data it can handle, allowing you to write code that is more general and flexible.

// Key Concepts of Generics
// 	1.	Type Parameters: Generics use type parameters (e.g., <T>) as placeholders for specific types. These are replaced with actual types when the code is used.
// 	2.	Type Safety: Generics ensure that only the specified type of data can be added to a collection or used with a generic method, reducing runtime errors.
// 	3.	Compile-Time Checking: Generics catch type-related errors during compilation, preventing potential ClassCastException at runtime.

// Example Without Generics

// Using a collection like ArrayList without generics requires manual type casting:

import java.util.ArrayList;

class WithoutGenerics {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics
        list.add("Hello");
        list.add(123); // Accidentally added an integer

        String value = (String) list.get(1); // Throws ClassCastException at runtime
    }
}

// Example With Generics

// Using generics ensures type safety:

import java.util.ArrayList;

class WithGenerics {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // Generics ensure only Strings can be added
        list.add("Hello");
        // list.add(123); // Compile-time error: cannot add an integer

        String value = list.get(0); // No casting needed, and no risk of ClassCastException
        System.out.println(value);
    }
}

// Why Wrapper Classes Are Needed with Generics

// Generics only work with objects, not primitive types (e.g., int, double). This limitation exists because generics rely on Java’s object-oriented structure, and primitives are not objects.

// To use primitive types with generics, you need to use their wrapper classes, which are objects. For example:
// 	•	int → Integer
// 	•	double → Double

// Example

import java.util.ArrayList;

public class WrapperExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); // Use Integer, not int
        numbers.add(10); // Autoboxing: int 10 is converted to Integer object
        numbers.add(20);

        for (Integer num : numbers) {
            System.out.println(num); // Automatically unboxes Integer to int
        }
    }
}

// Key Features Here:
// 	•	Autoboxing: Automatically converts int to Integer.
// 	•	Unboxing: Automatically converts Integer back to int.

// Benefits of Generics
// 	1.	Type Safety: Prevents runtime type errors by catching them at compile time.
// 	2.	Eliminates Casting: No need for explicit type casting when retrieving elements from a collection.
// 	3.	Code Reusability: Write general code that can work with any object type.
// 	4.	Improved Readability: Makes the code easier to understand because types are explicit.

// Generics in Classes and Methods

// Generic Class Example

class Box<T> { // T is a type parameter
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class GenericClassExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println(intBox.getItem());
    }
}

// Generic Method Example

public class GenericMethodExample {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        String[] words = { "Java", "Generics", "Example" };
        Integer[] numbers = { 1, 2, 3 };

        printArray(words);
        printArray(numbers);
    }
}

// Limitations of Generics
// 	1.	No Primitive Types: Generics only work with objects, not primitives (use wrapper classes instead).
// 	2.	Type Erasure: At runtime, all generic type information is erased. For example, ArrayList<String> and ArrayList<Integer> look the same to the JVM.
// 	3.	Cannot Use instanceof: You cannot check the type parameter with instanceof.

if (obj instanceof T) { ... } // Not allowed


// 	4.	Cannot Create Generic Arrays: You cannot directly create arrays of a generic type.

// Summary

// Generics in Java provide a way to create type-safe and reusable classes, methods, and collections. They work with objects, not primitives, making wrapper classes necessary for handling primitive types like int and double. Generics enable cleaner code, better compile-time checking, and easier maintenance.