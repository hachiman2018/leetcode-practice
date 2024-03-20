package problem

/**
 * 283: 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
class LeetCode283 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }

        /**
         * 将所有非0的数字全部往前移
         */
        fun moveZeroes(nums: IntArray) {
            var position = 0

            for ((index, i) in nums.withIndex()) {
                if (i != 0) {
                    nums[index] = nums[position]
                    nums[position++] = i
                }
            }
        }
    }
}
