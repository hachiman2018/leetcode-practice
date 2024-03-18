package problem

/**
 * 049:字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 */
class LeetCode049 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
            val result = groupAnagrams(strs)
            print(result)
        }

        /**
         * 排序每个字符串对应的字符数组并分组
         */
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = hashMapOf<String, MutableList<String>>()

            var charArray: CharArray?
            for (str in strs) {
                charArray = str.toCharArray()
                charArray.sort()

                map.getOrPut(charArray.contentToString()) {
                    mutableListOf()
                }.add(str)
            }

            return ArrayList(map.values)
        }

        /**
         * 遍历字符串的字符数组,按照升序拼接(也是达到字母排序的效果)并分组
         */
        fun groupAnagrams1(strs: Array<String>): List<List<String>> {
            val map = hashMapOf<String, MutableList<String>>()

            for (str in strs) {
                val count =
                    IntArray(26).also {
                        str.forEachIndexed { _, c ->
                            it[c - 'a']++
                        }
                    }
                println("str is $str")
                println("count is $count")
                val key =
                    StringBuilder().also {
                        count.forEachIndexed { index, c ->
                            if (c > 0) {
                                println("count: index is  $index, c is $c")
                                it.append((index + 'a'.code).toChar())
                                it.append(c)
                            }
                        }
                    }.toString()
                println("key === $key")

                map.getOrPut(key) {
                    mutableListOf()
                }.add(str)
            }

            return ArrayList(map.values)
        }
    }
}
