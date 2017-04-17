package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_staff_info")
public class StaffInfo extends Model<StaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 登录密码
     */
	@TableField("staff_pass_word")
	private String staffPassWord;
    /**
     * 员工姓名
     */
	@TableField("staff_name")
	private String staffName;
    /**
     * 员工性别
     */
	@TableField("staff_sex")
	private String staffSex;
    /**
     * 身份证号
     */
	@TableField("staff_identity_num")
	private String staffIdentityNum;
    /**
     * 所属部门编号
     */
	@TableField("department_id")
	private String departmentId;
    /**
     * 职称编号
     */
	@TableField("title_id")
	private String titleId;
    /**
     * 职务编号
     */
	@TableField("duty_id")
	private String dutyId;
    /**
     * 入职时间
     */
	@TableField("staff_entry_time")
	private Date staffEntryTime;
    /**
     * 银行卡账号
     */
	@TableField("staff_bank_acount")
	private String staffBankAcount;
    /**
     * 电话号码&登录账号
     */
	@TableField("staff_tel")
	private String staffTel;
    /**
     * 角色编号
     */
	@TableField("role_id")
	private String roleId;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffPassWord() {
		return staffPassWord;
	}

	public void setStaffPassWord(String staffPassWord) {
		this.staffPassWord = staffPassWord;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public String getStaffIdentityNum() {
		return staffIdentityNum;
	}

	public void setStaffIdentityNum(String staffIdentityNum) {
		this.staffIdentityNum = staffIdentityNum;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public Date getStaffEntryTime() {
		return staffEntryTime;
	}

	public void setStaffEntryTime(Date staffEntryTime) {
		this.staffEntryTime = staffEntryTime;
	}

	public String getStaffBankAcount() {
		return staffBankAcount;
	}

	public void setStaffBankAcount(String staffBankAcount) {
		this.staffBankAcount = staffBankAcount;
	}

	public String getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
