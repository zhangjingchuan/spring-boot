package com.mangmangbang.service;

import com.mangmangbang.dao.UsersMapper;
import com.mangmangbang.pojo.Users;
import com.mangmangbang.pojo.UsersExample;
import com.mangmangbang.vo.YouxueResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by zhangjingchuan on 2019/10/21
 */
@Service
public class UserServiceImpl {

    @Resource
    private UsersMapper usersMapper;

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username){

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<Users> users = usersMapper.selectByExample(example);

        return !(users!=null&&users.size()>0);
    }

    /**
     * 通过用户名密码，返回用户信息
     * @param username
     * @param pwd
     * @return
     */
    public Users queryUserForLogin(String username,String pwd){

        //MD5加密
        String md5Password = DigestUtils.md5Hex(pwd);

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(md5Password);

        List<Users> users = usersMapper.selectByExample(example);

        return (users!=null&&users.size()>0)?users.get(0):null;
    }


    public Users saveUser(Users users){

        String id = Sid.next();
        users.setId(id);


        this.usersMapper.insertSelective(users);

        return users;
    }
}
