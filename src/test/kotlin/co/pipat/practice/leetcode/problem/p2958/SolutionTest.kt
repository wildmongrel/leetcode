package co.pipat.practice.leetcode.problem.p2958

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class SolutionTest {
    @InjectMocks
    lateinit var solution: Solution
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc001() {
        assertEquals(6,solution.maxSubarrayLength(intArrayOf(1,2,3,1,2,3,1,2),2))
    }

    @Test
    fun tc002() {
        assertEquals(2,solution.maxSubarrayLength(intArrayOf(1,2,1,2,1,2,1,2),1))
    }

    @Test
    fun tc003() {
        assertEquals(4,solution.maxSubarrayLength(intArrayOf(5,5,5,5,5,5,5),4))
    }

    @Test
    fun tc004() {
        assertEquals(1,solution.maxSubarrayLength(intArrayOf(1),1))
    }

    @Test
    fun tc005() {
        assertEquals(3,solution.maxSubarrayLength(intArrayOf(1,1,1,3),2))
    }

    @Test
    fun tc006() {
        assertEquals(3,solution.maxSubarrayLength(intArrayOf(2,1,2,3),1))
    }
}