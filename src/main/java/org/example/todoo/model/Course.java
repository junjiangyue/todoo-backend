package org.example.todoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;



@Entity
@Table ( name ="courses" )
@Data
public class Course implements Serializable {

    private static final long serialVersionUID =  7377969206920655175L;

    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "building")
    private String Building;
    @Column(name = "room")
    private String room;
    @Column(name = "start_week")
    private int startWeek;

    @Column(name = "end_week")
    private int endWeek;

    @Column(name = "start_section")
    private int startSection;

    @Column(name = "sections")
    private int sections;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "odd_only")
    private boolean oddOnly;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Column(name="day")
    private int day;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public int getStartSection() {
        return startSection;
    }

    public void setStartSection(int startSection) {
        this.startSection = startSection;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public boolean isOddOnly() {
        return oddOnly;
    }

    public void setOddOnly(boolean oddOnly) {
        this.oddOnly = oddOnly;
    }
}
