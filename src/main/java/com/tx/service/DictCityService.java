package com.tx.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tx.model.DictCity;
import com.tx.repository.DictCityRepository;
import com.tx.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DictCityService {
    private static final Logger log = LoggerFactory.getLogger(DictCityService.class);

    @Autowired
    private DictCityRepository dictCityRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public List<DictCity> getCitys(int parentId){
        return dictCityRepository.findByParentId(parentId);
    }


    @Async
    public void init(long id){
        log.info("asyncSimplest");
        String url="https://api.it120.cc/common/region/child?pid=" + id;
        try{
            String str = HttpUtil.sendGetData(url);
            Result result =  mapper.readValue(str, Result.class);
            if(result.code == 0 ){
                List<DictCity> citys = new ArrayList<>();
                for(DictCity city : result.data) {
                    citys.add(city);
                    init(city.getId());
                }
                dictCityRepository.saveAll(citys);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
class Result{
    int code;
    DictCity[] data;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DictCity[] getData() {
        return data;
    }

    public void setData(DictCity[] data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

}