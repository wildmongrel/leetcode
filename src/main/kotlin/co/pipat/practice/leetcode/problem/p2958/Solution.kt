package co.pipat.practice.leetcode.problem.p2958

/*
* 2958. Length of Longest Subarray With at Most K Frequency
*
* */
class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var maxStreak = 0
        var index = mutableMapOf<Int,Int>()
        var start = 0
        var end = 0
        do{
            index[nums[end]] = index.getOrDefault(nums[end],0) + 1
            while(index[nums[end]]!!>k){
                index[nums[start]] = index[nums[start]]!! - 1
                start++
            }
            maxStreak = Math.max(maxStreak,end-start+1)
            end++
        }while (end<nums.size)
        return maxStreak
    }

    /* Too slow */
    fun maxSubarrayLengthV1(nums: IntArray, k: Int): Int {
        var maxStreak = 0
        var streak = 0

        var index = mutableMapOf<Int,Int>()

        var i=0
        var prevStart = i

        do{
            val n = index[nums[i]]
//            println("index[${nums[i]}]:${index[nums[i]]}")
            if(n==null){
                index[nums[i]] = 1
                streak++
            }else{
                if(n<k){
                    index[nums[i]] = n+1
                    streak++
                }else{
                    maxStreak = Math.max(maxStreak,streak)
//                    println("streak:$streak, maxStreak:$maxStreak")
                    streak = 0
                    index = mutableMapOf()
//                    index[nums[prevStart]] = 1
                    i = prevStart
                    prevStart++
                }
            }
            i++
        }while (i<nums.size)
        maxStreak = Math.max(maxStreak,streak)
//        println("streak:$streak, maxStreak:$maxStreak")

        return maxStreak
    }
}