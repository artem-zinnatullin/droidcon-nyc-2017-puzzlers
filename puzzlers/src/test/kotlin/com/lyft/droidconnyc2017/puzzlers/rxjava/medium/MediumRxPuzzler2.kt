package com.lyft.droidconnyc2017.puzzlers.rxjava.medium

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DefaultObserver
import org.junit.Test

class MediumRxPuzzler2 {

    // What will be printed and why?
    @Test
    fun puzzler() {
        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) = Unit

            override fun onNext(t: Int) {
                println("onNext $t")
            }

            override fun onComplete() {
                println("onComplete")
            }

            override fun onError(e: Throwable) {
                println("onError $e")
            }
        }

        Observable.just(1).subscribe(observer)
        Observable.just(2).subscribe(observer)
    }

    // What will be printed and why?
    @Test
    fun `same puzzler?`() {
        val observer = object : DefaultObserver<Int>() {
            override fun onNext(t: Int) {
                println("onNext $t")
            }

            override fun onComplete() {
                println("onComplete")
            }

            override fun onError(e: Throwable) {
                println("onError $e")
            }
        }

        Observable.just(1).subscribe(observer)
        Observable.just(2).subscribe(observer)
    }

}
