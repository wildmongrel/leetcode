package co.pipat.practice.leetcode.problem.p2962

import java.util.stream.Collectors

/*
*  2962. Count Subarrays Where Max Element Appears at Least K Times
*   https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
* */
class SolutionV0 {
    /*
    * v1 - sliding window, tick-tok
    * */
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var count = 0L
        var end:Int
        var map = LinkedHashMap<Int,Int>()
        var max = 0
        var ticktok = true
        var n:Int
        for (start in nums.indices){
            println("---------- start:$start ticktok:$ticktok")
            end = start+k
            if(ticktok){
                if(end>nums.size){
                    break;
                }
//                println("start:$start, cur:$cur, end:$end")
                if( map.entries.size==0 ){
                    max = 0
                    for(r in start until end){
                        n = nums[r]
                        map[n] = map.getOrDefault(n,0)+1
                        max = n.coerceAtLeast(max)
                    }
                    if(map[max]==k){
                        count++
                    }
                    log(count,max,map)
                }else{
                    n = nums[end-1]
                    map[n] = map.getOrDefault(n,0)+1
                    max = n.coerceAtLeast(max)

                    n = nums[start-1]
                    map[n] = map[n]!! - 1
                    if(max==n){
//                        println("---- 1 ----")
                        max = findNewMax(map)
                    }
                    if(map[max]!!>=k){
                        count++
                    }
                    log(count,max,map)
                }
                while(end<nums.size){
                    map[nums[end]] = map.getOrDefault(nums[end],0)+1
                    max = nums[end].coerceAtLeast(max)
                    if(map.getOrDefault(max,0)>=k){
                        count++
                    }
                    log(count,max,map)
                    end++
                }
            }else{
                n = nums[start-1]
                map[n] = map[n]!! - 1
                if(max==n){
//                    println("---- 2 ----")
                    max = findNewMax(map)
                }
                if(map[max]!!>=k){
                    count++
                }
                log(count,max,map)

                var r = nums.size-1
                while(start+k<=r){
                    n = nums[r]
                    map[n] = map[n]!! - 1
                    println("[1]---- max:$max")
                    if(max==n){
                        max = findNewMax(map)
                        println("[2]---- newMax:$max")
                    }
                    if(map[max]!!>=k){
                        count++
                    }
                    log(count,max,map)
                    r--
                }
            }
            ticktok = !ticktok
        }

        return count
    }

    private fun log(count: Long, max: Int, map: java.util.LinkedHashMap<Int, Int>) {
        println("count:$count, max:$max, map:$map")
    }

    private val predicate1: (Map.Entry<Int, Int>) -> Boolean = { entry ->
        entry.value !=null && entry.value>0
    }

    private fun findNewMax(map: java.util.LinkedHashMap<Int, Int>): Int {
        val sorted = map.entries.stream()
            .filter(predicate1)
            .sorted { o1, o2 ->
                o2.key - o1.key
            }.collect(Collectors.toList())
//        println("sorted:$sorted")
        return sorted.first().key
    }
}