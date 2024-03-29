package co.pipat.practice.leetcode.problem

import co.pipat.practice.leetcode.common.ListNode
import co.pipat.practice.leetcode.problem.p143.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class SolutionV0Test {
    @InjectMocks
    lateinit var p: Solution
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun tc001() {
        var head = ListNode(1)
        var tail: ListNode? = head

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
        var head = ListNode(1)
        var tail: ListNode? = head

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

    private fun append(tail: ListNode?, i: Int): ListNode? {
        if(tail!=null){
            var n = ListNode(i)
            tail.next = n
            return n
        }
        return null
    }
}