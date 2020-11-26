package com.hrms.bean;

import java.util.Date;

/**
 * @Author : hadoo
 * @Date : 2020/11/25 13:12
 */
public class Leave {
    private Integer ano;
    private Integer eno;
    private Integer dno;

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    private String ename;
    private String date;
    private String reason;

    public Leave() {
    }

    public Leave(Integer ano, Integer eno, Integer dno, String ename, String date, String reason) {
        this.ano = ano;
        this.eno = eno;
        this.dno = dno;
        this.ename = ename;
        this.date = date;
        this.reason = reason;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "ano=" + ano +
                ", eno=" + eno +
                ", dno=" + dno +
                ", ename='" + ename + '\'' +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}