package com.lyft.droidconnyc2017.puzzlers.rxjava.medium

import io.reactivex.Observable
import io.reactivex.rxkotlin.withLatestFrom
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import org.junit.Test

class MediumRxPuzzler1 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        val upstream = BehaviorSubject.create<Int>()
        upstream.onNext(0)

        upstream
                .whatDoesThisExtensionDo()
                .subscribe { value -> println(value) }

        upstream.onNext(1)
    }

    // What will be printed and why?
    @Test
    fun isItDifferentQuestionMark() {
        val upstream = PublishSubject.create<Int>()
        upstream.onNext(0)

        upstream
                .whatDoesThisExtensionDo()
                .subscribe { value -> println(value) }

        upstream.onNext(1)
    }

    fun <T> Observable<T>.whatDoesThisExtensionDo(): Observable<T> = Observable // Can you improve this function?
            .just(1) // What if you use just(-1)?
            .withLatestFrom(this) { integer, t -> t }
}
