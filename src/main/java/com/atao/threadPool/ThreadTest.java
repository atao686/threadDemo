package com.atao.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author atao
 * @Date 2022/11/14
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("大小：" + list.size());
    }
}
