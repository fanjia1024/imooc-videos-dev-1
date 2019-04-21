package com.imooc.controller;

import com.alibaba.fastjson.JSONObject;
import com.imooc.config.WechatAccountConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author smileyan
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WeChatLoginController {
    @Autowired
    private WxMpService wxMpService;


//    private String appid="wxce796590a9f0863a";
//
//    private String appsecret="e6322939783531c9ba49388a1c418a6c";

    private String openid;
    private String session_key;

    @GetMapping("/index")
    public String login(String code) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+wxMpService.getWxMpConfigStorage().getAppId()+"&secret="+wxMpService.getWxMpConfigStorage().getSecret()+"&js_code="+code+"&grant_type=authorization_code";
//        String url1="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appsecret+"&js_code="+code+"&grant_type=authorization_code";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            log.info(wxMpService.getWxMpConfigStorage().getAppId()+":"+wxMpService.getWxMpConfigStorage().getSecret()+":"+code);

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        session_key = jsonObject.get("session_key")+"";
        openid = jsonObject.get("openid")+"";

        System.out.println("session_key=="+session_key);
        System.out.println("openid=="+openid);
        return resultString;
    }

}

