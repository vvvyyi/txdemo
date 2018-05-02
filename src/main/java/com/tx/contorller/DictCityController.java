package com.tx.contorller;

import com.tx.model.DictCity;
import com.tx.service.DictCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/city")
public class DictCityController {

    @Autowired
    private DictCityService dictCityService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<DictCity> getCitys(@RequestParam(defaultValue = "0") int parentId){
       return dictCityService.getCitys(parentId);
    }

//    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init(){
        dictCityService.init(0);
       return "xx";
    }


}

