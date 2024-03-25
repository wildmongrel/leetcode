package co.pipat.practice.leetcode.problem

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class P20KtTest {
    @InjectMocks
    lateinit var p:P20

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc001() {
        assertTrue(p.isValid("()"))
    }

    @Test
    fun tc002() {
        assertTrue(p.isValid("(){}[]"))
    }

    @Test
    fun tc003() {
        assertFalse(p.isValid("(]"))
    }

    @Test
    fun tc004() {
        assertTrue(p.isValid("((()))"))
    }

    @Test
    fun tc005() {
        assertTrue(p.isValid("([{}])"))
    }
    @Test
    fun tc006() {
        assertFalse(p.isValid("([{]})"))
    }
}