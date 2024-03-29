package co.pipat.practice.leetcode.problem.p2962

import java.time.LocalDateTime

/*
*  2962. Count Subarrays Where Max Element Appears at Least K Times
*   https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
* */
class SolutionV1 {
    /*
    * v1 - sliding window, tick-tok
    * */
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val start = System.nanoTime()
        var count = 0L
        var end:Int
        var map = LinkedHashMap<Int,Int>()
        var max = 0
        var ticktok = true
        var n:Int

        val t21 = System.nanoTime()
        for (num in nums) {
            max = num.coerceAtLeast(max)
        }
        printTimeUsage("Finding max: $max",t21)

        for (start in nums.indices){
            println("---------- start:$start ticktok:$ticktok")
            val loopTime = System.nanoTime()

            end = start+k
            if(ticktok){
//                println("---------- end:$end nums.size:${nums.size}")
                if(end>nums.size){
                    break;
                }
//                println("start:$start, cur:$cur, end:$end")
                if( map.entries.size==0 ){
                    for(r in start until end){
                        n = nums[r]
                        map[n] = map.getOrDefault(n,0)+1
                    }
                    if(map[max]==k){
                        count++
                    }
//                    log(count,max,map)
                }else{
                    n = nums[end-1]
                    map[n] = map.getOrDefault(n,0)+1

                    n = nums[start-1]
                    map[n] = map[n]!! - 1
                    if(map.getOrDefault(max,0)>=k){
                        count++
                    }
//                    log(count,max,map)
                }
                while(end<nums.size){
                    map[nums[end]] = map.getOrDefault(nums[end],0)+1

                    if(map.getOrDefault(max,0)>=k){
                        count++
                    }
//                    log(count,max,map)
                    end++
                }
            }else{
                n = nums[start-1]
                map[n] = map[n]!! - 1

                if(map.getOrDefault(max,0)>=k){
                    count++
                }

//                log(count,max,map)

                var r = nums.size-1
                while(start+k<=r){
                    n = nums[r]
                    map[n] = map[n]!! - 1

                    if(map.getOrDefault(max,0)>=k){
                        count++
                    }
//                    log(count,max,map)
                    r--
                }
            }
            ticktok = !ticktok
            printTimeUsage("loop time",loopTime)
        }

        printTimeUsage("Total",start)
        return count
    }

    private fun printTimeUsage(prefix:String,nano: Long) {
        val timeusedNano = System.nanoTime() - nano
        println("$prefix, Time used: ${timeusedNano/1000.00} micro second")
    }

    private fun log(count: Long, max: Int, map: java.util.LinkedHashMap<Int, Int>) {
//        println("count:$count, max:$max, map:$map")
    }


}