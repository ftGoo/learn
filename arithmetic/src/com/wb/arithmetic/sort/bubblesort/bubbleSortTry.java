package com.wb.arithmetic.sort.bubblesort;

import java.util.Arrays;

/**
 * Created by wb on 2018/6/6
 冒泡排序算法的原理如下：
 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 针对所有的元素重复以上的步骤，除了最后一个。
 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class bubbleSortTry {

    /**
     * 在不太记得冒泡排序时的一次尝试，显然结果是错误的
     * 排序前
     *  [23, 12, 13, 11, 5, 88, 14, 24]
     * 排序过程
     *  [23, 12, 13, 11, 5, 88, 14, 24]
     *  [12, 13, 11, 5, 23, 14, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
        [12, 11, 5, 13, 14, 23, 24, 88]
     *排序后
     *[12, 11, 5, 13, 14, 23, 24, 88]
     * 错误分析：末尾length - i位已排序不需要再对比，而前面的元素位置还未确定
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1 ; i++){
            for(int j = i ; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 第二次尝试
     * 证实是正确版本
     * @param array
     * @return
     */
    public static int[] bubbleSort2(int[] array){
        for(int i = 0; i < array.length - 1 ; i++){
            for(int j = 0 ; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                //System.out.print(Arrays.toString(array));
            }
            System.out.println("轮数:" + (i+1));
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 网上流传的一个实现
     * 和我上一个自己推导出来的区别是，一个是相邻对比满足条件的调换，一个是两两对比让起始位置的数字确定。
     * 根据以下描述，这傻吊实现的根本不是冒泡算法
     *
     * 冒泡排序算法的原理如下：
     比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     针对所有的元素重复以上的步骤，除了最后一个。
     持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param array
     */
    public static int[] bubbleSort3(int[] array){
        for(int i = 0; i< array.length-1 ; i ++){
            for(int j = i+1; j< array.length; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    public static void main(String[] args) {
        int []array = {23,22,13,11,5,88,14,24,6,100,25,11,20,15,75,3};
        System.out.println("经过错误改版后的");
        bubbleSortTry.bubbleSort3(array);
    }
}
