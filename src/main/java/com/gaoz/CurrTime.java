package com.gaoz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CurrTime implements Runnable {
    //通过正则式来设置输出的时间格式
    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
    SimpleDateFormat ss = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    SimpleDateFormat sss = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    public Date now_day = new Date();
    String now_str = s.format(now_day);


    public Date getNow_day(){
        return now_day;
    }

    @Override
    public void run(){

        while(true) {

//            System.out.println(ss.format(new Date()));
            try {
                //间隔时间1*60*5秒

                Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String s = format.format(now);

                String b = "13:33:03";
                String e = "13:44:23";
                boolean f = hourMinuteBetween(s ,b , e);
//                System.out.println(hourMinuteBetween(s ,b , e));
                if(f){
                    System.out.println(f+" "+sss.format(now));
                    Thread.sleep(1000*5);
                }else {
                    System.out.println(f+" "+sss.format(now));
                    Thread.sleep(1000*20);
                }




            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
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
    public static void main(String[] args) throws Exception{

        CurrTime runnable = new CurrTime();
        Thread my = new Thread(runnable,"11");
        my.start();
    }





    public static boolean hourMinuteBetween(String nowDate, String startDate, String endDate) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date now = format.parse(nowDate);
        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        long nowTime = now.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();

        return nowTime >= startTime && nowTime <= endTime;
    }



}
