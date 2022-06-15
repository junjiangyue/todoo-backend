package org.example.todoo.controller;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.platform.win32.Sspi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.todoo.model.Scheme;
import org.example.todoo.model.Useraccount;
import org.example.todoo.repository.SchemeRepository;
import org.example.todoo.repository.UseraccountRepository;
import org.example.todoo.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Api(tags = "任务接口")
@CrossOrigin
@RestController
@RequestMapping("mission")
public class MissionController {
    @Autowired
    SchemeRepository schemeRepository;
    @Autowired
    SchemeService schemeService;
    @ApiOperation(value = "获取某个用户某日的任务",notes = "提交：用户ID")
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public Object getUserMission(Date req){
        JSONObject jsonObject = new JSONObject();
        List<Scheme> schemeList = schemeService.findBySchemeDate(req);
        System.out.println(schemeList);
        if(schemeList.isEmpty()) {
            jsonObject.put("message", "您查找的用户信息不存在，查找失败!");
            jsonObject.put("status", -1);
            return jsonObject;
        }
        return schemeList;
    }

    @ApiOperation(value = "获取某个任务的信息",notes = "提交：任务ID")
    @RequestMapping(value = "getMission",method = RequestMethod.GET)
    public Object getMission(Long req){
        JSONObject jsonObject = new JSONObject();
        Scheme scheme;
        Optional<Scheme> targetUser = schemeRepository.findById(req);
        if(targetUser.isEmpty()){
            jsonObject.put("message", "您查找的用户信息不存在，查找失败!");
            jsonObject.put("status", -1);
            return jsonObject;
        }
        else {
            scheme = targetUser.get();
        }
        return scheme;
    }
//    @ApiOperation(value = "获取所有任务，group by标签",notes = "提交：任务ID")
//    @RequestMapping(value = "getAllMission",method = RequestMethod.GET)
//    public Object getAllMission(Long req){
//        JSONObject jsonObject = new JSONObject();
//        Scheme scheme;
//        Optional<Scheme> targetUser = schemeRepository.findById(req);
//        if(targetUser.isEmpty()){
//            jsonObject.put("message", "您查找的用户信息不存在，查找失败!");
//            jsonObject.put("status", -1);
//            return jsonObject;
//        }
//        else {
//            scheme = targetUser.get();
//        }
//        return scheme;
//    }

    @ApiOperation(value = "完成任务",notes = "提交：任务ID")
    @RequestMapping(value = "doneMission",method = RequestMethod.GET)
    public Object doneMission(String state,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.getMissionDone(state,missionID);
            jsonObject.put("message", "修改状态成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "删除任务",notes = "提交：任务ID")
    @RequestMapping(value = "deleteMission",method = RequestMethod.GET)
    public Object deleteMission(int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.deleteMission(missionID);
            jsonObject.put("message", "任务删除成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务时间",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionTime",method = RequestMethod.GET)
    public Object changeMissionTime(@RequestParam(value ="scheme_start_time",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime scheme_start_time,
                                    @RequestParam(value ="scheme_end_time",required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime scheme_end_time,
                                    Date scheme_date,
                                    int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionTime(scheme_start_time,scheme_end_time,scheme_date,missionID);
            jsonObject.put("message", "任务时间修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务标题",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionTitle",method = RequestMethod.GET)
    public Object changeMissionTitle(String title,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionTitle(title,missionID);
            jsonObject.put("message", "任务标题修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务描述",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionDes",method = RequestMethod.GET)
    public Object changeMissionDes(String des,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionDescription(des,missionID);
            jsonObject.put("message", "任务描述修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务优先级",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionPriority",method = RequestMethod.GET)
    public Object changeMissionPriority(String priority,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionPriority(priority,missionID);
            jsonObject.put("message", "任务优先级修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务优先级",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionRep",method = RequestMethod.GET)
    public Object changeMissionRep(int rep,String repScope,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionRepetition(rep,repScope,missionID);
            jsonObject.put("message", "任务优先级修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "修改任务标签",notes = "提交：任务ID")
    @RequestMapping(value = "changeMissionTag",method = RequestMethod.GET)
    public Object changeMissionTag(String tag,int missionID){
        JSONObject jsonObject = new JSONObject();
        try{
            schemeService.changeMissionTag(tag,missionID);
            jsonObject.put("message", "任务标签修改成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    @ApiOperation(value = "添加任务",notes = "提交：scheme_title\n" +
            "scheme_description\n" +
            "scheme_start_time\n" +
            "scheme_end_time\n" +
            "scheme_date\n" +
            "priority\n" +
            "state\n" +
            "tag_name\n" +
            "repetition\n" +
            "repetition_scope\n" +
            "user_id")
    @PostMapping("addMission")
    public Object addMission(@RequestParam("scheme_title") String scheme_title,
                             @RequestParam(value ="scheme_description",required = false) String scheme_description,
                             @RequestParam(value ="scheme_start_time",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime scheme_start_time,
                             @RequestParam(value ="scheme_end_time",required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime scheme_end_time,
                             @RequestParam(value ="scheme_date",required = false) Date scheme_date,
                             @RequestParam(value ="priority",required = false) String priority,
                             @RequestParam(value ="state",required = false) String state,
                             @RequestParam(value ="tag_name",required = false) String tag_name,
                             @RequestParam(value ="repetition",required = false) int repetition,
                             @RequestParam(value ="repetition_scope",required = false) String repetition_scope,
                             @RequestParam("user_id")int user_id
                             ){
        JSONObject jsonObject = new JSONObject();

        try{
            schemeService.insertMission(scheme_title, scheme_description, scheme_start_time, scheme_end_time, scheme_date, priority,
                    state, tag_name, repetition, repetition_scope,user_id);
            jsonObject.put("message", "插入成功!");
        }catch (Exception e) {
            System.out.println(e);
            jsonObject.put("message", "数据库错误!");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }



}
