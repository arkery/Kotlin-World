
fun main(){
    /**
     * If for some reason (but hopefully not stupid reason) you NEED
     * to use null in Kotlin:
     */

    //Use the question mark to indicate null
    val aNullVariable: String? = null

    //Or you can do this
    val aNullVariable2 = null

    /**
     * In the event that there is a chance that a return value may be null:
     */

    fun nullReturn(): String? = null

    /**
     * Also if kotlin detects that you yourself is checking for null, it'll allow it
     */

    if(nullReturn() == null){
        println("Hello World")
    }

    /**
     * You can also force null
     */

    val whyIsThisNull = nullReturn()
    val thisIsSuchABadIdea = whyIsThisNull!!.length

}