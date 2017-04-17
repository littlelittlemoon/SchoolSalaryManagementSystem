package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 五险一金表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_insurance")
public class Insurance extends Model<Insurance> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 医疗保险
     */
	@TableField("insurance_medical")
	private Float insuranceMedical;
    /**
     * 养老保险
     */
	@TableField("insurance_aged")
	private Float insuranceAged;
    /**
     * 失业保险
     */
	@TableField("insurance_unemp")
	private Float insuranceUnemp;
    /**
     * 公积金
     */
	@TableField("insurance_accu")
	private Float insuranceAccu;
    /**
     * 考核年月
     */
	@TableField("insurance_time")
	private Date insuranceTime;
    /**
     * 审核状态
     */
	@TableField("insurance_state")
	private String insuranceState;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Float getInsuranceMedical() {
		return insuranceMedical;
	}

	public void setInsuranceMedical(Float insuranceMedical) {
		this.insuranceMedical = insuranceMedical;
	}

	public Float getInsuranceAged() {
		return insuranceAged;
	}

	public void setInsuranceAged(Float insuranceAged) {
		this.insuranceAged = insuranceAged;
	}

	public Float getInsuranceUnemp() {
		return insuranceUnemp;
	}

	public void setInsuranceUnemp(Float insuranceUnemp) {
		this.insuranceUnemp = insuranceUnemp;
	}

	public Float getInsuranceAccu() {
		return insuranceAccu;
	}

	public void setInsuranceAccu(Float insuranceAccu) {
		this.insuranceAccu = insuranceAccu;
	}

	public Date getInsuranceTime() {
		return insuranceTime;
	}

	public void setInsuranceTime(Date insuranceTime) {
		this.insuranceTime = insuranceTime;
	}

	public String getInsuranceState() {
		return insuranceState;
	}

	public void setInsuranceState(String insuranceState) {
		this.insuranceState = insuranceState;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
