package com.mangmangbang.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * created by zhangjingchuan on 2019/10/21
 */
@Setter
@Getter
@ToString
public class UserBo {

    @NotEmpty(message = "用户名称不可为空")
    @Size(min = 2,max = 20,message = "用户名称长度需要在2-20个字之间")
    private String username;

    @NotEmpty(message = "密码不可为空")
    private String password;


    private String faceImage;


    private String faceImageBig;


    private String nickname;


    private String qrcode;


    private String cid;
}
