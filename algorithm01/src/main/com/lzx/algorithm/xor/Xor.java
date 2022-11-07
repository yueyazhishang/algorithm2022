package com.lzx.algorithm.xor;

/**
 * 异或运算相关练习
 * <p>异或运算特性：相同为0 ，不同为1</p>
 * <p>N=N^0</p>
 * <p>0=N^N</p>
 * <p>异或运算等价于无进位相加</p>
 * <p>1.不使用临时变量交换两个数</p>
 * <p>2.一个数组中只有一个数出现奇数次，其他都出现偶数次，把这个数找出来</p>
 * <p>3.怎么把一个int类型的数，提取出最右侧的1(对应二进制)</p>
 * <p>4.一个数组中有两个数出现奇数，其他数都出现偶数，把这两个数找出来</p>
 * <p>5.一个数组中有一个数出现K次，其他都出现M次，M>1  k<M ，找出出现K次的数,要求空间复杂度O(1),时间复杂度O(N)</p>
 */
public class Xor {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,3,4,5,6,6,7,7  };
        System.out.println(oneOdd(arr));
    }

    /**
     * 一个数组中只有一个数出现奇数次，其他都出现偶数次，把这个数找出来
     * 利用 N =N^0 ;0=N^N;特性,偶数异或为0
     * @param arr
     * @return
     */
    public static int oneOdd(int[] arr){
        int xor=0;
        for(int i = 0; i < arr.length; i++){
            xor =arr[i]^xor;
        }
        return xor;
    }
}
