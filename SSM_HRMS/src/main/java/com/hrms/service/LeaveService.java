package com.hrms.service;

import com.hrms.bean.Leave;
import com.hrms.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/11/25 13:10
 */
@Service
public class LeaveService {
    @Autowired
    LeaveMapper leaveMapper;

    public List<Leave> getLeaveList(Integer offser, Integer limit){
        return leaveMapper.selectByLimitAndOffset(offser,limit);
    }

    public int getLeaveCount(){
        return leaveMapper.countLeaves();
    }

    public int addLeave(Leave leave){
        return leaveMapper.insertOne(leave);
    }


}