package problem

/**
 * 011: 盛最多的水
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
class LeetCode011 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //
        }

        /**
         * 双指针遍历数组
         * 移动指针时保留高度更高的边,移动高度更小的边
         */
        fun maxArea(height: IntArray): Int {
            var left = 0
            var right = height.lastIndex
            var result = 0

            while (left < right) {
                result = result.coerceAtLeast(height[left].coerceAtMost(height[right]) * (right - left))
                if (height[left] > height[right]) {
                    right--
                } else {
                    left++
                }
            }

            return result
        }
    }
}
