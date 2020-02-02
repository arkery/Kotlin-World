/**
 * Kotlin is interesting when it comes to classes & the constructor set up since
 * the formatting is similar to a method/function for overloaded constructors
 *
 * The typical class example is describing a person with name, age, etc.
 *
 * In java you would have to declare private variables and then initialize it
 * like so:
 *
 * public class Person{
 *
 *  private String name;
 *  private int age;
 *  private String occupation;
 *
 *
 *  Person(String name, int age, String occupation){
 *      this.name = name;
 *      this.age = ....
 *  }
 *
 *  //Setters and Getters
 *
 * }
 *
 * The same class is now condensed in Kotlin to the below
 *
 */

class Person(val name: String, val age: Int, val occupation: String)

/**
 * When dealing with class parameters however, val doesn't not necessarily mean immutable, rather only read only
 * Further explanation: https://blog.danlew.net/2017/05/30/mutable-vals-in-kotlin/
 *
 * Therefore for a class that requires both the traditional setters and getters, the constructor parameters should be
 * var not val
 */
class DesignPerson(var name: String, var age: Int, var occupation: String)


/**
 * However what if we wanted to do something inside of the constructor? Take for example of the above with:
 *
 *  Person(String name, int age, String occupation){
 *      this.name = name;
 *      this.age = ....
 *  }
 *
 *  What if we wanted to do:
 *  Person(String name, int age, String occupation){
 *      this.name = name;
 *      this.age = age * 2;
 *  }
 *
 *  in kotlin instead?
 *
 *  Kotlin provides an init block that allows us to do that
 */
class Person2(val name: String, var age: Int, var occupation: String){
    init {
        age = age * 2;
    }

    //Note that a class can also have more than one init block and are executed from top to bottom
    init{
        occupation = "501st " + occupation
    }

    init{
        occupation = occupation + " commander"
    }
}

/**
 * But what about overloaded constructors? Where you create the object and assign values depending on what parameters
 * are inputted?
 *
 * Kotlin introduces something called secondary constructors
 */
class Person3(val name: String, val age: Int, val occupation: String) {

    //Used by secondary constructor, it seems we have to initially initialize the strings since unlike java
    //Null is a big no no and strangely, this is public not private
    var studentID: String = ""
    var classYear: String = ""

    /**
     * The secondary constructor  behaves more or less like an "inherited" constructor since the overloaded
     * constructor still needs to link/delegate/call the primary/main constructor using
     * : this('parameters here')
     *
     * However because of this, the additional parameters (studentID, classYear) are not a class property
     * yet unlike the parameters declared in the primary constructor (name, age, occupation)
     * Hence we have to declare it inside of the class like in Java
     *
     * Given that secondary constructors are well... secondary, the secondary constructor is always called AFTER
     * an init block if the class has one
     */
    constructor(name: String, age: Int, occupation: String, studentID: String, classYear: String) : this(name, age, occupation) {
        this.studentID = studentID
        this.classYear = classYear
    }

}

/**
 * Of course constructors are not necessarily needed and this is also possible
 */
class HelloWorld{

    //Declared as private so that it can only be used inside of the class
    //By default, everything is public but technically you can set this to public and just
    //Call the variable but then it wouldn't really be OOP
    private val hello: String = "Hello World from HelloWorld class"

    fun printHelloWorld(){
        println(hello)
    }
}
