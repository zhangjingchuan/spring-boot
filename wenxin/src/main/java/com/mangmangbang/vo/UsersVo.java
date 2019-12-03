package com.mangmangbang.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;


@Data
@ToString
public class UsersVo {


    private String username;


    private String faceImage;


    private String faceImageBig;


    private String nickname;



}