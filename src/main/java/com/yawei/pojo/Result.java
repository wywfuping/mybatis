package com.yawei.pojo;

import java.util.Date;

public class Result {
    private Integer id;
    private String studentno;
    private String subjectid;
    private Float score;
    private Date examdate;

    private User user;
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", studentno='" + studentno + '\'' +
                ", subjectid='" + subjectid + '\'' +
                ", score=" + score +
                ", examdate=" + examdate +
                '}';
    }
}
