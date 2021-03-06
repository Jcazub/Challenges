import java.util.HashMap;
import java.util.Map;

class TwoSum {

    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Ex.
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
     */

    public int[] myTwoSum(int[] nums, int target) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            valueMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if (valueMap.containsKey(complement) && valueMap.get(complement) != i)
            {
                return new int[]{i, valueMap.get(complement)};
            }
        }
        return null;
    }

    public int[] optimalTwoPassTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] optimalOnePassTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}