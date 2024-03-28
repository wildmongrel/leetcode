package co.pipat.practice.leetcode.problem.p234

import co.pipat.practice.leetcode.common.ListNode
import java.util.*

/*
* 234. Palindrome Linked List
* https://leetcode.com/problems/palindrome-linked-list
* */
class Solution {

    fun isPalindrome(head: ListNode?): Boolean {
        var h = head
        var slow = head
        var fast = head!!.next
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        var rev = reverse(slow!!.next) // reverse second list

        slow.next = null
        while (rev != null) {
            if (h?.`val` !== rev.`val`) {
                return false
            }
            h = h?.next
            rev = rev.next
        }
        return true
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
//        var list = ArrayList<ListNode>()
//        if(n==null)
//            list
//
//        var node = n
//        while(node!=null){
//            list.add(0,node)
//            node = node?.next
//        }
//        return list
    }

    // stack
    fun isPalindromeV2(head: ListNode?): Boolean {
        if(head==null||head?.next==null)
            return true

        var stack = Stack<ListNode>()

        var size = 0;

        var pt: ListNode? = head
        while(pt!=null){
            size++;
            stack.push(pt)
            pt = pt?.next
//            println("head.val: ${head?.`val`}")
//            println("pt.val: ${pt?.`val`}")
        }
//        println("size: $size")

        var ci = (size+1)/2
//        println("center: $ci")

        var left: ListNode? = head
        var right: ListNode? = stack.pop()

        size = 0;
        do {
            if(left?.`val`!=right?.`val`){
                return false
            }
            left = left?.next
            right = stack.pop()
            size++
        }while(size!=ci)
        return true
    }

    // String manipulation
    fun isPalindromeV1(head: ListNode?): Boolean {
        if(head==null||head?.next==null)
            return true;

        var a:StringBuilder = StringBuilder()
        var b:StringBuilder = StringBuilder()
        var size = 0;
        var cur: ListNode?=head

        do{
            a.append(cur?.`val`)
            b.insert(0,cur?.`val`)
            size++
            cur = cur?.next
        }while(cur!=null)

        return a.substring(0,size/2).equals(b.substring(0,size/2))
    }
}