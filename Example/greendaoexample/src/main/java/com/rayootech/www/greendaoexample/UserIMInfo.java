package com.rayootech.www.greendaoexample;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * File Description  :
 *
 * @author : zhanggeng
 * @version : v1.0
 *          **************修订历史*************
 * @email : zhanggengdyx@gmail.com
 * @date : 2016/12/6 19:29
 */

@Entity
public class UserIMInfo {

    private String userId;
    private String icon;
    private String userName;
    private String sex;
    private String diease;

    @Generated(hash = 546657836)
    public UserIMInfo(String userId, String icon, String userName, String sex,
            String diease) {
        this.userId = userId;
        this.icon = icon;
        this.userName = userName;
        this.sex = sex;
        this.diease = diease;
    }

    @Generated(hash = 864772522)
    public UserIMInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDiease() {
        return diease;
    }

    public void setDiease(String diease) {
        this.diease = diease;
    }


    @Override
    public String toString() {
        return "UserIMInfo{" +
                "userId='" + userId + '\'' +
                ", icon='" + icon + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", diease='" + diease + '\'' +
                '}';
    }
}
