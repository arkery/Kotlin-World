
/*
Section for loops
 */
fun main(){

    /**
     * The for loop in Kotlin is slightly different than Java
     * since it uses a range denotion to loop
     */

    for(i in 1..5){
        println(i)
    }

    /*
    Similarly the foreach loop variant:
     */

    /*
    Creating an array & populating it, There is an emphasis of lambda expressions in Kotlin
    The below is equivalent to:

    val testArray = Array(5){x -> (x * x * x + 0.5).toFloat()}

    Basically the "It" operator can be used if a lambda expression only has 1 parameter

     */
    val testArray = Array(5){(it*it*it+ 0.5).toFloat()}
    val testArray2 = arrayOf(1, 2, 3, 4, 5)

    for(i in testArray){
        println(i)
    }

    /*
    While and do-while loops are similar to java in kotlin
     */

    var counter = 0;
    while(counter != 5){
        println(counter)
        counter++
    }

    do{
        println(counter)
        counter--
    }while(counter !=0)
}