package com.gaoz;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.DateTime;


public class Awaken implements Runnable{


    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");

    Date last_submit = new Date("2020/10/01")  ;
    private static String log = "今天已经填报了";

    @Override
    public void run(){
        New_spider new_spider = new New_spider();
        while(true){
            CurrTime c = new CurrTime();
            Date now_day = c.now_day;
            boolean flag = sameDate(now_day , last_submit);
            if(!flag){
                System.out.println("submit_day: "+ last_submit);
                System.out.println("now_day:" + now_day);
                last_submit = now_day;

                System.out.println("submit_day_update:" + last_submit);
                //执行打卡
                System.out.println("执行打卡！");
                new_spider.daka();
                if(new_spider.signal.equals(log)){
                    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    System.out.println("打卡成功！"+"当前时间："+s.format(new Date()));
                }

            }else {
                if(new_spider.signal.equals(log)){
                    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

                    System.out.println("今日已打卡！ "+"当前时间："+s.format(new Date()));
                }else{
                    System.out.println("尝试再次打卡....");
                    new_spider.daka();
                }
            }
            try {
                //间隔时间1*60*5秒
                Thread.sleep(1000*60*5);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Boolean sameDate(Date dt1 , Date dt2 )
    {
        LocalDate ld1 = new LocalDate(new DateTime(dt1));
        LocalDate ld2 = new LocalDate(new DateTime(dt2));
        return ld1.equals( ld2 );
    }

    public static void main(String[] args){
        Awaken myawaken = new Awaken();
        Thread thread = new Thread(myawaken,"今日打卡");
        thread.start();


    }





}
