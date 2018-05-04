package com.tx.service;

import com.tx.model.User;
import com.tx.repository.UserRepository;
import com.tx.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cf on 2018/5/2.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void addUser(User user){
        userRepository.save(user);
    }


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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(7);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer i : list) {
            System.out.print(i);
        }
    }
}
