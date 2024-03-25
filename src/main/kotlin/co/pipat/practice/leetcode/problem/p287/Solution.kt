package co.pipat.practice.leetcode.problem.p287

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var j=0;
        var i=0;
        while(i<nums.size) {
            j=i+1;
            while(j<nums.size){
                if(nums[i]==nums[j]){
                    return nums[i]
                }
                j++
            }
            i++
        }
        return 0
    }
}