package org.example.todoo.service;


import cn.hutool.core.date.DateTime;
import com.sun.jna.platform.win32.Sspi;
import org.apache.ibatis.annotations.Param;
import org.example.todoo.mapper.SchemeMapper;
import org.example.todoo.model.Scheme;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SchemeService {
    @Resource
    SchemeMapper schemeMapper;

    public List<Scheme> findBySchemeDate(Date today){
        List<Scheme> todayMission = schemeMapper.findBySchemeDate(today);
        return todayMission;
    }

    public int insertMission(String scheme_title,
                             String scheme_description,
                             DateTime scheme_start_time,
                             DateTime scheme_end_time,
                             Date scheme_date,
                             String priority,
                             String state,
                             String tag_name,
                             int repetition,
                             String repetition_scope,
                            int user_id){
        return schemeMapper.insertScheme(scheme_title, scheme_description, scheme_start_time, scheme_end_time, scheme_date, priority,
                state, tag_name, repetition, repetition_scope,user_id);
    }

    public Integer getMissionDone(String state, int missionID){
        return schemeMapper.doneMission(state,missionID);
    }

    public int deleteMission(int missionID){
        return schemeMapper.deleteMission(missionID);
    }

    public int changeMissionPriority(String priority,int missionID){
        return schemeMapper.changeMissionPriority(priority,missionID);
    }

    public int changeMissionDescription(String des,int missionID){
        return schemeMapper.changeMissionDescription(des,missionID);
    }
    public int changeMissionRepetition(int repetition,String repetitionScope, int missionID){
        return schemeMapper.changeMissionRepetition(repetition,repetitionScope,missionID);
    }
    public int changeMissionTag(String tag,int missionID){
        return schemeMapper.changeMissionTag(tag,missionID);
    }
    public int changeMissionTime(DateTime startTime, DateTime endTime, Date date,int missionID){
        return schemeMapper.changeMissionTime(startTime,endTime,date,missionID);
    }
    public int changeMissionTitle(String title,int missionID){
        return schemeMapper.changeMissionTitle(title,missionID);
    }

}
