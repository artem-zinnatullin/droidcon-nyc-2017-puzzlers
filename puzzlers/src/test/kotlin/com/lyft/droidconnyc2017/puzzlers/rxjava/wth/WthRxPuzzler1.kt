package com.lyft.droidconnyc2017.puzzlers.rxjava.wth

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS

class WthRxPuzzler1 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        val testObserver = TestObserver<String>()

        val inner = Observable
                .fromCallable { "inner" }
                .observeOn(Schedulers.io())

        Observable
                .fromCallable { "upstream" }
                .subscribeOn(Schedulers.computation())
                .flatMap { value -> inner }
                .doOnNext { value -> println("Thread ${Thread.currentThread()}") } // Which thread? Computation or IO?
                .subscribe(testObserver)

        testObserver.awaitTerminalEvent()
    }

    // What will be printed and why?
    @Test
    fun `is there any difference 1?`() {
        val testObserver = TestObserver<String>()

        val inner = Observable
                .fromCallable { "inner" }
                .subscribeOn(Schedulers.io())

        Observable
                .fromCallable { "upstream" }
                .subscribeOn(Schedulers.computation())
                .flatMap { value -> inner }
                .doOnNext { value -> println("Thread ${Thread.currentThread()}") } // Which thread? Computation or IO?
                .subscribe(testObserver)

        testObserver.awaitTerminalEvent()
    }

    // What will be printed and why?
    @Test
    fun `is there any difference 2?`() {
        val testObserver = TestObserver<String>()

        val inner = Observable
                .fromCallable { "inner" }
                .delay(500, MILLISECONDS)
                .observeOn(Schedulers.io())

        Observable
                .fromCallable { "upstream" }
                .subscribeOn(Schedulers.computation())
                .flatMap { value -> inner }
                .doOnNext { value -> println("Thread ${Thread.currentThread()}") } // Which thread? Computation or IO?
                .subscribe(testObserver)

        testObserver.awaitTerminalEvent()
    }

}
