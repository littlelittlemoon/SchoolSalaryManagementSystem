package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 绩效奖金表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_prize")
public class TPrize extends Model<TPrize> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(value = "Sta_Id")
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 工龄津贴
	 */
	@TableField(value="Pr_LongPay")
	private Float prLongpay;

	/**
	 * 福利补贴
	 */
	@TableField(value="Pr_Welfare")
	private Float prWelfare;

	/**
	 * 全勤奖
	 */
	@TableField(value="Pr_fullbonus")
	private Float prFullbonus;

	/**
	 * 考核年月
	 */
	@TableField(value="Pr_Time")
	private Date prTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public Float getPrLongpay() {
		return prLongpay;
	}

	public void setPrLongpay(Float prLongpay) {
		this.prLongpay = prLongpay;
	}

	public Float getPrWelfare() {
		return prWelfare;
	}

	public void setPrWelfare(Float prWelfare) {
		this.prWelfare = prWelfare;
	}

	public Float getPrFullbonus() {
		return prFullbonus;
	}

	public void setPrFullbonus(Float prFullbonus) {
		this.prFullbonus = prFullbonus;
	}

	public Date getPrTime() {
		return prTime;
	}

	public void setPrTime(Date prTime) {
		this.prTime = prTime;
	}

	@Override
	protected Serializable pkVal() {
		return staId;
	}
}
