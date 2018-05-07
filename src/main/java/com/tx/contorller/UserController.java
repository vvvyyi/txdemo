package com.tx.contorller;

import com.tx.service.result.LoginResult;
import com.tx.service.result.Result;
import com.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by cf on 2018/5/2.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/wxapp/login")
    public Result<LoginResult> userLogin(@RequestParam String code, HttpSession session) {
        LoginResult result = userService.getUserLogin(code);
        session.setAttribute(code, result);
        return Result.success(result);
    }
}
