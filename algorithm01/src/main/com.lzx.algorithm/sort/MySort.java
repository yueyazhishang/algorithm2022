package com.lzx.algorithm.sort;

/**
 * 常见排序
 * 1.选择
 * 2.冒泡
 * 3.插入
 * 4.归并
 */
public class MySort {

    public static void main(String[] args) {
        int maxLength = 600;
        int maxValue = 1000;
        int runTimes = 1000;
        System.out.println("begin...");
        for (int i = 0; i < runTimes; i++) {
            int[] nums = genRandomArray(maxLength, maxValue);
//            print(nums);
            mergeSort(nums ,0 ,nums.length-1);
            if (!checkSort(nums)) {
                print(nums);
                break;
            }
        }
        System.out.println("over...");
    }

    /**
     * 4.归并排序
     */
    public static void mergeSort(int[] nums, int left, int right) {
        //best case
        if(left==right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        //左
        mergeSort(nums, left, mid);
        //右
        mergeSort(nums, mid + 1, right);
        //整体merge
          processMerge(nums, mid, left, right);
    }

    private static void processMerge(int[] nums, int mid, int left, int right) {
        int[] helper = new int[right - left + 1];
        int helperIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= right) {
            helper[helperIndex++] = nums[leftIndex] < nums[rightIndex] ? nums[leftIndex++] : nums[rightIndex++];
        }

        while (rightIndex <= right) {
            helper[helperIndex++]=nums[rightIndex++];
        }
        while (leftIndex <= mid) {
            helper[helperIndex++]=nums[leftIndex++];
        }

        for (int i = 0; i < helper.length; i++) {
            nums[left+i] =helper[i];
        }

    }

    /**
     * <p>插入排序</p>
     * <p>1.认为0-0 有序</p>
     * <p>2.新来位置1，比较01，如果0大于1则交换，此时索引来到0，前面没有数字，此时01有序</p>
     * <p>3.新来位置2，比较12，如果1不大于2 则终止，如果1>2则交换，此时索引来到1，比较01，若0大则交换，前面没有数字，此时02有序</p>
     * <p>4.直到插入n-1, 比较n-1与n-2,n-2与n-3 ,1与0 ,如果前面存在较小元素则交换，否则终止</p>
     * <p>终止比较条件 </p>
     * 0  1  2  3  4  5
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            while (index > 0 && nums[index - 1] > nums[index]) {
                swap(nums, index - 1, index);
                index--;
            }
        }

    }

    /**
     * 冒泡排序
     * <p>1.依次比较01，12，23，34，45；如果较小位置大于较大位置则交换，此时0位置最小</p>
     * <p>2.依次比较12，23，34，45；如果较小位置大于较大位置则交换，此时1位置最小</p>
     * <p>2.依次比较23，34，45；如果较小位置大于较大位置则交换，此时2位置最小</p>
     * <p>直到n-1,n进行比较进行比较 n为数组长度-1，此时已经有序 </p>
     * 0  1  2  3  4  5
     * 01 12 23 34 45(5最大)
     * 01 12 23 34(4最大)
     * 01 12 23(3最大)
     * 01 12(2最大)
     * 01(1最大)
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int second = 0; second < i; second++) {
                if (nums[second] > nums[second + 1]) {
                    swap(nums, second, second + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * tips:
     * <p>1.认为0位置最小，依次比较01，02，03，04，05 如果0位置非较小值则交换，此时0位置最小（0-5中）</p>
     * <p> 2.认为1-6中1较小，依次比较12，13，14，15 如果1位置非较小值则交换，此时1位置最小(1-5中)</p>
     * <p>3.认为2-6中2较小，依次比较23，24，25 ，如果2位置非较小值则交换，此时2位置最小(2-5中)</p>
     * 直到n-1(n为数组长度)
     *
     * <p> 0  1  2  3  4  5</p>
     * <p>    01 02 03 04 05</p>
     * <p>       12 13 14 15</p>
     * <p>          23 24 25</p>
     * <p>             34 35</p>
     * <p>                45</p>
     */
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            swap(nums, minIndex, i);
            /*for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }*/
        }

    }

    public static boolean checkSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        //相邻左大，则不返回false
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];//i^j^j ==i
        nums[i] = nums[i] ^ nums[j];//i^j^i
    }

    public static int[] genRandomArray(int maxLength, int maxValue) {
        int[] nums = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            nums[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return nums;
    }
}
