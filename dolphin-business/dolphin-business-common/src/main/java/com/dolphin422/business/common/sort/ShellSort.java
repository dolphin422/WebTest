package com.dolphin422.business.common.sort;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2021/1/19 16:24
 */
public class ShellSort {


    //核心代码---开始
    public static void sort(Comparable[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            System.out.println("gap：" + gap);
            for (int i = gap; i < arr.length; i++) {
                System.out.println("   i:" + i);
                Comparable tmp = arr[i];
//                for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
//                    arr[j] = arr[j - gap];
//                }
                for (j = i; j >= gap; j -= gap) {
                    System.out.println("       j:" + j);
                    if (tmp.compareTo(arr[j - gap]) < 0) {
                        arr[j] = arr[j - gap];
                    } else {
                        break;
                    }
                }
                arr[j] = tmp;
            }
        }
    }

    //核心代码---结束
    public static void main(String[] args) {

        Integer[] arr = {3, 4, 7, 23, 45, 78, 13, 12, 34, 19};
        ShellSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}


