package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职务信息表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_duties")
public class TDuties extends Model<TDuties> {

    private static final long serialVersionUID = 1L;

	/**
	 * 职务编号
	 */
	@TableId(type = IdType.AUTO)
	@TableField(value="Du_Id")
	private String duId;

	/**
	 * 职务名称
	 */
	@TableField(value="Du_Name")
	private String duName;

	/**
	 * 职务工资
	 */
	@TableField(value="Du_DuSalary")
	private Float duDusalary;

	/**
	 * 基本工资
	 */
	@TableField(value="Du_BaseSalary")
	private Float duBasesalary;



	public String getDuId() {
		return duId;
	}

	public void setDuId(String duId) {
		this.duId = duId;
	}

	public String getDuName() {
		return duName;
	}

	public void setDuName(String duName) {
		this.duName = duName;
	}

	public Float getDuDusalary() {
		return duDusalary;
	}

	public void setDuDusalary(Float duDusalary) {
		this.duDusalary = duDusalary;
	}

	public Float getDuBasesalary() {
		return duBasesalary;
	}

	public void setDuBasesalary(Float duBasesalary) {
		this.duBasesalary = duBasesalary;
	}

}
