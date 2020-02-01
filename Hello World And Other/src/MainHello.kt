//If Java and Python had a baby = Kotlin

/**
 *  fun - "function/method"
 */
fun main(args: Array<String>){
    println("Mandatory 'Hello World' when learning a new language")

    /*
    In java, printing out return values from methods, classes, data types etc. requires
    you to add a + between the printing string and the value.

    Java example:
    System.out.println("The sum of 2 and 3 is " + add(2, 3) + " ");

    Kotlin behaves somewhat similarly to python when doing this by surrounding the
    data type with ${}

     */
    println("The sum of 2 and 3 is ${add(2, 3)}") //Calling add, direct print
}

/**
 * Instead of writing an entire method with curly braces
 * We can condense it into this
 *
 * Java:
 * public int add(int x, int y){ return x + y}
 *
 * Kotlin below
 */
fun add(x: Int, y: Int) = x + y