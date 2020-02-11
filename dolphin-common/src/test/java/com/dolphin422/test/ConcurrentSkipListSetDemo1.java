package com.dolphin422.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2019/12/24 15:44
 */
public class ConcurrentSkipListSetDemo1 {
    // TODO: set是TreeSet对象时，程序会出错。
    //private static Set<String> set = new TreeSet<String>();
    private static final Set<String> set = new ConcurrentSkipListSet<String>();
    public static void main(String[] args) {

        // 同时启动两个线程对set进行操作！
       // new MyThread("a").start();
       // new MyThread("b").start();
        String a = "a";
        String b = "a";
        boolean add = set.add(a);
        boolean add1 = set.add(a);
        boolean add2 = set.add(b);
        System.out.print("------");


    }

    private static void printAll() {
        String value = null;
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                // “线程名” + "序号"
                String val = Thread.currentThread().getName() + (i%6);
                set.add(val);
                // 通过“Iterator”遍历set。
                printAll();
            }
        }
    }
}
