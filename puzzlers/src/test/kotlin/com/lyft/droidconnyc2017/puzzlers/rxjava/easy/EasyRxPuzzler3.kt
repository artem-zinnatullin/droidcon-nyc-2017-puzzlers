package com.lyft.droidconnyc2017.puzzlers.rxjava.easy

import io.reactivex.subjects.PublishSubject
import org.junit.Test

class EasyRxPuzzler3 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        val upstream = PublishSubject.create<Int>()
        upstream.onNext(1)

        upstream.subscribe(
                { value -> println("S1 value $value") },
                { error -> println("S1 error $error") }
        )

        upstream.onNext(2)
        upstream.onError(Exception("whoa"))

        upstream.subscribe(
                { value -> println("S2 value $value") },
                { error -> println("S2 error $error") }
        )
    }
}

