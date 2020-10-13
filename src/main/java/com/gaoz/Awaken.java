package com.gaoz;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.DateTime;


public class Awaken implements Runnable{


    private static SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat ss = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    private static SimpleDateFormat s_min = new SimpleDateFormat("HH:mm");

    private static String beginTime = "00:00";
    private static String endTime = "00:30";

    private static String log = "今天已经填报了";

    private Date last_submit = new Date("2020/10/01")  ;


    @Override
    public void run(){
        New_spider new_spider = new New_spider();
        R_sipder r_sipder = new R_sipder();
        while(true){
//            CurrTime c = new CurrTime();
//            Date now_day = c.now_day;
            Date currtime = new Date();

            boolean flag = sameDate(currtime , last_submit);
            if(!flag){
                System.out.println("submit_day: "+ last_submit);
                System.out.println("now_day:" + currtime);
                last_submit = currtime;
                System.out.println("submit_day_update:" + last_submit);
                //执行打卡
                System.out.println("执行打卡！");
                r_sipder.daka();
                new_spider.daka();

                if(new_spider.signal.equals(log)){
                    System.out.println("打卡成功！"+"当前时间："+ss.format(new Date()));
                }
            }else {
                if(new_spider.signal.equals(log)){
                    System.out.println("今日已打卡！ "+"当前时间："+ss.format(new Date()));
                }else{
                    System.out.println("尝试再次打卡....");
                    r_sipder.daka();
                    new_spider.daka();
                }
            }
            try {
                //判断当前时间
                String nowTime = s_min.format(new Date());
                boolean f = hourMinuteBetween(nowTime ,beginTime , endTime);
                if(f){
                    //间隔时间1*60*3秒，3分钟判断一次打卡。
                    Thread.sleep(1000*60*3);
                    String newTime = s_min.format(new Date());
                    System.out.println("已休眠3分钟，"+"当前时间："+newTime);
                }else{
                    //间隔时间1*60*30秒，30分钟判断一次打卡。
                    Thread.sleep(1000*60*30);
                    String newTime = s_min.format(new Date());
                    System.out.println("已休眠半小时，"+"当前时间："+newTime);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
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



    public static boolean hourMinuteBetween(String nowDate, String startDate, String endDate) throws Exception{



        Date now = s_min.parse(nowDate);
        Date start = s_min.parse(startDate);
        Date end = s_min.parse(endDate);

        long nowTime = now.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();

        return nowTime >= startTime && nowTime <= endTime;
    }



    public static void main(String[] args){


        Awaken myawaken = new Awaken();
        Thread thread = new Thread(myawaken,"今日打卡");
        thread.start();

    }
}
