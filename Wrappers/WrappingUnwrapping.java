// Java program to demonstrate Wrapping and Unwrapping
// in Java Classes
import java.util.ArrayList;

class WrappingUnwrapping {
    public static void main(String args[]) {
        // byte data type
        byte a = 1;

        // wrapping around Byte object
        Byte byteobj = Byte.valueOf(a);

        // int data type
        int b = 10;

        // wrapping around Integer object
        Integer intobj = Integer.valueOf(b);

        // float data type
        float c = 18.6f;

        // wrapping around Float object
        Float floatobj = Float.valueOf(c);

        // double data type
        double d = 250.5;

        // Wrapping around Double object
        Double doubleobj = Double.valueOf(d);

        // char data type
        char e = 'a';

        // wrapping around Character object
        Character charobj = Character.valueOf(e);

        // or using Autoboxing for Character
        // Character charobj = e;

        // printing the values from objects
        System.out.println("Values of Wrapper objects (printing as objects)");
        System.out.println("Byte object byteobj: " + byteobj);
        System.out.println("Integer object intobj: " + intobj);
        System.out.println("Float object floatobj: " + floatobj);
        System.out.println("Double object doubleobj: " + doubleobj);
        System.out.println("Character object charobj: " + charobj);

        // objects to data types (retrieving data types from objects)
        // unwrapping objects to primitive data types (auto-unboxing)
        byte bv = byteobj;
        int iv = intobj;
        float fv = floatobj;
        double dv = doubleobj;
        char cv = charobj;

        // printing the values from data types
        System.out.println("Unwrapped values (printing as data types)");
        System.out.println("byte value, bv: " + bv);
        System.out.println("int value, iv: " + iv);
        System.out.println("float value, fv: " + fv);
        System.out.println("double value, dv: " + dv);
        System.out.println("char value, cv: " + cv);

        // More about using Wrapper classes
        Integer i3 = 5000; // autoboxing
        Integer i4 = 5000; // autoboxing

        // i3 and i4 are both reference variables
        // In other words, their values are the memory addresses of the objects they are referring to
        // They are pointing to 2 different objects, and therefore, i3 == i4 will be false
        System.out.println("i3 == i4: " + (i3 == i4));  // false due to different object references

        // .equals() is a method that can be used for comparing the internal values of 2 objects
        System.out.println("i3.equals(i4): " + i3.equals(i4)); // true because the internal values are the same

        // The wrapper classes contain a lot of useful static methods that you can utilize
        // They also contain various constants defined statically
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        // There are also methods to convert a String into its corresponding primitive value
        int age = Integer.parseInt("75"); // take the string "75" and give an int 75

        // Convert int 75 to String "75"
        String ageString1 = String.valueOf(age); // using String.valueOf()
        String ageString2 = Integer.toString(age); // using Integer.toString()

        System.out.println("int value converted to String: " + ageString1);
        System.out.println("int value converted to String: " + ageString2);

        // Collections such as ArrayList can only deal with non-primitive types
        // for example, cannot store int primitives, only Integer objects
        ArrayList<Integer> myInts = new ArrayList<>();
        myInts.add(10);
        myInts.add(1000);
    }
}