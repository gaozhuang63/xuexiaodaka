package com.gaoz;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * @author : gaozhuang
 * @date :
 */
public class New_spider implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3)
                                  .setSleepTime(100)
                                   .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                                  .addHeader("Connection", "keep-alive")
                                  .addHeader("Cookie", "eai-sess=mkhdsmktrig36fn46ovq8kkfi4; UUkey=611743f767e7528a36c88e806ba0ab7a; Hm_lvt_48b682d4885d22a90111e46b972e3268=1601445306; Hm_lpvt_48b682d4885d22a90111e46b972e3268=1601449101")
                                  .addHeader("Host","itsapp.bjut.edu.cn")
                                    .addHeader("Sec-Fetch-Dest"," document")
                                .addHeader("Sec-Fetch-Mode", "navigate")
                                .addHeader("Sec-Fetch-Site"," same-origin")
            .addHeader("Sec-Fetch-User", "?1")
            .setUserAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Mobile Safari/537.36")



            ;


    private static int count =0;


    public Site getSite() {
        return site;
    }

    public void process(Page page) {




        System.out.println(page.getHtml());

    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();

        Spider spi = new Spider(new New_spider());
        spi.addUrl("https://itsapp.bjut.edu.cn/ncov/wap/default/index").thread(1).run();

//        spi.test("https://itsapp.bjut.edu.cn/ncov/wap/default/index");

        //endTime = System.currentTimeMillis();
        //System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
    }





}
