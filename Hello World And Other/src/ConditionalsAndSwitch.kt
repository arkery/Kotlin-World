
//Continuing from IntroAndFunctions.kt
fun main(){
    var testingHello = "Hello"

    //Is statement is used to check an object type, similar to java's instanceof
    if(testingHello is String){
        println("\n\nIt's a String")
    }

    /**
     * Kotlin data conversions need to be a little bit more explicit since
     * you have to declare the conversion type first
     * For example:
     */

    val numberOne = 1
    val numberTwo: Double = numberOne.toDouble()

    /*
    Interesting thing about Kotlin for ranges you can do this
    to generate a list for ranges:
     */
    val oneToHundred = 1..100
    val AToF = "A".."F"

    println("Is B in the range? ${ "B" in AToF }")
    println("Is 42 in the range? ${ 42 in oneToHundred }")


    /*Kotlin uses the "when" operator in substitute of a switch statement*/

    val x = 101

    when(x){
        100 -> println("The x value is 100")
        1,2,3,4,5 -> println("The x value is less than or equal to 6")

        in 2..99 -> {
            println("The x value is within 1 < x < 100")
        }

        else -> {
            println("The x value does not fulfill the statements above")
        }
    }

}