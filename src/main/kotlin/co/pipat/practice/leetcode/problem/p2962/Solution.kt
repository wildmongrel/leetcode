package co.pipat.practice.leetcode.problem.p2962

/*
*  2962. Count Subarrays Where Max Element Appears at Least K Times
*   https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
* */
class Solution {
    /*
    * v2 - sliding window
    * */
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var ans = 0L;
        var count = 0L
        var max = Int.MIN_VALUE
        var left = 0
        var right = 0

        for (num in nums) {
            max = num.coerceAtLeast(max)
        }

        do{
            if(nums[right]==max){
                count++
            }
            while (count>=k){
                ans+= nums.size - right

                if(nums[left]==max){
                    count--
                }
                left++
            }
            right++
        }while(right<nums.size)


        return ans
    }
}