package BitOperator;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by minsukheo on 1/14/17.
 */
public class BitOperatorTest {
    public static void main(String[] args) {
        int i = 10; // 1010 in decimal expression
        BitOperatorTest bitUtil = new BitOperatorTest();
        System.out.println(bitUtil.getBit(i, 0));
        System.out.println(bitUtil.getBit(i, 1));
        System.out.println(bitUtil.getBit(i, 2));
        System.out.println(bitUtil.getBit(i, 3));
        System.out.println();
        System.out.println(bitUtil.setBit(i, 0));
        System.out.println(bitUtil.setBit(i, 1));
        System.out.println(bitUtil.setBit(i, 2));
        System.out.println(bitUtil.setBit(i, 3));
        System.out.println();
        System.out.println(bitUtil.clearBit(i, 0));
        System.out.println(bitUtil.clearBit(i, 1));
        System.out.println(bitUtil.clearBit(i, 2));
        System.out.println(bitUtil.clearBit(i, 3));
        
        
    }

    private int clearBit(int i, int index) {
        return i & ~(1 << index);
    }

    private int setBit(int i, int index) {
        return (i | (1 << index));
    }

    private int getBit(int i, int index) {
        return (i & (1 << index)) >> index;
    }
}
