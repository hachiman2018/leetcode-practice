package problem

/**
 * 015: 三数之和
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
class LeetCode015 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            val result = arrayListOf<List<Int>>()
            val size = nums.size

            for (index in 0 until size - 2) {
                // 排序后 index后的所有都大于0 则不可能三个整数相加等于0
                if (nums[index] > 0) {
                    break
                }
                // 如果移动index位置时第一位数相同则跳过,因为前面已经对该种情况处理了
                if (index > 0 && nums[index] == nums[index - 1]) {
                    continue
                }
                // 左指针,遍历第二个数
                var left = index + 1
                // 右指针,遍历第三个数
                var right = size - 1

                while (left < right) {
                    val middleSum = nums[left] + nums[right]
                    // 三数相加等于0
                    if (middleSum == -nums[index]) {
                        result.add(listOf(nums[index], nums[left], nums[right]))
                        left++
                        right--
                        // 过滤掉相同的第二位数
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++
                        }
                        // 过滤掉相同的第三位数
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--
                        }
                    } else if (middleSum > -nums[index]) {
                        right--
                    } else {
                        left++
                    }
                }
            }

            return result
        }
    }
}
