package org.example.todoo.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.todoo.model.Useraccount;
import org.example.todoo.repository.UseraccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Api(tags = "用户接口")
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UseraccountRepository useraccountRepository;


    @ApiOperation(value = "获取某个用户的信息",notes = "提交：用户ID")
    @RequestMapping(value = "show",method = RequestMethod.GET)
    public Object show(Long req){
        JSONObject jsonObject = new JSONObject();
        Useraccount useraccount;
        Optional<Useraccount> targetUser = useraccountRepository.findById(req);
        if(targetUser.isEmpty()){
            jsonObject.put("message", "您查找的用户信息不存在，查找失败!");
            jsonObject.put("status", -1);
            return jsonObject;
        }
        else {
            useraccount = targetUser.get();
        }
        return useraccount;
    }

}
