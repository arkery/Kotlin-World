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
 */
data class Person(val name: String, val age: Int, val occupation: String)