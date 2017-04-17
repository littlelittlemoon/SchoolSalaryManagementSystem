package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 绩效奖金表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_prize")
public class Prize extends Model<Prize> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 工龄津贴
     */
	@TableField("prize_long_pay")
	private Float prizeLongPay;
    /**
     * 福利补贴
     */
	@TableField("prize_welfare")
	private Float prizeWelfare;
    /**
     * 全勤奖
     */
	@TableField("prize_full_bonus")
	private Float prizeFullBonus;
    /**
     * 考核年月
     */
	@TableField("check_time")
	private Date checkTime;
    /**
     * 审核状态
     */
	@TableField("prize_state")
	private String prizeState;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Float getPrizeLongPay() {
		return prizeLongPay;
	}

	public void setPrizeLongPay(Float prizeLongPay) {
		this.prizeLongPay = prizeLongPay;
	}

	public Float getPrizeWelfare() {
		return prizeWelfare;
	}

	public void setPrizeWelfare(Float prizeWelfare) {
		this.prizeWelfare = prizeWelfare;
	}

	public Float getPrizeFullBonus() {
		return prizeFullBonus;
	}

	public void setPrizeFullBonus(Float prizeFullBonus) {
		this.prizeFullBonus = prizeFullBonus;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getPrizeState() {
		return prizeState;
	}

	public void setPrizeState(String prizeState) {
		this.prizeState = prizeState;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
