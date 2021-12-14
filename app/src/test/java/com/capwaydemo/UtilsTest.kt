package com.capwaydemo

import com.capwaydemo.Utils.validateEmail
import com.capwaydemo.Utils.validateEmailOrPhone
import org.junit.Assert
import org.junit.Test

class UtilsTest {

    @Test
    fun emailTest1() {
        Assert.assertEquals(false, validateEmail("dras"))
    }

    @Test
    fun emailTest2() {
        Assert.assertEquals(false, validateEmail(""))
    }

    @Test
    fun emailTest3() {
        Assert.assertEquals(false, validateEmail(" "))
    }

    @Test
    fun emailTest4() {
        Assert.assertEquals(false, validateEmail("jake@jake"))
    }

    @Test
    fun emailTest5() {
        Assert.assertEquals(true, validateEmail("jake@jake.com"))
    }

    @Test
    fun emailTest6() {
        Assert.assertEquals(true, validateEmail("jake@jake.edu"))
    }

    @Test
    fun emailTest7() {
        Assert.assertEquals(true, validateEmail("jake@jake.co"))
    }

    @Test
    fun phoneOrEmailTest() {
        Assert.assertEquals(true, validateEmailOrPhone("jake@jake.co"))
    }

    @Test
    fun phoneOrEmailTest2() {
        Assert.assertEquals(false, validateEmailOrPhone("5515"))
    }

    @Test
    fun phoneOrEmailTest3() {
        Assert.assertEquals(true, validateEmailOrPhone("8541455585"))
    }

    @Test
    fun phoneOrEmailTest4() {
        Assert.assertEquals(false, validateEmailOrPhone("sdfs"))
    }
}
