package CrackingTheCodingInterview;

/**
 *
 * N = 10000000000
 * M = 10011
 * i = 2
 * j = 6
 * output : 10001001100
 *
 * Created by minsukheo on 1/14/17.
 *
 */
public class UpdateBits {

    public static void main(String[] args) {
        int N = 1024;   // 10000000000
        int M = 19;     // 10011
        int i = 2;
        int j= 6;

        UpdateBits solution = new UpdateBits();
        System.out.println(solution. run(N,M,i,j));
    }

    public int run(int N, int M, int i, int j){
        int val1 = N;
        for(int k=i;k<=j;k++){
            val1 = clearBit(val1, k);
        }
        int val2 = M << i;
        int result =  (val1 | val2);
        return result;
    }

    private int clearBit(int n, int index) {
        return n & ~(1 << index);
    }
}
