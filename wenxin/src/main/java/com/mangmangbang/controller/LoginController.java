package com.mangmangbang.controller;

import com.mangmangbang.bo.UserBo;
import com.mangmangbang.pojo.Users;
import com.mangmangbang.service.UserServiceImpl;
import com.mangmangbang.vo.UsersVo;
import com.mangmangbang.vo.YouxueResult;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * created by zhangjingchuan on 2019/10/21
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserServiceImpl userService;

    @PostMapping("/registerOrLogin")
    public YouxueResult registerOrLogin(@Valid @RequestBody UserBo userBo, BindingResult error) {
        try {

            //1.验证数据是否完整
            if (error.hasErrors()) {
                return YouxueResult.build(YouxueResult.ERROR, error.getFieldError().getDefaultMessage());
            }

            String username = userBo.getUsername();
            String password = userBo.getPassword();

            //2.判断用户是否存在，存在就登陆，不存在注册
            boolean usernameIsExist = this.userService.queryUsernameIsExist(username);

            Users userResult = null;
            if (usernameIsExist) {
                Users user = new Users();
                //注册
                user.setUsername(userBo.getUsername());
                user.setNickname(userBo.getUsername());
                user.setFaceImage("");
                user.setFaceImageBig("");
                user.setQrcode("");
                user.setCid(userBo.getCid());
                //MD5加密
                String md5Password = DigestUtils.md5Hex(userBo.getPassword());
                user.setPassword(md5Password);

                userResult = this.userService.saveUser(user);
            } else {
                //登陆
                userResult = this.userService.queryUserForLogin(username, password);
                if (userResult == null) {
                    return YouxueResult.build(YouxueResult.ERROR, "用户名或密码不正确");
                }
            }

            UsersVo userVo= new UsersVo();
            BeanUtils.copyProperties(userResult,userVo);
            return YouxueResult.ok(userVo);
        }catch (Exception ex){
            ex.printStackTrace();
            return YouxueResult.build(YouxueResult.ERROR,"系统异常");
        }
    }
}
