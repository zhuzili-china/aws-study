package com.deloitte.jenkinsstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deloitte.jenkinsstudy.dao.UserinfoPOMapper;
import com.deloitte.jenkinsstudy.entity.po.UserinfoPO;
import com.deloitte.jenkinsstudy.service.UserinfoPOService;
import org.springframework.stereotype.Service;
@Service
public class UserinfoPOServiceImpl extends ServiceImpl<UserinfoPOMapper, UserinfoPO> implements UserinfoPOService{

}
