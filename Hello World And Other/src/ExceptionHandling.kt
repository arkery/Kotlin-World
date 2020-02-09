import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main(){
    /*
    Exceptions aren't really different from java although you don't use
    the new operator to throw exceptions
     */

    try{
        //Blah stuff here
        //throw IllegalArgumentException("Blah")
        println(testingException(0))
    }catch(e: IllegalArgumentException){
        println("Illegal Argument Exception thrown successfully")
    }catch (f: IllegalStateException){
        println("Illegal State Exception thrown successfully")
    }
    finally {
        println("Of course we have to have something in the finally block" +
                " if we are going to use it")
    }

    /*
    You could also do this as well, directly returning a value
     */

    val str = "3"
    val returning = try{
        parseInt(str)
    }catch (e: NumberFormatException){
        1 //returning = 1 if NumberFormatException is thrown
        //Else it is parsed
    }

    println(returning)

}

/*
Throwing exceptions is also similar to java except well, you don't need
to say that the function/method will possibly "throw" an exception
 */

fun testingException(x: Int): Int {
    if(x == 0){
        throw IllegalArgumentException()
    }
    return x;
}