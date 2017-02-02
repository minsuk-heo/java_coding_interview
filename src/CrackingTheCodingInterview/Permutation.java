package CrackingTheCodingInterview;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * Created by minsukheo on 1/14/17.
 */
public class Permutation {
    private static UpdateBits solution;

    public static void main(String[] args) {
        char[] arr = {'a','b','c'};
        Permutation solution = new Permutation();

        solution.run(arr);
    }

    private void run(char[] arr) {
        permutation(arr, 0);
    }

    private void permutation(char[] arr, int index) {
        for(int i=index;i<arr.length;i++) {
            swap(index,i,arr);
            permutation(arr, index+1);
            swap(i,index,arr);
        }
        if(index == arr.length-1) {
            System.out.println(new String(arr));
        }
    }

    private void swap(int i,int j,char arr[]) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
