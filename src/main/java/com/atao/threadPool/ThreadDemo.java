package com.atao.threadPool;

/**
 * @Description
 * @Author atao
 * @Date 2022/11/14
 */
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {

        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name);
    }

    public static void main(String[] args) {
        new ThreadDemo("atao").run();
        new ThreadDemo("atao").start();
    }

}
