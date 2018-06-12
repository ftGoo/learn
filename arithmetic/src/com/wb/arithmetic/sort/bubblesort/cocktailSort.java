package com.wb.arithmetic.sort.bubblesort;

import java.util.Arrays;

/**
 * Created by wb on 2018/6/6
 */
public class cocktailSort {
    /**
     * 初步认识，鸡尾酒排序是冒泡排序的改进
     * 也叫双向冒泡排序
     */

    /**
     * 它的主要思路是对于一组无规律排放的数字，
     * 先找到最大的数字放到最后一位，在反向找到最小的数字放到第一位。
     * 然后再找第二大的数字放到倒数第二位，再找第二小的数字放到第二位。
     * 以此类推，直到所有数字有序排列。
     *
     * 下图1为确认位置的,直到1到底，所以叫鸡尾酒排序是因为图形像酒杯？
     * 1.。。。。。。。。。。。。。1
     *  1.。。。。。。。。。。。。1
     *   1.。。。。。。。。。。。1
     *    1.。。。。。。。。。。1
     *     1.。。。。。。。。。1
     *      1.。。。。。。。。1
     *       1.。。。。。。。1
     *        1.。。。。。。1
     *         1.。。。。。1
     *          1.。。。。1
     *             .....
     */

    //第一次自己的尝试实现
    //根据打印的结果来看，明显错了
    //错误分析：右向左移动的时候出错。
    public static int[] cocktailSort(int[] array){

        //由于是双向所以只需要进行array.length/2次,实际上还可以加上一个判断
        //（在一轮没有交换的时候提前结束排序，时间问题不写了）
        for(int i = 0; i < array.length / 2; i++){
            int index = 0;
            for(int j = 0 ; j <array.length- i -1 ; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                index = j;
            }
            /**
             * 以下注释大错特错，留下来提醒自己
             */
            //由于for循环中的index++已经执行完，index已经比正处于的值大1，
            // 再减去index位已经确定该位置的数字不需要再比较再向左挪动1位再减1
            //如果把index写在for循环里面，for(j){index = j}也不需要这么绕
            /*for(index = index - 1; index > i ; index--){
                if(array[index] < array[index -1]){
                    int temp = array[index];
                    array[index] = array[index -1];
                    array[index -1] = temp;
                }
            }*/

            //不是这个错误
            /**
            for(int j = index - 1; j > i ; j--){
             if(array[j] < array[j -1]){
             int temp = array[j];
             array[j] = array[j -1];
             array[j -1] = temp;
             }
             }
             */
            //错误原因已定位，index不可以-1（实际上index本来就只到arrany.length - 2的地方，坑啊）
            System.out.println("没毛病吧");
            System.out.println("index为" + index);
            for(int j = index; j > i ; j--){
                if(array[j] < array[j -1]){
                    int temp = array[j];
                    array[j] = array[j -1];
                    array[j -1] = temp;
                }
            }

            //继续探索


            System.out.println("轮数" + i);
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 对上一个自己琢磨的稍微优化
     */
    public static int[] cocktailSort2(int[] array){

        for(int i = 0; i < array.length / 2; i++){
            int index = 0;
            for(int j = i; j <array.length- i -1 ; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                index = j;
            }

            for(int j = index; j > i ; j--){
                if(array[j] < array[j -1]){
                    int temp = array[j];
                    array[j] = array[j -1];
                    array[j -1] = temp;
                }
            }

            System.out.println("轮数" + i);
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 网上参考别人的实现后的改进，好像比自己独立琢磨的优雅很多
     * 果然要多看
     */
    public static int[] cocktailSortByOthers(int[] array){
        int row, up;
        //数组下标的起始值，代表需要确定的最低位，比如0位上的数字确定完后，下一轮就为1
        row = 0;
        //数组下标的最高值，同上代表需要定位的最高位
        up = array.length - 1;
        //游标所在的位置
        while(row < up){
            for(int i = row; i < up; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }
            up--;

            for(int i = up; i > row; i--){
                if(array[i] < array[i - 1]){
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            row++;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    public static void main(String[] args) {
        int []array = {23,22,13,11,5,88,14,24,6,100,25,11,20,15,75,3};
        System.out.println("没问题吧？");
        cocktailSort2(array);
    }

}


