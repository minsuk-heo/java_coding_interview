package LeetCode;

public class Combinations {
    public static void main(String[] args) {
        Combinations test = new Combinations();
        test.solution(4,2);
    }

    private void solution(int n, int k) {
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = i+1;
        }
        int[] data = new int[k];
        getCombination(input, data, 0, 0 ,k);
    }

    private void getCombination(int[] input, int[] data, int start, int index, int k) {
        if(index == data.length){
            for(int i : data){
                System.out.print(i);
            }
            System.out.println();
        }
        else {
            for(int i = start; i<input.length; i++){
                if(i+k-1 < input.length) {
                    data[index] = input[i];
                    getCombination(input, data, input[i], index + 1, k-1);
                }
            }

        }
    }
}
