package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 考勤扣款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_absent_money")
public class AbsentMoney extends Model<AbsentMoney> {

	private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId("staff_id")
	private String staffId;
	/**
	 * 应到天数
	 */
	@TableField("due_days")
	private Integer dueDays;
	/**
	 * 实到天数
	 */
	@TableField("actual_days")
	private Integer actualDays;
	/**
	 * 缺勤金
	 */
	private Float money;
	/**
	 * 考核年月
	 */
	@TableField("check_time")
	private Date checkTime;
	/**
	 * 审核状态
	 */
	@TableField("absent_money_state")
	private String absentMoneyState;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Integer getDueDays() {
		return dueDays;
	}

	public void setDueDays(Integer dueDays) {
		this.dueDays = dueDays;
	}

	public Integer getActualDays() {
		return actualDays;
	}

	public void setActualDays(Integer actualDays) {
		this.actualDays = actualDays;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getAbsentMoneyState() {
		return absentMoneyState;
	}

	public void setAbsentMoneyState(String absentMoneyState) {
		this.absentMoneyState = absentMoneyState;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
