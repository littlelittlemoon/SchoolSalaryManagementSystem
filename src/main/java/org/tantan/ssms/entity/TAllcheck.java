package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 考勤汇总表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_allcheck")
public class TAllcheck extends Model<TAllcheck> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(value = "Sta_Id")
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 应到天数
	 */
	@TableField(value="AC_DueToDays")
	private Integer acDuetodays;

	/**
	 * 实到天数
	 */
	@TableField(value="AC_ActualDays")
	private Integer acActualdays;

	/**
	 * 缺勤金
	 */
	@TableField(value="AC_Money")
	private Float acMoney;

	/**
	 * 考核年月
	 */
	@TableId
	@TableField(value="AC_Time")
	private Date acTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public Integer getAcDuetodays() {
		return acDuetodays;
	}

	public void setAcDuetodays(Integer acDuetodays) {
		this.acDuetodays = acDuetodays;
	}

	public Integer getAcActualdays() {
		return acActualdays;
	}

	public void setAcActualdays(Integer acActualdays) {
		this.acActualdays = acActualdays;
	}

	public Float getAcMoney() {
		return acMoney;
	}

	public void setAcMoney(Float acMoney) {
		this.acMoney = acMoney;
	}

	public Date getAcTime() {
		return acTime;
	}

	public void setAcTime(Date acTime) {
		this.acTime = acTime;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
