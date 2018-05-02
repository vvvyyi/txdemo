package com.tx.service;

import com.tx.util.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * Created by cf on 2018/5/2.
 */
@Service
public class UserService {
    String appId="wx65f1e00de6830302";

    String appSecret = "11eb9ce9ae299a8de5cbc410a2ad11d6";
    String wxApiUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx65f1e00de6830302&secret=11eb9ce9ae299a8de5cbc410a2ad11d6&js_code=%s&grant_type=authorization_code";
    public void getUserLogin(String authCode){
        String requestUrl = String.format(wxApiUrl,authCode);
        try {
            String resp = HttpUtil.sendGetData(requestUrl);
            System.out.println(resp);
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        new UserService().getUserLogin("021L5gcH0xLoNh2FyyaH0eeWbH0L5gck");
    }
}
