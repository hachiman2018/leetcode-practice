package problem

/**
 * 128 : 最长连续序列
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
class LeetCode128 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //
        }

        fun longestConsecutive(nums: IntArray): Int {
            if (nums.isEmpty()) {
                return 0
            }
            var result = 0
            val map = hashMapOf<Int, Int>()
            for (num in nums) {
                if (!map.containsKey(num)) {
                    // 获取当前数字左边的最大连续个数
                    val left = map.getOrDefault(num - 1, 0)
                    // 获取当前数字右边的最大连续个数
                    val right = map.getOrDefault(num + 1, 0)

                    // 设置当前数字的最大连续个数为1
                    // 如果在左右都没有连续数字的时候,当前最大连续个数就为1
                    // 如果左右两边存在最长连续的数量时,当前数字为中间节点,不会被 num+1 和num-1 获取到,所以为1也满足
                    map[num] = 1
                    // 当前数字的最大连续个数为 左右加上自身
                    val length = right + left + 1

                    result = result.coerceAtLeast(length)
                    // 更新最左边的最长连续个数
                    map[num - left] = length
                    // 更新最右边的最长连续个数
                    map[num + right] = length
                }
            }
            return result
        }
    }
}
