package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_staff_info")
public class TStaffInfo extends Model<TStaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "Sta_Id")
    @TableField(value = "Sta_Id")
    private String staId;

    /**
     * 登录密码
     */
    @TableField(value = "Sta_PassWord")
    private String staPassword;

    /**
     * 员工姓名
     */
    @TableField(value = "Sta_Name")
    private String staName;

    /**
     * 员工性别
     */
    @TableField(value = "Sta_Sex")
    private String staSex;

    /**
     * 身份证号
     */
    @TableField(value = "Sta_IdentityNum")
    private String staIdentitynum;

    /**
     * 所属部门编号
     */
    @TableField(value = "Dep_Id")
    private String depId;

    /**
     * 职务编号
     */
    @TableField(value = "Du_Id")
    private String duId;

    /**
     * 入职时间
     */
    @TableField(value = "Sta_EntryTime")
    private Date staEntrytime;

    /**
     * 银行卡账号
     */
    @TableField(value = "Sta_BankAcount")
    private String staBankacount;

    /**
     * 电话号码&登录账号
     */
    @TableField(value = "Sta_Tel")
    private String staTel;

    /**
     * 角色编号
     */
    @TableField(value = "R_Id")
    private String rId;


    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId;
    }

    public String getStaPassword() {
        return staPassword;
    }

    public void setStaPassword(String staPassword) {
        this.staPassword = staPassword;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getStaSex() {
        return staSex;
    }

    public void setStaSex(String staSex) {
        this.staSex = staSex;
    }

    public String getStaIdentitynum() {
        return staIdentitynum;
    }

    public void setStaIdentitynum(String staIdentitynum) {
        this.staIdentitynum = staIdentitynum;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDuId() {
        return duId;
    }

    public void setDuId(String duId) {
        this.duId = duId;
    }

    public Date getStaEntrytime() {
        return staEntrytime;
    }

    public void setStaEntrytime(Date staEntrytime) {
        this.staEntrytime = staEntrytime;
    }

    public String getStaBankacount() {
        return staBankacount;
    }

    public void setStaBankacount(String staBankacount) {
        this.staBankacount = staBankacount;
    }

    public String getStaTel() {
        return staTel;
    }

    public void setStaTel(String staTel) {
        this.staTel = staTel;
    }

    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }

    @Override
    protected Serializable pkVal() {
        return staId;
    }
}
