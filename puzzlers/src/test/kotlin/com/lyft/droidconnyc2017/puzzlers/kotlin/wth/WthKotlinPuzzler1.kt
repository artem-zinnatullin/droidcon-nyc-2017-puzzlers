package com.lyft.droidconnyc2017.puzzlers.kotlin.wth

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class WthKotlinPuzzler1 {

    // Will this test pass and why?
    @Test
    fun puzzler() {
        val unit = Gson().fromJson("{}", Unit::class.java)
        assertEquals(Unit, unit)
    }

    // Will this test pass and why?
    @Test
    fun puzzler2() {
        assertEquals(Unit, Gson().fromJson("{}", Unit::class.java))
    }

    // Will this test pass and why?
    @Test
    fun puzzler3() {
        val unit1 = Gson().fromJson("{}", Unit::class.java)
        val unit2 = Gson().fromJson("{}", Unit::class.java)

        assertEquals(unit1, unit2)
    }
}
