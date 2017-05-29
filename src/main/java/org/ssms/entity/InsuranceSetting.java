package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 五险一金扣款规则表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@TableName("t_insurance_setting")
public class InsuranceSetting extends Model<InsuranceSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 缴纳基数比例
     */
	@TableField("base_rate")
	private Double baseRate;
    /**
     * 医疗保险扣除比例
     */
	@TableField("medical_rate")
	private Double medicalRate;
    /**
     * 养老保险扣除比例
     */
	@TableField("aged_rate")
	private Double agedRate;
    /**
     * 失业保险扣除比例
     */
	@TableField("unemp_rate")
	private Double unempRate;
    /**
     * 公积金扣除比例
     */
	@TableField("accu_rate")
	private Double accuRate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(Double baseRate) {
		this.baseRate = baseRate;
	}

	public Double getMedicalRate() {
		return medicalRate;
	}

	public void setMedicalRate(Double medicalRate) {
		this.medicalRate = medicalRate;
	}

	public Double getAgedRate() {
		return agedRate;
	}

	public void setAgedRate(Double agedRate) {
		this.agedRate = agedRate;
	}

	public Double getUnempRate() {
		return unempRate;
	}

	public void setUnempRate(Double unempRate) {
		this.unempRate = unempRate;
	}

	public Double getAccuRate() {
		return accuRate;
	}

	public void setAccuRate(Double accuRate) {
		this.accuRate = accuRate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
