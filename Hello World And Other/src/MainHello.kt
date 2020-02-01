//If Java and Python had a baby = Kotlin

/**
 *  fun - "function/method"
 */
fun main(){

    /**
     * String printing still support new line \n carriage \r etc. Like in java
     */
    println("Mandatory 'Hello World' when learning a new language\n")

    /*
    In java, printing out return values from methods, classes, data types etc. requires
    you to add a + between the printing string and the value.

    Java example:
    System.out.println("The sum of 2 and 3 is " + add(2, 3) + " ");

    Kotlin behaves somewhat similarly to python when doing this by surrounding the
    data type with ${}

     */
    println("The sum of 2 and 3 is ${add(2, 3)}") //Calling add, direct print


    /*
    Creating a new "Person" object. Kotlin doesn't use a 'new' statement when creating new objects

    notice the 'val' statement in front of the object/variable name. In kotlin there is 'val' and 'var'
    'val' = immutable (read only like 'final' in Java or 'const' in C++)
    'var' = mutable (changeable)

    Hence it is again, like reading english:
    - "The number 'value' of hours in a day is 24"
    - "The y 'variable' can manipulated and changed via algebra"

     */
    val arkery = Person("arkery", 9000, "supreme overlord")//Check Person.kt file

    /*
    The person object is now created. Again there are no setters and getters for kotlin data classes
    Instead Kotlin calls the name, age, etc. in the Person class a 'property/properties' of the class

    Hence we access them like: objectName.specificPropertyOfObject
     */
    println("My name is: ${arkery.name} and I am the ${arkery.age}" )
}

/**
 * Instead of writing an entire method with curly braces
 * We can condense it into this
 *
 * Java:
 * public int add(int x, int y){ return x + y; }
 *
 * Kotlin below
 *
 * Notice that parameter formatting in the function is different from java, it follows more or less
 * like reading english: The variable x that is an integer and the variable y that is an integer.
 */
fun add(x: Int, y: Int) = x + y