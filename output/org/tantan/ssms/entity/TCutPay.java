package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 扣款表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_cut_pay")
public class TCutPay extends Model<TCutPay> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(type = IdType.AUTO)
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 缺勤金
	 */
	@TableField(value="Cut_Absence")
	private Integer cutAbsence;

	/**
	 * 五险一金
	 */
	@TableField(value="Cut_Insurance")
	private Float cutInsurance;

	/**
	 * 纳税金额
	 */
	@TableField(value="Cut_Revenue")
	private Float cutRevenue;

	/**
	 * 扣款总计
	 */
	@TableField(value="Cut_Total")
	private Float cutTotal;

	/**
	 * 考核年月
	 */
	@TableField(value="Cut_Time")
	private Date cutTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public Integer getCutAbsence() {
		return cutAbsence;
	}

	public void setCutAbsence(Integer cutAbsence) {
		this.cutAbsence = cutAbsence;
	}

	public Float getCutInsurance() {
		return cutInsurance;
	}

	public void setCutInsurance(Float cutInsurance) {
		this.cutInsurance = cutInsurance;
	}

	public Float getCutRevenue() {
		return cutRevenue;
	}

	public void setCutRevenue(Float cutRevenue) {
		this.cutRevenue = cutRevenue;
	}

	public Float getCutTotal() {
		return cutTotal;
	}

	public void setCutTotal(Float cutTotal) {
		this.cutTotal = cutTotal;
	}

	public Date getCutTime() {
		return cutTime;
	}

	public void setCutTime(Date cutTime) {
		this.cutTime = cutTime;
	}

}
