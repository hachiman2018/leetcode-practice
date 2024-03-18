package problem

/**
 *  001: 两数之和
 *
 *  https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 *  用map存放每个数的索引，然后遍历数组，判断是否存在target - nums[i]
 */
class LeetCode001 {
    fun twoSum(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (map.containsKey(diff)) {
                return intArrayOf(map.getValue(diff), i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}
