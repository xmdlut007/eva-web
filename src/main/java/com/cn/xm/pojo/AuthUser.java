package com.cn.xm.pojo;

public class AuthUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.is_active
     *
     * @mbggenerated
     */
    private Byte isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.is_superuser
     *
     * @mbggenerated
     */
    private Byte isSuperuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.is_locked
     *
     * @mbggenerated
     */
    private Byte isLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.create_time
     *
     * @mbggenerated
     */
    private Long createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.update_time
     *
     * @mbggenerated
     */
    private Long updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_user.role
     *
     * @mbggenerated
     */
    private Long role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.id
     *
     * @return the value of auth_user.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.id
     *
     * @param id the value for auth_user.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.uid
     *
     * @return the value of auth_user.uid
     *
     * @mbggenerated
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.uid
     *
     * @param uid the value for auth_user.uid
     *
     * @mbggenerated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.username
     *
     * @return the value of auth_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.username
     *
     * @param username the value for auth_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.password
     *
     * @return the value of auth_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.password
     *
     * @param password the value for auth_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.email
     *
     * @return the value of auth_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.email
     *
     * @param email the value for auth_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.nickname
     *
     * @return the value of auth_user.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.nickname
     *
     * @param nickname the value for auth_user.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.gender
     *
     * @return the value of auth_user.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.gender
     *
     * @param gender the value for auth_user.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.is_active
     *
     * @return the value of auth_user.is_active
     *
     * @mbggenerated
     */
    public Byte getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.is_active
     *
     * @param isActive the value for auth_user.is_active
     *
     * @mbggenerated
     */
    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.is_superuser
     *
     * @return the value of auth_user.is_superuser
     *
     * @mbggenerated
     */
    public Byte getIsSuperuser() {
        return isSuperuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.is_superuser
     *
     * @param isSuperuser the value for auth_user.is_superuser
     *
     * @mbggenerated
     */
    public void setIsSuperuser(Byte isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.is_locked
     *
     * @return the value of auth_user.is_locked
     *
     * @mbggenerated
     */
    public Byte getIsLocked() {
        return isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.is_locked
     *
     * @param isLocked the value for auth_user.is_locked
     *
     * @mbggenerated
     */
    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.create_time
     *
     * @return the value of auth_user.create_time
     *
     * @mbggenerated
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.create_time
     *
     * @param createTime the value for auth_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.update_time
     *
     * @return the value of auth_user.update_time
     *
     * @mbggenerated
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.update_time
     *
     * @param updateTime the value for auth_user.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_user.role
     *
     * @return the value of auth_user.role
     *
     * @mbggenerated
     */
    public Long getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_user.role
     *
     * @param role the value for auth_user.role
     *
     * @mbggenerated
     */
    public void setRole(Long role) {
        this.role = role;
    }
}