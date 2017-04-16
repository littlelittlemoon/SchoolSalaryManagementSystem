package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 纳税款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Tax")
public class TTax extends Model<TTax> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	@TableId
	private String Sta_Id;
    /**
     * 应纳税所得额
     */
	private Float Ta_Taxable;
    /**
     * 适用税率
     */
	private Float Ta_Rate;
    /**
     * 速算扣除数
     */
	private Float Ta_Calcu;
    /**
     * 纳税金额
     */
	private Float Ta_Tax_Money;
    /**
     * 审核时间
     */
	private Date Ta_Time;
    /**
     * 审核状态
     */
	private String Ta_State;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public Float getTa_Taxable() {
		return Ta_Taxable;
	}

	public void setTa_Taxable(Float Ta_Taxable) {
		this.Ta_Taxable = Ta_Taxable;
	}

	public Float getTa_Rate() {
		return Ta_Rate;
	}

	public void setTa_Rate(Float Ta_Rate) {
		this.Ta_Rate = Ta_Rate;
	}

	public Float getTa_Calcu() {
		return Ta_Calcu;
	}

	public void setTa_Calcu(Float Ta_Calcu) {
		this.Ta_Calcu = Ta_Calcu;
	}

	public Float getTa_Tax_Money() {
		return Ta_Tax_Money;
	}

	public void setTa_Tax_Money(Float Ta_Tax_Money) {
		this.Ta_Tax_Money = Ta_Tax_Money;
	}

	public Date getTa_Time() {
		return Ta_Time;
	}

	public void setTa_Time(Date Ta_Time) {
		this.Ta_Time = Ta_Time;
	}

	public String getTa_State() {
		return Ta_State;
	}

	public void setTa_State(String Ta_State) {
		this.Ta_State = Ta_State;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
