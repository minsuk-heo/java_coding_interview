package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Created by minsukheo on 1/28/17.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum ts = new TwoSum();
        int[] result = ts.solution(nums,target);
        System.out.println(Arrays.toString(result));
    }

    private int[] solution(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(hash.containsKey(target - nums[i])){
                int[] result = new int[]{hash.get(target-nums[i]), i};
                return result;
            }
            else {
                hash.put(nums[i], i);
            }
        }
        return null;
    }
}
