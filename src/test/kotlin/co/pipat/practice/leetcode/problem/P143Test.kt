package co.pipat.practice.leetcode.problem

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class P143Test {
    @InjectMocks
    lateinit var p:P143
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc001() {
        var head = P143.ListNode(1)
        var tail:P143.ListNode? = head

        tail = append(tail,2)
        tail = append(tail,3)
        tail = append(tail,4)

        var size = 4;

        p.reorderList(head)

        tail = head
        println("${tail.`val`},${tail.next?.`val`},${tail.next?.next?.`val`},${tail.next?.next?.next?.`val`}")

        tail = head;
        assertEquals(1,tail.`val`)
        tail = tail.next
        assertEquals(4,tail?.`val`)
        tail = tail?.next
        assertEquals(2,tail?.`val`)
        tail = tail?.next
        assertEquals(3,tail?.`val`)
    }

    @Test
    fun tc002() {
        var head = P143.ListNode(1)
        var tail:P143.ListNode? = head

        tail = append(tail,2)
        tail = append(tail,3)
        tail = append(tail,4)
        tail = append(tail,5)

        p.reorderList(head)

        tail = head
        println("${tail.`val`},${tail.next?.`val`},${tail.next?.next?.`val`},${tail.next?.next?.next?.`val`},${tail.next?.next?.next?.next?.`val`}")

        tail = head;
        assertEquals(1,tail.`val`)
        tail = tail.next
        assertEquals(5,tail?.`val`)
        tail = tail?.next
        assertEquals(2,tail?.`val`)
        tail = tail?.next
        assertEquals(4,tail?.`val`)
        tail = tail?.next
        assertEquals(3,tail?.`val`)
    }

    private fun append(tail: P143.ListNode?, i: Int): P143.ListNode? {
        if(tail!=null){
            var n = P143.ListNode(i)
            tail.next = n
            return n
        }
        return null
    }
}