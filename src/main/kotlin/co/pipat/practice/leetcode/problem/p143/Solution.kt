package co.pipat.practice.leetcode.problem.p143

import co.pipat.practice.leetcode.common.ListNode
import java.util.*

/*
* 143. Reorder List
* https://leetcode.com/problems/reorder-list/description
* */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        if(head?.next==null||head?.next?.next==null){
            return
        }

        var stack = Stack<ListNode>()
        var slow = head
        var fast = head.next
        var pop: ListNode?=null
        var cur: ListNode?=null
        var next: ListNode?=null
        var prev: ListNode?=null
        stack.push(slow)
        while(fast!=null&&fast.next!=null){
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
            stack.push(slow)
            println("find center (slow,fast): ${slow?.`val`}, ${fast?.`val`}")
        }

        cur = slow
        next = cur?.next
        while(!stack.empty()&&next!=null){
            cur = next//cur 4->5
            next = cur?.next//next 5->null
            cur?.next = prev//cur 4->null

            pop = stack.pop()//pop 2->3
            pop.next = cur//pop 2->3

            prev = pop//prev
            println("cur,[pop]: ${cur?.`val`},[${pop.`val`}->${pop.next?.`val`}]")
        }
    }
}