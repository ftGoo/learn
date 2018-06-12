package com.wb.arithmetic.sort.quicksort;

/**
 * Created by wb on 2018/6/8
 * 通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个
 * 排序过程可以递归进行，以此达到整个数据变成有序序列。
 */


import java.util.Arrays;

/**
 * 疑问？快速排序为什么一定要先从右边开始。
 * 因为先从左边开始，如果找到比参考数大的数比较靠后，
 * 再从右往左找比参考数小的的数容易直接左右相遇，
 * 然后和参考数交换的数根本不满足条件。
 * 如果从右开始，即使找比参考数小的数在特别右的位置
 * 再从左开始，将参考数与该数交换是没有问题的。
 */
public class QuickSort {
    /**
     * 看完描述后的尝试实现
     * 从打印出来的情况看，明显错误了
     * 原因查找：大概是逻辑判断的位置错误，大while中条件中是i<j
     */
    public static void quickSortTry(int[] array, int low, int up){
        int i = low;
        int j = up;

        int reference = array[i];
        System.out.println("reference :" + reference);

        while(i < j) {
            while (array[j] > reference) {
                j--;
            }
            System.out.println("j位置" + array[j]);

            while (array[i] < reference) {
                i++;
            }
            System.out.println("i位置" + array[i]);

            if (i == j) {
                System.out.println("一轮结束");
                int temp = array[low];
                array[low] = array[i];
                array[i] = temp;

                quickSortTry(array, low, i - 1);
                quickSortTry(array, i + 1, up);

            } else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

            System.out.println(Arrays.toString(array));
        }

    }

    /**
     * 根据上面的错误，第二次尝试
     * 明显还是错误的。
     * @param array
     * @param low
     * @param up
     */
    public static void quickSortTry2(int[] array, int low, int up){
        int i = low;
        int j = up;

        int reference = array[i];
        System.out.println("reference :" + reference);

        while (i < j) {
            while (i < j && array[j] <= reference) {
                j--;
            }

            if(i == j){

            }
            while (i < j && array[i] >= reference) {
                i++;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }

        int temp = array[i];
        array[i] = reference;
        array[low] = temp;

        quickSortTry2(array, 0, i - 1);
        quickSortTry2(array, i + 1, up);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 第三次尝试
     * @param
     */
    public static void quickSortTry3(int[] array, int low, int up){
        if(low >= up){
            return;
        }

    }

    public static void quickPart(int[] array, int low, int up){
        int reference = array[low];


        while( low < up && array[up] < reference){
            up--;
        }
    }

    public static void main(String[] args) {
        int []array = {23,22,13,11,5,88,14,24,6,100,25,11,20,15,75,3};
        System.out.println("没问题吧？");
        quickSortTry2(array,0, array.length - 1);
    }
}
