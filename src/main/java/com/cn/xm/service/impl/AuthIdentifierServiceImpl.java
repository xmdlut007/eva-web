package com.cn.xm.service.impl;

import com.cn.xm.common.model.AuthIdentifier;
import com.cn.xm.dao.AuthIdentifierMapper;
import com.cn.xm.service.AuthIdentifierService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月23日 下午11:27:27
 */
@Service("authIdentifierService")
public class AuthIdentifierServiceImpl implements AuthIdentifierService {
    @Resource
    private AuthIdentifierMapper authIdentifierMapper;
    @Override
    public int insertAuthIdentifier(AuthIdentifier authIdentifier) {
        // TODO Auto-generated method stub
        authIdentifierMapper.insertSelective(authIdentifier);
        return 0;
    }

}
