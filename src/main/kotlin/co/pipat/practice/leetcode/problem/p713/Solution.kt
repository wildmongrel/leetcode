package co.pipat.practice.leetcode.problem.p713

/*
* 713. Subarray Product Less Than K
* https://leetcode.com/problems/subarray-product-less-than-k/description/
* */
class Solution {
    /*
    * Beats 100% of users with Kotlin
    * Runtime: 260ms
    * Mem: 42.41MB
    *
    */
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var output = 0
        var theProduct:Long
        var focus:Int
        var nn:Int
        var start = 0
        do {
            focus = start
            theProduct = 1
            nn = 1
            do {
                theProduct*=nums[focus]
//                println("nn:$nn, nums($focus):${nums[focus]}, theProduct:$theProduct")
                if(theProduct<k){
                    output++
                }else{
                    break
                }
                focus++
                nn++
                if(start==0&&focus==nums.size){
                    return nums.size*(nums.size+1)/2
                }
            }while(focus<nums.size)
            start++
        }while (start<nums.size)

        return output
    }

    /*
    * Runtime: 1205ms
    * Mem: 41.24MB
    * */
    fun numSubarrayProductLessThanKV2(nums: IntArray, k: Int): Int {
        var output = 0
        var theProduct:Long
        var focus:Int
        var nn:Int
        var start = 0
        do {
            focus = start
            theProduct = 1
            nn = 1
            do {
                theProduct*=nums[focus]
//                println("nn:$nn, nums($focus):${nums[focus]}, theProduct:$theProduct")
                if(theProduct<k){
                    output++
                }else{
                    break
                }
                focus++
                nn++
            }while(focus<nums.size)
            start++
        }while (start<nums.size)

        return output
    }

    /* Too slow */
    fun numSubarrayProductLessThanKV1(nums: IntArray, k: Int): Int {
        var output = 0

        var theProduct = 1L

        var start = 0
        var end = 0
        var focus = 0

        var isAllExceeded:Boolean

        var i = 1
        var nn = 1
        while(i<=nums.size){
            end = nn
            start = 0
//            println("[1] i: $i, nn: $nn, nums.size: ${nums.size}")
            isAllExceeded = true
            while(end<=nums.size){
                theProduct = 1
                focus = start
                while(focus<end){
                    theProduct*=nums[focus++]
                    if(theProduct>=k){
                        break
                    }
//                    println("[3] focus: $focus, end: ${end}")
//                    println("[3] theProduct: $theProduct")
                }
//                println("[2] theProduct: $theProduct, k: $k")
                if(theProduct<k){
                    isAllExceeded = false
                    output++
                }else{
//                    println("[2] theProduct: $theProduct, nn: $nn")
                }
//                println("[2] output: $output")
//                println("[2] start: $start, end: $end")
                start++
                end = start+nn
            }
            if(isAllExceeded){
                return output
            }
            i++
            nn++
        }


        return output
    }
}