package co.pipat.practice.leetcode.problem.p1929

/*
* 1929. Concatenation of Array
* https://leetcode.com/problems/concatenation-of-array/description/
* */
class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        return nums.plus(nums.copyOf())
    }
}