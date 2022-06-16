package org.example.todoo.mapper;

import cn.hutool.core.date.DateTime;
import java.sql.Timestamp;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.*;
import org.example.todoo.model.Scheme;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Mapper
@Repository
public interface SchemeMapper {
    @Select("SELECT * FROM scheme WHERE scheme_start_time < CAST(#{today} AS DATETIME) " +
            "AND scheme_end_time >CAST(#{today} AS DATETIME) OR scheme_date = CAST(#{today} AS DATETIME)")
    List<Scheme> findBySchemeDate(@Param("today") Date req);

    @Select("SELECT * FROM scheme WHERE scheme_end_time < CAST(#{today} AS DATETIME) OR scheme_date < CAST(#{today} AS DATETIME) AND state = '0'")
    List<Scheme> findUndo(@Param("today") Date req);

    @Select("SELECT * FROM scheme WHERE scheme_start_time > CAST(#{today} AS DATETIME) OR scheme_date > CAST(#{today} AS DATETIME)")
    List<Scheme> findFuture(@Param("today") Date req);

    @Select("SELECT * FROM scheme WHERE scheme_start_time < CAST(#{today} AS DATETIME) " +
            "AND repetition >0 ")
    List<Scheme> findBySchemeRep(@Param("today") Date req);

    @Insert("insert into scheme(scheme_title,scheme_description,scheme_start_time,scheme_end_time," +
            "scheme_date,priority,state,tag_name,repetition,repetition_scope,user_id) " +
            "values (#{scheme_title},#{scheme_description},#{scheme_start_time},#{scheme_end_time},#{scheme_date},#{priority},#{state},#{tag_name}," +
            "#{repetition},#{repetition_scope},#{user_id})")
    int insertScheme(@Param("scheme_title") String scheme_title,
                     @Param("scheme_description") String scheme_description,
                     @Param("scheme_start_time") DateTime scheme_start_time,
                     @Param("scheme_end_time") DateTime scheme_end_time,
                     @Param("scheme_date") Date scheme_date,
                     @Param("priority") String priority,
                     @Param("state") String state,
                     @Param("tag_name") String tag_name,
                     @Param("repetition") int repetition,
                     @Param("repetition_scope") String repetition_scope,
                     @Param("user_id") int user_id
                     );

    @Update("update scheme set state=#{state} where scheme_id=#{id}")
    Integer doneMission(@Param("state") String state, @Param("id") Integer scheme_id);

    @Update("update scheme set scheme_start_time=#{scheme_start_time},scheme_end_time=#{scheme_end_time},scheme_date=#{scheme_date} where scheme_id=#{id}")
    Integer changeMissionTime(@Param("scheme_start_time") DateTime scheme_start_time,@Param("scheme_end_time") DateTime scheme_end_time,@Param("scheme_date") Date scheme_date, @Param("id") Integer scheme_id);

    @Update("update scheme set scheme_title=#{scheme_title} where scheme_id=#{id}")
    Integer changeMissionTitle(@Param("scheme_title") String scheme_title, @Param("id") Integer scheme_id);

    @Update("update scheme set scheme_description=#{scheme_description} where scheme_id=#{id}")
    Integer changeMissionDescription(@Param("scheme_description") String scheme_description, @Param("id") Integer scheme_id);

    @Update("update scheme set priority=#{priority} where scheme_id=#{id}")
    Integer changeMissionPriority(@Param("priority") String priority, @Param("id") Integer scheme_id);

    @Update("update scheme set tag_name=#{tag_name} where scheme_id=#{id}")
    Integer changeMissionTag(@Param("tag_name") String tag_name, @Param("id") Integer scheme_id);

    @Update("update scheme set repetition=#{repetition},repetition_scope=#{repetition_scope} where scheme_id=#{id}")
    Integer changeMissionRepetition(@Param("repetition") int repetition,@Param("repetition_scope") String repetition_scope, @Param("id") Integer scheme_id);

    @Delete("delete from scheme where scheme_id=#{id}")
    int deleteMission(@Param("id") Integer scheme_id);


}
