package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 职务信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Duty")
public class TDuty extends Model<TDuty> {

    private static final long serialVersionUID = 1L;

    /**
     * 职务编号
     */
	@TableId
	private String Du_Id;
    /**
     * 职务名称
     */
	private String Du_Name;
    /**
     * 职务工资
     */
	private Float Du_Salary;


	public String getDu_Id() {
		return Du_Id;
	}

	public void setDu_Id(String Du_Id) {
		this.Du_Id = Du_Id;
	}

	public String getDu_Name() {
		return Du_Name;
	}

	public void setDu_Name(String Du_Name) {
		this.Du_Name = Du_Name;
	}

	public Float getDu_Salary() {
		return Du_Salary;
	}

	public void setDu_Salary(Float Du_Salary) {
		this.Du_Salary = Du_Salary;
	}

	@Override
	protected Serializable pkVal() {
		return this.Du_Id;
	}

}
