package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 纳税款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_tax")
public class Tax extends Model<Tax> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 应纳税所得额
     */
	@TableField("tax_taxable")
	private Float taxTaxable;
    /**
     * 适用税率
     */
	@TableField("tax_rate")
	private Float taxRate;
    /**
     * 速算扣除数
     */
	@TableField("tax_calcu")
	private Float taxCalcu;
    /**
     * 纳税金额
     */
	@TableField("tax_tax_money")
	private Float taxTaxMoney;
    /**
     * 审核时间
     */
	@TableField("check_time")
	private Date checkTime;
    /**
     * 审核状态
     */
	@TableField("tax_state")
	private String taxState;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Float getTaxTaxable() {
		return taxTaxable;
	}

	public void setTaxTaxable(Float taxTaxable) {
		this.taxTaxable = taxTaxable;
	}

	public Float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Float taxRate) {
		this.taxRate = taxRate;
	}

	public Float getTaxCalcu() {
		return taxCalcu;
	}

	public void setTaxCalcu(Float taxCalcu) {
		this.taxCalcu = taxCalcu;
	}

	public Float getTaxTaxMoney() {
		return taxTaxMoney;
	}

	public void setTaxTaxMoney(Float taxTaxMoney) {
		this.taxTaxMoney = taxTaxMoney;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getTaxState() {
		return taxState;
	}

	public void setTaxState(String taxState) {
		this.taxState = taxState;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
