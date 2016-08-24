package com.cn.xm.dao;

import com.cn.xm.common.model.AuthIdentifier;

public interface AuthIdentifierMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    int deleteBySelective(AuthIdentifier authIdentifier);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    int insert(AuthIdentifier record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    int insertSelective(AuthIdentifier record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    AuthIdentifier selectByPrimaryKey(Long id);

    AuthIdentifier selectBySelective(AuthIdentifier authIdentifier);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AuthIdentifier record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table auth_identifier
     * @mbggenerated
     */
    int updateByPrimaryKey(AuthIdentifier record);
}