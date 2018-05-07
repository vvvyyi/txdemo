package com.tx.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tx.model.User;
import com.tx.repository.UserRepository;
import com.tx.service.result.LoginResult;
import com.tx.service.result.Result;
import com.tx.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by cf on 2018/5/2.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    ObjectMapper mapper = new ObjectMapper();

    String appId="wx65f1e00de6830302";
    String appSecret = "11eb9ce9ae299a8de5cbc410a2ad11d6";
    String wxApiUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx65f1e00de6830302&secret=11eb9ce9ae299a8de5cbc410a2ad11d6&js_code=%s&grant_type=authorization_code";
    @Transactional
    public LoginResult getUserLogin(String authCode){
        String requestUrl = String.format(wxApiUrl,authCode);
        try {
            String resp = HttpUtil.sendGetData(requestUrl);
            Map map = mapper.readValue(resp, Map.class);
            Object openid =  map.get("openid");
            if(null != openid){
                User user = userRepository.findByOpenid(openid.toString());
                if(user == null) {
                    user = new User(openid.toString());
                    userRepository.save(user);
                }
                LoginResult result = new LoginResult( map.get("session_key").toString(),  map.get("openid").toString());
                return result;
            }
            System.out.println(resp);
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new UserService(). getUserLogin("021zkqy90LAGHv1sMbz90yzny90zkqyj");
    }
}

