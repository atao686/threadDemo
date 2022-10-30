package com.atao.thread.bug;

import com.atao.thread.factory.UnsafeFactory;

/**
 * @Description
 * @Author atao
 */
public class VisibilityTest {

    // storeLoad  JVM内存屏障  ---->  (汇编层面指令)  lock; addl $0,0(%%rsp)
    // lock前缀指令不是内存屏障的指令，但是有内存屏障的效果   缓存失效
    private boolean flag = true;
    private int count = 0;

    public void refresh() {
        // threadB对flag的写操作会 happens-before threadA对flag的读操作
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag");
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        int i = 0;
        while (flag) {
            i++;
            //TODO  业务逻辑

//            UnsafeFactory.getUnsafe().storeFence();
//            Thread.yield();
//            System.out.println(count);
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环: i=" + i);
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest test = new VisibilityTest();

        // 线程threadA模拟数据加载场景
        Thread threadA = new Thread(() -> test.load(), "threadA");
        threadA.start();

        // 让threadA执行一会儿
        Thread.sleep(1000);
        // 线程threadB通过flag控制threadA的执行时间
        Thread threadB = new Thread(() -> test.refresh(), "threadB");
        threadB.start();

    }


    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }

}
