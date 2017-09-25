package com.lyft.droidconnyc2017.puzzlers.rxjava.medium

import io.reactivex.subjects.BehaviorSubject
import org.junit.Test

class MediumRxPuzzler3 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        val upstream = BehaviorSubject.create<Int>()

        val stream = upstream
                .replay(1)
                .autoConnect(2)
                .share()

        stream.subscribe { println("S1 onNext $it") }
        stream.subscribe { println("S2 onNext $it") }

        upstream.onNext(1)

        stream.subscribe { println("S3 onNext $it") }
        stream.subscribe { println("S4 onNext $it") }

        upstream.onNext(2)
    }
}
