package com.gaoz;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.minidev.json.JSONUtil;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;


import javax.swing.text.Document;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : gaozhuang
 * @date :
 */
public class New_spider implements PageProcessor {
    public static String signal ;
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3)
                                  .setSleepTime(100)
                                   .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                                    .addHeader("Accept","application/json, text/javascript, */*; q=0.01")
//            .addHeader("Content-Length","2814")
            .addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Origin", "https://itsapp.bjut.edu.cn")
            .addHeader("Referer", "https://itsapp.bjut.edu.cn/ncov/wap/default/index")
                                  .addHeader("Connection", "keep-alive")
                                  .addCookie("Hm_lvt_48b682d4885d22a90111e46b972e3268","1601481951")
                                  .addCookie("UUkey","a57275025c2874ab0e3deb06701b8271")
                                  .addCookie("eai-sess","oar4ahmoaflrciv0rntlmq80v4")
                                  .addCookie("Hm_lpvt_48b682d4885d22a90111e46b972e3268","1601481951")
                                  .addCookie("LAST_PORTAL_PAGE","p323")
//            .addHeader("Cookie","LAST_PORTAL_PAGE=p323; eai-sess=oar4ahmoaflrciv0rntlmq80v4; UUkey=a57275025c2874ab0e3deb06701b8271; Hm_lvt_48b682d4885d22a90111e46b972e3268=1601481951,1601572583; Hm_lpvt_48b682d4885d22a90111e46b972e3268=1601575609")
                                  .addHeader("Host","itsapp.bjut.edu.cn")
                                    .addHeader("Sec-Fetch-Dest","empty")
                                .addHeader("Sec-Fetch-Mode", "cors")
                                .addHeader("Sec-Fetch-Site","same-origin")
            .addHeader("Referer", "https://itsapp.bjut.edu.cn/ncov/wap/default/index")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36")
            .addHeader("X-Requested-With","XMLHttpRequest")

            ;


    private static int count =0;
    private Page page;


    public Site getSite() {
        return site;
    }

    public void process(Page page) {

        String s = page.getHtml().xpath("//body/text()").toString();
        JSONObject json_test = JSONObject.parseObject(s);
        signal = json_test.get("m").toString();


//        System.out.println(page.getHtml().xpath("//body/text()").toString());
//        System.out.println(json_test.get("m"));

    }


    private static Map<String,Object> GetMap(){

        Map<String,Object> params=new HashMap<String,Object>();

        //表单提交的信息学生的姓名
        params.put("ismoved","0");
        params.put("jhfjrq","");
        params.put("jhfjjtgj","");
        params.put("jhfjhbcc","");
        params.put("tw","2");
        params.put("sfcxtz", "0");
        params.put("sfjcbh", "0");
        params.put("sfcxzysx","0");
        params.put("qksm","");
        params.put("sfyyjc", "0");
        params.put("jcjgqr", "0");
        params.put("remark", "");

//        params.put("address","%E5%8C%97%E4%BA%AC%E5%B8%82%E9%97%A8%E5%A4%B4%E6%B2%9F%E5%8C%BA%E5%A4%A7%E5%B3%AA%E8%A1%97%E9%81%93%E9%BE%99%E5%B1%B1%E5%AE%B6%E5%9B%AD5%E5%8F%B7%E9%99%A2%E9%BE%99%E5%B1%B1%E5%AE%B6%E5%9B%AD5%E5%8C%BA");
//        params.put("geo_api_info", "%7B%22type%22%3A%22complete%22%2C%22info%22%3A%22SUCCESS%22%2C%22status%22%3A1%2C%22YDa%22%3A%22jsonp_212958_%22%2C%22position%22%3A%7B%22Q%22%3A39.93496%2C%22R%22%3A116.09919000000002%2C%22lng%22%3A116.09919%2C%22lat%22%3A39.93496%7D%2C%22message%22%3A%22Get+ipLocation+success.Get+address+success.%22%2C%22location_type%22%3A%22ip%22%2C%22accuracy%22%3Anull%2C%22isConverted%22%3Atrue%2C%22addressComponent%22%3A%7B%22citycode%22%3A%22010%22%2C%22adcode%22%3A%22110109%22%2C%22businessAreas%22%3A%5B%7B%22name%22%3A%22%E9%97%A8%E5%A4%B4%E6%B2%9F%22%2C%22id%22%3A%22110109%22%2C%22location%22%3A%7B%22Q%22%3A39.93223%2C%22R%22%3A116.10112900000001%2C%22lng%22%3A116.101129%2C%22lat%22%3A39.93223%7D%7D%2C%7B%22name%22%3A%22%E5%A4%A7%E5%B3%AA%E6%9D%91%22%2C%22id%22%3A%22110109%22%2C%22location%22%3A%7B%22Q%22%3A39.935205%2C%22R%22%3A116.105143%2C%22lng%22%3A116.105143%2C%22lat%22%3A39.935205%7D%7D%2C%7B%22name%22%3A%22%E9%BE%99%E6%B3%89%22%2C%22id%22%3A%22110109%22%2C%22location%22%3A%7B%22Q%22%3A39.952384%2C%22R%22%3A116.090127%2C%22lng%22%3A116.090127%2C%22lat%22%3A39.952384%7D%7D%5D%2C%22neighborhoodType%22%3A%22%22%2C%22neighborhood%22%3A%22%22%2C%22building%22%3A%22%22%2C%22buildingType%22%3A%22%22%2C%22street%22%3A%22%E5%A4%A7%E5%B3%AA%E5%8D%97%E8%B7%AF%22%2C%22streetNumber%22%3A%2221%E5%8F%B7%E6%A5%BC%22%2C%22country%22%3A%22%E4%B8%AD%E5%9B%BD%22%2C%22province%22%3A%22%E5%8C%97%E4%BA%AC%E5%B8%82%22%2C%22city%22%3A%22%22%2C%22district%22%3A%22%E9%97%A8%E5%A4%B4%E6%B2%9F%E5%8C%BA%22%2C%22township%22%3A%22%E5%A4%A7%E5%B3%AA%E8%A1%97%E9%81%93%22%7D%2C%22formattedAddress%22%3A%22%E5%8C%97%E4%BA%AC%E5%B8%82%E9%97%A8%E5%A4%B4%E6%B2%9F%E5%8C%BA%E5%A4%A7%E5%B3%AA%E8%A1%97%E9%81%93%E9%BE%99%E5%B1%B1%E5%AE%B6%E5%9B%AD5%E5%8F%B7%E9%99%A2%E9%BE%99%E5%B1%B1%E5%AE%B6%E5%9B%AD5%E5%8C%BA%22%2C%22roads%22%3A%5B%5D%2C%22crosses%22%3A%5B%5D%2C%22pois%22%3A%5B%5D%7D");
//        params.put("area", "%E5%8C%97%E4%BA%AC%E5%B8%82++%E9%97%A8%E5%A4%B4%E6%B2%9F%E5%8C%BA");
//        params.put("province", "%E5%8C%97%E4%BA%AC%E5%B8%82");
//        params.put("city","%E5%8C%97%E4%BA%AC%E5%B8%82");

        params.put("geo_api_info","{\"type\":\"complete\",\"info\":\"SUCCESS\",\"status\":1,\"YDa\":\"jsonp_212958_\",\"position\":{\"Q\":39.93496,\"R\":116.09919000000002,\"lng\":116.09919,\"lat\":39.93496},\"message\":\"Get ipLocation success.Get address success.\",\"location_type\":\"ip\",\"accuracy\":null,\"isConverted\":true,\"addressComponent\":{\"citycode\":\"010\",\"adcode\":\"110109\",\"businessAreas\":[{\"name\":\"门头沟\",\"id\":\"110109\",\"location\":{\"Q\":39.93223,\"R\":116.10112900000001,\"lng\":116.101129,\"lat\":39.93223}},{\"name\":\"大峪村\",\"id\":\"110109\",\"location\":{\"Q\":39.935205,\"R\":116.105143,\"lng\":116.105143,\"lat\":39.935205}},{\"name\":\"龙泉\",\"id\":\"110109\",\"location\":{\"Q\":39.952384,\"R\":116.090127,\"lng\":116.090127,\"lat\":39.952384}}],\"neighborhoodType\":\"\",\"neighborhood\":\"\",\"building\":\"\",\"buildingType\":\"\",\"street\":\"大峪南路\",\"streetNumber\":\"21号楼\",\"country\":\"中国\",\"province\":\"北京市\",\"city\":\"\",\"district\":\"门头沟区\",\"township\":\"大峪街道\"},\"formattedAddress\":\"北京市门头沟区大峪街道龙山家园5号院龙山家园5区\",\"roads\":[],\"crosses\":[],\"pois\":[]}");
        params.put("area", "北京市  门头沟区");
        params.put("address","北京市门头沟区大峪街道龙山家园5号院龙山家园5区");
        params.put("province","北京市");
        params.put("city","北京市");

        params.put("sfzx", "1");
        params.put("sfjcwhry", "0");
        params.put("sfjchbry","0");
        params.put("sfcyglq", "0");
        params.put("gllx", "");
        params.put("glksrq", "");
        params.put("jcbhlx", "");
        params.put("jcbhrq", "");
        params.put("bztcyy", "");
        params.put("sftjhb", "0");
        params.put("sftjwh", "0");
        params.put("sfsfbh", "0");
        params.put("xjzd", "");
        params.put("jcwhryfs", "");
        params.put("jchbryfs", "");
        params.put("szgj", "");
        params.put("dqjzzt", "0");
        params.put("ljrq", "");
        params.put("ljjtgj", "");
        params.put("ljhbcc", "");
        params.put("fjrq", "");
        params.put("fjjtgj", "");
        params.put("fjhbcc", "");
        params.put("fjqszgj", "");
        params.put("fjq_province", "");
        params.put("fjq_city", "");
        params.put("fjq_szdz", "");
        params.put("jrfjjtgj", "");
        params.put("jrfjhbcc", "");
        params.put("fjyy", "");
        params.put("szsqsfty", "");
        params.put("sfxxxbb", "");
        params.put("jcjg", "");

        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        Date start = c.getTime();
        String qyt= format.format(start);//前一天
//        System.out.println(qyt);

        params.put("date", qyt);
        params.put("uid", "73236");
        params.put("created","1601435100");
        params.put("jcqzrq", "");
        params.put("sfjcqz", "");
        params.put("szsqsfybl", "0");
        params.put("sfsqhzjkk", "");
        params.put("sqhzjkkys", "");
        params.put("sfygtjzzfj", "0");
        params.put("gtjzzfjsj", "");
        params.put("fxyy", "%E8%BF%94%E6%A0%A1");
        params.put("id", "4145133");
        params.put("gwszdd", "");
        params.put("sfyqjzgc", "");
        params.put("jrsfqzys", "");
        params.put("jrsfqzfy", "");


//        String jsonString = JSONObject.toJSONString(params);

        return params;

    }




    public void daka(){
        System.out.println("开始打卡...");
        //模拟post方式表单提交
        String postUrl="https://itsapp.bjut.edu.cn/ncov/wap/default/save";
        Request request = new Request(postUrl);
        request.setMethod(HttpConstant.Method.POST);

        Map<String , Object> params = new HashMap<>();
        params = GetMap();

        request.setRequestBody(HttpRequestBody.form(params,"utf-8"));

        Spider.create(new New_spider())
                .addRequest(request)
                //开启1个线程抓取
                .thread(1)
                //启动爬虫
                .run();






    }

//
//    public static void main(String[] args) {
//
//        System.out.println("开始打卡...");
//        New_spider spider = new New_spider();
//        spider.daka();
//        System.out.println("打卡成功！");
//
//
//    }
}
