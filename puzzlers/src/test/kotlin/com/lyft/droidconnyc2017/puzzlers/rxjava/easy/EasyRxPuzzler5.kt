package com.lyft.droidconnyc2017.puzzlers.rxjava.easy

import io.reactivex.Observable
import org.junit.Test

class EasyRxPuzzler5 {

    private var counter = 1

    private fun incrementCounter() = counter++

    // What will be printed and why?
    @Test
    fun puzzler() {
        val observable = Observable
                .just { incrementCounter() }
                .map { it.invoke() }

        observable.subscribe { println("S1 value $it") }
        observable.subscribe { println("S2 value $it") }
    }
}
