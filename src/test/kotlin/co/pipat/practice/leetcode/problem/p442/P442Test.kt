package co.pipat.practice.leetcode.problem.p442

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class P442Test {
    @InjectMocks
    lateinit var solution:Solution
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc001() {
        val rs = solution.findDuplicates(intArrayOf(4,3,2,7,8,2,3,1))
        assertEquals(2,rs.size)
        assertEquals(2,rs[0])
        assertEquals(3,rs[1])
    }

    @Test
    fun tc002() {
        val rs = solution.findDuplicates(intArrayOf(1,1,2))
        assertEquals(1,rs.size)
        assertEquals(1,rs[0])
    }

    @Test
    fun tc003() {
        val rs = solution.findDuplicates(intArrayOf(1))
        assertEquals(0,rs.size)
    }
}