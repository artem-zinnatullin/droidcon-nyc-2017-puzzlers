package com.lyft.droidconnyc2017.puzzlers.kotlin.easy

import io.reactivex.Completable
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class EasyKotlinPuzzler1 {

    interface Api {
        fun f1()
        fun f2()
    }

    // Will this test pass and why?
    @Test
    fun puzzler() {
        val api = mock(Api::class.java)

        Completable
                .fromAction { api.f2() }
                .startWith { api.f1() }
                .subscribe()

        verify(api).f1()
        verify(api).f2()
    }
}
