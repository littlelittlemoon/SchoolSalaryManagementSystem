package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职务信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_duty")
public class Duty extends Model<Duty> {

    private static final long serialVersionUID = 1L;

    /**
     * 职务编号
     */
    @TableId("duty_id")
	private String dutyId;
    /**
     * 职务名称
     */
	@TableField("duty_name")
	private String dutyName;
    /**
     * 职务工资
     */
	@TableField("duty_salary")
	private Float dutySalary;


	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Float getDutySalary() {
		return dutySalary;
	}

	public void setDutySalary(Float dutySalary) {
		this.dutySalary = dutySalary;
	}

	@Override
	protected Serializable pkVal() {
		return this.dutyId;
	}

}
