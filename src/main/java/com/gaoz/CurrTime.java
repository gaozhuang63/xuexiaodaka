package com.gaoz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CurrTime implements Runnable {
    //通过正则式来设置输出的时间格式
    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
    public Date now_day = new Date();
    String now_str = s.format(now_day);


    public Date getNow_day(){
        return now_day;
    }

    @Override
    public void run(){

        while(true) {
            SimpleDateFormat ss = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
            System.out.println(ss.format(new Date()));
            try {
                //间隔时间1*60*5秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


//    public static void main(String[] args)throws InterruptedException, ExecutionException {
//        CurrTime runnable = new CurrTime();
//        Thread myThread = new Thread(runnable,"当前时间");
//
////        System.out.println(new CurrTime().getNow_str());
//
//
//
//        myThread.start();
////        System.out.println(futureTask.get());
//
//
//
//
//    }



}
