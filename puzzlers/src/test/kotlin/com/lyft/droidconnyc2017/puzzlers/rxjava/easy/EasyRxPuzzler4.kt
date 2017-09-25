package com.lyft.droidconnyc2017.puzzlers.rxjava.easy

import io.reactivex.Observable
import org.junit.Test

class EasyRxPuzzler4 {

    // What will be printed and why, will this test pass or fail?
    @Test
    fun puzzler() {
        Observable
                .create<Int> { emitter ->
                    emitter.onNext(1)

                    try {
                        throw Exception("whoa")
                    } finally {
                        emitter.onNext(2)
                    }
                }
                .subscribe { println("onNext $it") }
    }
}
