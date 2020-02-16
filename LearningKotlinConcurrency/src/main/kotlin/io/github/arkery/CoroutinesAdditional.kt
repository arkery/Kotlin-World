package io.github.arkery

import kotlinx.coroutines.*

/**
 * Note: There is a difference between async and multithreaded programming
 * multithreaded programming is a form of async programming.
 */

fun main(){

    /**
     * Further details on "Scopes":
     * Think of coroutines being individual "tasks" or "jobs" that run on a single thread.
     * Therefore a scope would be the grouping of these "tasks". Hence the difference between
     * delay() and Thread.sleep() since delay() suspends that individual "task" while Thread.sleep()
     * stops the entire thread
     *
     * Multiple coroutines can then be ran on a single thread
     * Strictly speaking, coroutines are not total replacements for threads even if they are
     * lightly called "light-weight" threads. They are of course a way to deal/implement
     * asynchronous programming in Kotlin and generally ignore using callbacks(passing a value and
     * that returns a function/method/etc.)
     *
     * A hopeful clarification on coroutine functionality: https://medium.com/@elizarov/coroutine-context-and-scope-c8b255d59055
     */

    /*
    runBlocking is... odd since it goes against the idea that Kotlin Coroutines suspend functionality
    rather than Blocking an entire thread.
     */
    runBlocking{
        coroutine1()
    }

    /**
     * Therefore to create a scope that aligns with Kotlin's Coroutine ideology
     * Edit: ...Apparently you aren't suppose to do this
     */
    CoroutineScope(Dispatchers.Default).launch {
        coroutine1()
    }



    Thread.sleep(500)
}

suspend fun coroutine1() = CoroutineScope(Dispatchers.Default).launch {
    println("Hello World")
}

fun CoroutineScope.Hello() = launch{
    println("Hello World")
}
