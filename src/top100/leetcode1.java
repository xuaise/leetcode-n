package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] resArray = new int[2];
        Map<Integer, Integer> valueToIndexMap = new HashMap();
        for(int i = 0; i < nums.length; i ++ ){
            Integer otherPlusValue = target - nums[i];
            Integer otherIndex = valueToIndexMap.get(otherPlusValue);
            if(otherIndex != null){
                resArray[0] = i;
                resArray[1] = otherIndex;
                return resArray;
            }else{
                valueToIndexMap.put(nums[i], i);
            }
        }
        return resArray;
    }
}

/**
 * 题解1：由于给定数组中没有重复的数，所以可用hashmap存储做记忆，<k, v> -> <nums数组的值，数组下标>，代码为题解一代码
 * 题解思路2：先排序，然后双指针，两个指针分别指向数组开始和尾部，然后向中间移动，遇到满足条件的返回
 */