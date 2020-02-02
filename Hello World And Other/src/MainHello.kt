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
    'val' = read only (like 'final' in Java or 'const' in C++). It is not technically immutable when used with classes
    'var' = mutable (changeable)

    Hence it is again, like reading english:
    - "The number 'value' of hours in a day is 24"
    - "The y 'variable' can manipulated and changed via algebra"

     */
    val arkery = Person("arkery", 9000, "supreme overlord")//Check ObClass.kt file

    /*
    The person object is now created. Again there are no setters and getters for kotlin data classes
    Instead Kotlin calls the name, age, etc. in the Person class a 'property/properties' of the class

    Hence we access them like: objectName.specificPropertyOfObject
     */
    println("My name is: ${arkery.name} and I am the ${arkery.age}" )

    /**
     * This here is using the second person class object where constructor parameters are 'var' instead of 'val'
     * Thus it allows the object values to be re-assigned after initializing it via the constructor parameters
     */
    val testPerson = DesignPerson("Cody", 12, "clone trooper")
    testPerson.age = 13;
    println("${testPerson.name} is ${testPerson.age} years old ${testPerson.occupation} in the Grand Army of the Republic\n")


    //Example of the usage of the init block in a class - see ObClass.kt
    val testPerson2 = Person2("Rex", 7, "clone trooper")
    println("${testPerson2.name} is ${testPerson2.age} years old ${testPerson2.occupation} in the Grand Army of the Republic")
    println("Rex's age should be 14\n")

    //Example of usage of a secondary constructor in a class
    val testPerson3 = Person3("Fives", 4, "clone trooper", "123456789", "Kamino Clone Academy Year 3")
    println("${testPerson3.name}'s student ID is: ${testPerson3.studentID} and the student is in ${testPerson3.classYear}")

    /**
     * Printing Hello World from a class
     */
    val Hello = HelloWorld()
    Hello.printHelloWorld()

    /**
     * Given the differences between val and var, Kotlin is also smart enough to prevent potential errors like this:
     *
     * var test2Person = Person("Mike", 100, "commoner")
     * test2Person = 12;
     */

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