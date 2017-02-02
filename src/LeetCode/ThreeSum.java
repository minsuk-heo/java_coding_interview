package LeetCode;

import java.util.*;

/**
 *
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *    [-1, 0, 1],
 *    [-1, -1, 2]
 * ]
 *
 * Created by minsukheo on 1/20/17.
 */
public class ThreeSum
{
    public static void main(String[] args) {
        int[] input = {0,0,0};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> results = ts.solution(input);
        System.out.println(results);

    }

    private List<List<Integer>> solution(int[] nums) {
        Map<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int target = 0;

        for(int i=0;i<nums.length;i++) {
            target = 0 - nums[i];
            hash.clear();
            for(int j=0;j<nums.length;j++) {
                if(i != j){
                    if(hash.containsKey(target-nums[j])) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(target-nums[j]);
                        result.add(nums[j]);
                        Collections.sort(result);
                        if(!results.contains(result))
                            results.add(result);
                    }
                    else {
                        hash.put(nums[j], true);
                    }
                }

            }
        }
        return results;
    }
}
