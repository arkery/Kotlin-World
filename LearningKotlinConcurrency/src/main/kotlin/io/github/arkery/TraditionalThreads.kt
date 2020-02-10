package io.github.arkery

import java.lang.Thread

fun main(args: Array<String>) {
    println("Hello, World")
    val traditionalThreads = false;

    /**
     * Thread using anonymous class - similar to java
     * except there is no -> for lambda anonymous class
     */
    val thread3 = Thread {
        for(i in 1..10){
            println("Count is $i")
            try{
                Thread.sleep(1000)
            }catch(e: Exception){
                e.printStackTrace()
            }
        }
    }

    val thread4 = Thread {
        for(i in 10 downTo 1){
            println("Reverse count is $i")
            try{
                Thread.sleep(1000)
            }catch(e: Exception){
                e.printStackTrace()
            }
        }
    }

//Start the threads
    if(traditionalThreads){
        val thread1 = Thread(Thread1())
        val thread2 = Thread(Thread2())

        thread1.start()
        thread2.start()

        try{
            thread1.join()
            thread2.join()
        }catch (e: InterruptedException){
            e.printStackTrace()
        }

    }
    else{
        thread3.start()
        thread4.start()
        try{
            thread3.join()
            thread4.join()
        }catch (e: InterruptedException){
            e.printStackTrace()
        }

    }


}


//A traditional thread - count from 1 to 10
class Thread1 : Runnable{
    override fun run() {
        for(i in 1..10){
            println("Count is $i")
            try{
                Thread.sleep(1000)
            }catch(e: Exception){
                e.printStackTrace()
            }
        }
    }
}

//A traditional thread - count from 10 to 1
//Implementing a Runnable
class Thread2 : Runnable{

    override fun run() {
        for(i in 10 downTo 1){
            println("Reverse Count is $i")
            try{
                Thread.sleep(1000)
            }catch(e: Exception){
                e.printStackTrace()
            }
        }
    }
}