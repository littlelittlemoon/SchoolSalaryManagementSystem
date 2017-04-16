package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 职称信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Title")
public class TTitle extends Model<TTitle> {

    private static final long serialVersionUID = 1L;

    /**
     * 职称编号
     */
	@TableId
	private String Tit_Id;
    /**
     * 职称名称
     */
	private String Tit_Name;
    /**
     * 职称工资
     */
	private Float Tit_Salary;
    /**
     * 基本工资
     */
	private Float Tit_BaseSalary;


	public String getTit_Id() {
		return Tit_Id;
	}

	public void setTit_Id(String Tit_Id) {
		this.Tit_Id = Tit_Id;
	}

	public String getTit_Name() {
		return Tit_Name;
	}

	public void setTit_Name(String Tit_Name) {
		this.Tit_Name = Tit_Name;
	}

	public Float getTit_Salary() {
		return Tit_Salary;
	}

	public void setTit_Salary(Float Tit_Salary) {
		this.Tit_Salary = Tit_Salary;
	}

	public Float getTit_BaseSalary() {
		return Tit_BaseSalary;
	}

	public void setTit_BaseSalary(Float Tit_BaseSalary) {
		this.Tit_BaseSalary = Tit_BaseSalary;
	}

	@Override
	protected Serializable pkVal() {
		return this.Tit_Id;
	}

}
