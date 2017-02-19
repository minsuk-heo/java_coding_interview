package advanced;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 *  log(n) solution
 * Created by minsukheo on 2/18/17.
 */
public class IndexEqualsValue {
    public static void main(String[] args) {
        int[] arr = {-5,-3,-1,0,1,2,5,7,8,10,13};
        //            0, 1, 2,3,4,5,6,7,8,9, 10
        IndexEqualsValue solution = new IndexEqualsValue();
        int[] result = solution.run(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(result));
    }

    private int[] run(int[] arr, int start, int end) {
        int mid = (start + end)/2;
        int[] res;
        //value is greater than index
        if(arr[mid] < mid) {
            res = run(arr, mid+1, end);
        }
        else if(arr[mid] > mid) {
            res = run(arr, start, mid-1);
        }
        else {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(mid);
            int prev = mid-1;
            int next = mid+1;
            while (prev >= start) {
                if(arr[prev] == prev) {
                    aList.add(prev);
                }
                prev--;
            }
            while (next <= end) {
                if(arr[next] == next) {
                    aList.add(next);
                }
                next++;
            }

            res = new int[aList.size()];
            for(int i = 0; i< aList.size(); i++) {
                res[i] = aList.get(i);
            }
        }

        return res;
    }
}
