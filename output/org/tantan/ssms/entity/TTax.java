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
 * 纳税款表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_tax")
public class TTax extends Model<TTax> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(type = IdType.AUTO)
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 应纳税所得额
	 */
	@TableField(value="Ta_Taxable")
	private Float taTaxable;

	/**
	 * 适用税率
	 */
	@TableField(value="Ta_Rate")
	private Float taRate;

	/**
	 * 速算扣除数
	 */
	@TableField(value="Ta_Calcu")
	private Float taCalcu;

	/**
	 * 纳税金额
	 */
	@TableField(value="Ta_TaxMoney")
	private Float taTaxmoney;

	/**
	 * 考核时间
	 */
	@TableField(value="Ta_Time")
	private Date taTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public Float getTaTaxable() {
		return taTaxable;
	}

	public void setTaTaxable(Float taTaxable) {
		this.taTaxable = taTaxable;
	}

	public Float getTaRate() {
		return taRate;
	}

	public void setTaRate(Float taRate) {
		this.taRate = taRate;
	}

	public Float getTaCalcu() {
		return taCalcu;
	}

	public void setTaCalcu(Float taCalcu) {
		this.taCalcu = taCalcu;
	}

	public Float getTaTaxmoney() {
		return taTaxmoney;
	}

	public void setTaTaxmoney(Float taTaxmoney) {
		this.taTaxmoney = taTaxmoney;
	}

	public Date getTaTime() {
		return taTime;
	}

	public void setTaTime(Date taTime) {
		this.taTime = taTime;
	}

}
