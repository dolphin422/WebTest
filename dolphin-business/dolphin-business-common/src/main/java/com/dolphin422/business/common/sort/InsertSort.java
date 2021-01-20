package com.dolphin422.business.common.sort;

/**
 * @Description: 插入排序
 * @author: DamonJT MAC
 * @createDate: 2021/1/19 16:53
 */
public class InsertSort {


    //核心代码---开始
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    //核心代码---结束
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        Integer[] arr = {3, 4, 7, 23, 45, 78, 13, 12, 34, 19};
        ShellSort.sort(arr);
        InsertSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}


