package com.lzx.algorithm.xor;

/**
 * 异或运算相关练习
 * <p>异或运算特性：相同为0 ，不同为1</p>
 * <p>N=N^0</p>
 * <p>0=N^N</p>
 * <p>异或运算等价于无进位相加</p>
 * <p>1.不使用临时变量交换两个数</p>
 * <p>2.一个数组中只有一个数出现奇数次，其他都出现偶数次，把这个数找出来</p>
 * <p>3.怎么把一个int类型的数，提取出最右侧的1(对应二进制)
 * 6对应的二进制位 0000 0110,那么取出来的应该是0000 0010
 * 对原数0000 0110取反， (1)1111 1001，这时候加1 ,结果为(1)1111 1010，将上一步结果与原数&
 * 0000 0110
 * & 1111 1010
 * 0000 0010
 * num&(~num+1) == num&(-num)
 * </p>
 * <p>4.一个数组中有两个数出现奇数，其他数都出现偶数，把这两个数找出来</p>
 * <p>5.一个数组中有一个数出现K次，其他都出现M次，M>1  k<M ，找出出现K次的数,要求空间复杂度O(1),时间复杂度O(N)</p>
 */
public class Xor {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 3, 4, 5, 6, 6, 7, 7};
        System.out.println(oneOdd(arr));
        System.out.println(findBit1RightNumber(6));
        int[] arr2 = {1,2,1,2,3,4};
        printArr(twoOddAndOtherDouble(arr2));
    }

    private static void printArr(int[] twoOddAndOtherDouble) {
        for (int i = 0; i < twoOddAndOtherDouble.length; i++) {
            System.out.print(twoOddAndOtherDouble[i] + ",");
        }
        System.out.println();
    }

    /**
     * 一个数组中只有一个数出现奇数次，其他都出现偶数次，把这个数找出来
     * 利用 N =N^0 ;0=N^N;特性,偶数异或为0
     *
     * @param arr
     * @return
     */
    public static int oneOdd(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = arr[i] ^ xor;
        }
        return xor;
    }


    /**
     * <p>3.怎么把一个int类型的数，提取出最右侧的1(对应二进制)</p>
     * <p>6对应的二进制位 0000 0110,那么取出来的应该是0000 0010
     * 对原数0000 0110取反， (1)1111 1001，这时候加1 ,结果为(1)1111 1010，将上一步结果与原数&
     * 0000 0110
     * & 1111 1010
     * 0000 0010 即可获取结果
     * <p>
     * 又等价于num&(-num)
     * </p>
     *
     * @param num
     * @return
     */
    public static int findBit1RightNumber(int num) {
//        return num&(~num +1);
        return num & (-num);
    }

    /**
     * <p>一个数组中有两个数出现奇数，其他数都出现偶数，把这两个数找出来</p>
     * <p>
     *     前置知识
     *  1.异或特性
     *  0=N^N
     *  N=0^N
     *  2.取一个数最右侧1对应的十进制N&(-N)
     *  </p>
     *  <p> 解：
     *  只有两个a,b未知的数出现奇数，eox = 0 ，eox ^= arr[i] 等价于eox=a^b ;
     *  取eox最右侧不为0的数位置记为i， rightOne = eox & (-eox)；因a!=b，rightOne有一个作用是将arr分为两部分，其中一部分为在i位置为0，
     *  另一部分在i不为0，如果是出现偶数次的数在i上也不为0 ，那异或偶数次必然为0；出现奇数次的数在i位置不为0，奇数次异或得出其本身，
     *  而另一个数只需要与eox异或即可得其结果
     *
     *  </p>
     * @param arr
     * @return
     */
    public static int[] twoOddAndOtherDouble(int[] arr) {
        int eox = 0;
        for (int i = 0; i < arr.length; i++) {
            eox ^= arr[i];
        }
        int rightOne = eox & (-eox);
        //取eox左右侧1对应二进制 rightOne，因a,b不相等，所以rightOne!=0,
        //其实rightOne相当于把数组分为两部分，在i位置上为0的数和不为0的数，而a,b必然存在一个数在i上不为0，设为onlyOne
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        int[] result = {onlyOne, (onlyOne ^ eox)};
        return result;
    }

    /**
     * 一个数组中有一个数出现K次，其他都出现M次，M>1 k
     * @param arr
     * @return
     */
    public static int km(int[] arr){

    }
}
