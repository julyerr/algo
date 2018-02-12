package com.julyerr.targetOffer.sort;

/**
 * 实现一个函数来调整数组中的数字，使得所有奇数位于数组的前半部分，偶数位于后半部分。
 */
public class OddBeforeEven {
//    使原来元素的相对顺序发生了改变
//    public void reOrderArray(int [] array) {
//        if(array == null || array.length ==0){
//            return;
//        }
//        int left = 0;
//        int right = array.length -1;
//        while(left < right){
//            while(left < right && array[left] % 2 ==1){
//                left++;
//            }
//            while(left < right && array[right] % 2 == 0){
//                right--;
//            }
//            if(left < right){
//                int tmp = array[left];
//                array[left] = array[right];
//                array[right] = tmp;
//                left++;
//                right--;
//            }
//        }
//    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] tmp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        OddBeforeEven oddBeforeEven = new OddBeforeEven();
        int[] nums = new int[]{3,8,8,9,2};
//        int[] nums = new int[]{1,1,1,1};
//        int[] nums = new int[]{2, 2, 2, 4};
        oddBeforeEven.reOrderArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
