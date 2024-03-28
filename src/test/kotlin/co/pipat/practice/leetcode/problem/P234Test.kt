package co.pipat.practice.leetcode.problem

import co.pipat.practice.leetcode.common.ListNode
import co.pipat.practice.leetcode.problem.p234.Solution
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class P234Test {
    @InjectMocks
    lateinit var p: Solution

    var head: ListNode? = null
    var tail: ListNode? = null

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc01() {
        head = ListNode(1)
        tail = head

        tail = append(tail,2)
        tail = append(tail,2)
        tail = append(tail,1)

        assertTrue(p.isPalindrome(head))
    }

    @Test
    fun tc02() {
        head = ListNode(1)
        tail = head

        tail = append(tail,2)

        assertFalse(p.isPalindrome(head))
    }

    private fun append(tail: ListNode?, i: Int): ListNode? {
        if(tail!=null){
            var n = ListNode(i)
            tail.next = n
            return n
        }
        return null
    }
}