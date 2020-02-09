//If Java and Python had a baby = Kotlin

/**
 *  fun - "function/method"
 */
fun main(){

    /**
     * String printing still support new line \n carriage \r etc. Like in java
     */
    println("Mandatory 'Hello World' when learning a new language\n")
    printHelloV()

    /*
    In java, printing out return values from methods, classes, data types etc. requires
    you to add a + between the printing string and the value.

    Java example:
    System.out.println("The sum of 2 and 3 is " + add(2, 3) + " ");

    Kotlin behaves somewhat similarly to python when doing this by surrounding the
    data type with ${} via string interpolation

     */
    println("The sum of 2 and 3 is ${add(2, 3)}") //Calling add, direct print
    println("The sum of 420 and 69 is ${420 + 69}") //Doing addition inside

    val printingTest = 42;
    println("The answer to everything in the universe: $printingTest")

    /*
    However it still does support traditional java ways to print information
     */

    println("The sum of 5 and 6 is " + add(5,6)) //Calling add, direct print


    /*
    Creating a new "Person" object. Kotlin doesn't use a 'new' statement when creating new objects

    notice the 'val' statement in front of the object/variable name. In kotlin there is 'val' and 'var'
    'val' = read only (like 'final' in Java or 'const' in C++). It is not technically immutable when used with classes
    'var' = mutable (changeable)

    Hence it is again, like reading english:
    - "The number 'value' of hours in a day is 24"
    - "The y 'variable' can manipulated and changed via algebra"

     */
    val arkery = Person("arkery", 9000, "supreme overlord")//Check Classes.kt file

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


    //Example of the usage of the init block in a class - see Classes.kt
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
     *
     * Thus Kotlin sets the data type of a variable to what it was INITIALLY set to preventing things
     * this from happening:
     *
     * var testingHello = "Hello" //INITIALLY a String
     * testingHello = 2; //Cannot be re-assigned to an integer
     */

    /**
     * Of course you can still re-assign it but it still has to be a string
     */
    var testingHello = "Hello"
    val testingNumber = 2
    testingHello = testingNumber.toString()


    //Also using is statement to check type
    if(testingHello is String){
        println("\n\nIt's a String")
    }


    /*
    Example of calling a function that accepts a variable number of arguments
     */
    println("The sum of 1, 2 and 3 is: ${sum(1.0, 2.0, 3.0)}")
    println("The sum of 1.7, 2.5, 2.9, 3.5 and 33.4 is: ${sum(1.7, 2.5, 2.9, 3.5,  33.4)}")

    /*
    You can also do function literals here:
     */
    val dividing = {x: Double, y: Double -> (x/y)}
    println("10 divided by 2.5 is: ${dividing(10.0, 2.5)}")

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


/**
 * This would be the equivalent of:
 *      public/private void printHelloV(){
 *          System.out.println("Hello World!);
 *      }
 *
 * Kotlin uses "Unit" as the return type to denote that the function won't return anything meaningful
 */
fun printHelloV() : Unit = println("Hello World from function printHelloV()!")


/*
Function with a variable amount of parameters/arguments:
 */

fun sum(vararg x: Double): Double{
    var sum: Double = 0.0
    for(i in x){
        sum += i
    }
    return sum
}