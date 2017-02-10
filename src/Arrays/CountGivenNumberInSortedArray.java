package Arrays;

/**
 *
 * 1. Sorted int array with repeated number. Give number k, return the count of k in this array.
 * {2,6,6,6,7,8,8,9} , 5 = 0
 * {2,6,6,6,7,8,8,9} , 6 = 3
 *
 * must be log(n) time complexity
 *
 * Created by minsukheo on 2/9/17.
 */

public class CountGivenNumberInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,6,6,6,7,8,8,9};
        CountGivenNumberInSortedArray cg = new CountGivenNumberInSortedArray();
        int cnt = cg.solution(arr,7);
        System.out.println(cnt);
    }

    private int solution(int[] arr, int k) {
        int mid = (0 + arr.length-1) / 2;
        return countGivenNumber(arr, k, mid, 0 , arr.length-1);
    }

    private int countGivenNumber(int[] arr, int k, int mid, int start, int end) {
        // when given number doesn't exist in given array
        if( (mid == 0 || mid == arr.length -1) && arr[mid] != k) {
            return 0;
        }
        // binary search in array
        if(k > arr[mid] && k < arr[end]) {
            int new_mid = (mid + end) / 2;
            return countGivenNumber(arr, k, new_mid, mid, end);
        }
        else if(k < arr[mid] && k > arr[start]) {
            int new_mid = (start + mid) / 2;
            return countGivenNumber(arr, k, new_mid, start, mid);
        }
        else{
            // k is arr[mid]
            int left = mid-1;
            int right = mid+1;
            int cnt = 1;
            while(arr[left] == k) {
                left--;
                cnt++;
            }
            while(arr[right] == k) {
                right++;
                cnt++;
            }
            return cnt;
        }
    }
}
