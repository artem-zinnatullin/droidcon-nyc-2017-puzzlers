package com.lyft.droidconnyc2017.puzzlers.rxjava.easy

import io.reactivex.Observable
import org.junit.Test

class EasyRxPuzzler1 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        var counter = 0

        val upstream = Observable
                .fromCallable { counter++ }
                .share()

        upstream.subscribe { value -> println("S1 Value $value") }
        upstream.subscribe { value -> println("S2 Value $value") }
    }
}
