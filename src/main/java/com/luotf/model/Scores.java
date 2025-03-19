package com.luotf.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Scores implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;
    
    private String course;
    
    private String introduction;
    
    private String classs;
    
    private String content;//内容
    
    private String student;//学生姓名
    
    private Integer scores;//成绩分数
    
    private String year;//年
    
    private String semester;//学期
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date time;

    public Scores(){}  
    
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public String getClasss() {
		return classs;
	}


	public void setClasss(String classs) {
		this.classs = classs;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStudent() {
		return student;
	}


	public void setStudent(String student) {
		this.student = student;
	}


	public Integer getScores() {
		return scores;
	}


	public void setScores(Integer scores) {
		this.scores = scores;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}

    
    

}