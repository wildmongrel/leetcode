package co.pipat.practice.leetcode.problem

import java.util.*

/*
* 20. Valid Parentheses
* https://leetcode.com/problems/valid-parentheses/description/
* */
class P20{
    fun isValid(s: String): Boolean {
        var stack = Stack<Char>()

        for (c in s.toCharArray()) {
            if(isOpenParentheses(c)){
                stack.push(c)
            }else{
                if(stack.empty()||!validParentheses(c, stack.pop())){
                    return false
                }
            }
        }
        return stack.empty()
    }

    private fun validParentheses(end: Char?, open: Char): Boolean {
        return (open=='('&&end==')')
                || (open=='['&&end==']')
                || (open=='{'&&end=='}')
    }

    private fun isOpenParentheses(c: Char): Boolean {
        if(c==null)
            return false
        if(c=='('||c=='['||c=='{')
            return true
        return false
    }
}