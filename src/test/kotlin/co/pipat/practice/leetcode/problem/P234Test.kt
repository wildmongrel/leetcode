package co.pipat.practice.leetcode.problem

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.w3c.dom.NodeList

class P234Test {
    @InjectMocks
    lateinit var p: P234

    var head:P234.ListNode? = null
    var tail:P234.ListNode? = null

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc01() {
        head = P234.ListNode(1)
        tail = head

        tail = append(tail,2)
        tail = append(tail,2)
        tail = append(tail,1)

        assertTrue(p.isPalindrome(head))
    }

    @Test
    fun tc02() {
        head = P234.ListNode(1)
        tail = head

        tail = append(tail,2)

        assertFalse(p.isPalindrome(head))
    }

    private fun append(tail: P234.ListNode?, i: Int): P234.ListNode? {
        if(tail!=null){
            var n = P234.ListNode(i)
            tail.next = n
            return n
        }
        return null
    }
}