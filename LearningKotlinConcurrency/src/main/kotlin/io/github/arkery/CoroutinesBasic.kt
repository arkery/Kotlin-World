package io.github.arkery
import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.concurrent.thread

/**
 * Basic intro to coroutines, will cover async later
 * Recommended to run this code, run it from a browser at https://play.kotlinlang.org/
 */
fun main() {

    /**
     * Custom dispatcher, basically runs coroutines from this pool
     */
    val localCustomDispatcher = Executors.newFixedThreadPool(5).asCoroutineDispatcher()

    /**
     * The very basic explanation of coroutines is that they are essentially light weight threads
     * Below, we are launching a coroutine from GlobalScope.
     *
     * A scope is essentially a "bucket" or "pool" where coroutines are launched. The GlobalScope is
     * the pool that is tied to the lifetime of the running program
     */

    val coroutine1 = GlobalScope.launch {
        /*
        Delay is similar to Thread.sleep except that it can only be called form a coroutine
         */
        delay(500)//Simulate executing some complicated code
        println("In GlobalScope.launch: The sum of 2 and 3 is ${coroutineAddition(2, 3)} Thread: ${Thread.currentThread()}")
        localCoroutine()
    }
    println("Going to RunBlocking ${Thread.currentThread()}")

    /**
     * Launching another coroutine but using Runblocking.
     * Runblocking stops the main thread until what's done inside is finished.- in
     * combination with delay() it essentially simulates Thread.sleep
     */
    runBlocking(localCustomDispatcher) { //Dispatchers.Default makes it so the runBlocking code block runs on another thread/coroutine instead of the main
        println("From runBlocking: ${Thread.currentThread()}")
        coroutine1.join()
    }

    println("Hello from main thread: ${Thread.currentThread()}") //Print Hello and the Thread
    Thread.sleep(2000)

    //Shutdown the fixed coroutine pool
    (localCustomDispatcher.executor as ExecutorService).shutdown()
}

/*
Suspend functions are only callable from a coroutine or another suspend function.
Instead of fully blocking the thread, it only suspends.

HOWEVER: Adding a "suspend" in front of the function does not automagically suspend it when the
function is called, only inside of a coroutine.
 */
suspend fun coroutineAddition(x: Int, y: Int): Int = x + y

/*
Example of launching a local coroutine not tied to globalscope
 */
suspend fun localCoroutine() = runBlocking {
    launch{
        println("From local: ${Thread.currentThread()}")
    }
}
