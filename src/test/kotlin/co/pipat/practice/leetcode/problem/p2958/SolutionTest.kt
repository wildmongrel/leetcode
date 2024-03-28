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
}