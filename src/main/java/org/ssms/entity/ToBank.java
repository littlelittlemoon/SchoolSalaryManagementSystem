package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 银行发放表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_to_bank")
public class ToBank extends Model<ToBank> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 员工姓名
     */
	@TableField("staff_name")
	private String staffName;
    /**
     * 身份证号
     */
	@TableField("staff_identity_num")
	private String staffIdentityNum;
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
     * 应发金额
     */
	private Float salary;
    /**
     * 发放时间
     */
	@TableField("send_time")
	private Date sendTime;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffIdentityNum() {
		return staffIdentityNum;
	}

	public void setStaffIdentityNum(String staffIdentityNum) {
		this.staffIdentityNum = staffIdentityNum;
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

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
