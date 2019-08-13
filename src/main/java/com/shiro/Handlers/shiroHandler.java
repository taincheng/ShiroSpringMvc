package com.shiro.Handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Author TianCheng
 * @Date 2019/8/13 23:02
 */
@Controller
@RequestMapping("/shiro")
public class shiroHandler {

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){
        Subject currentUser = SecurityUtils.getSubject();

        if(!currentUser.isAuthenticated()){
            //把用户名和密码封装在Token中
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            //记住该用户
            token.setRememberMe(true);

            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                System.out.println("load false : " + e.getMessage());
            }
        }
        return "redirect:/list.jsp";
    }

}
