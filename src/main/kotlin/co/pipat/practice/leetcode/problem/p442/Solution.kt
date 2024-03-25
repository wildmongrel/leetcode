package co.pipat.practice.leetcode.problem.p442

/*
* 442. Find All Duplicates in an Array
* https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
* */
class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val rs = mutableListOf<Int>()

        val map = mutableMapOf<Int,Boolean>()

        var i = 0
        while(i<nums.size){
            val n = nums[i]
            if(map[n]==null){
                map[n] = true
            }else{
                rs.add(n)
            }
            i++
        }

        return rs
    }
}