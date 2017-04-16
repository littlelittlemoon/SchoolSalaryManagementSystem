package org.ssms.test.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 银行发放表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_To_Bank")
public class TToBank extends Model<TToBank> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	private String Sta_Id;
    /**
     * 员工姓名
     */
	private String Sta_Name;
    /**
     * 身份证号
     */
	private String Sta_Identity_Num;
    /**
     * 银行卡账号
     */
	private String Sta_Bank_Acount;
    /**
     * 电话号码&登录账号
     */
	private String Sta_Tel;
    /**
     * 应发金额
     */
	private Float TB_Salary;
    /**
     * 发放时间
     */
	private Date TB_Time;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public String getSta_Name() {
		return Sta_Name;
	}

	public void setSta_Name(String Sta_Name) {
		this.Sta_Name = Sta_Name;
	}

	public String getSta_Identity_Num() {
		return Sta_Identity_Num;
	}

	public void setSta_Identity_Num(String Sta_Identity_Num) {
		this.Sta_Identity_Num = Sta_Identity_Num;
	}

	public String getSta_Bank_Acount() {
		return Sta_Bank_Acount;
	}

	public void setSta_Bank_Acount(String Sta_Bank_Acount) {
		this.Sta_Bank_Acount = Sta_Bank_Acount;
	}

	public String getSta_Tel() {
		return Sta_Tel;
	}

	public void setSta_Tel(String Sta_Tel) {
		this.Sta_Tel = Sta_Tel;
	}

	public Float getTB_Salary() {
		return TB_Salary;
	}

	public void setTB_Salary(Float TB_Salary) {
		this.TB_Salary = TB_Salary;
	}

	public Date getTB_Time() {
		return TB_Time;
	}

	public void setTB_Time(Date TB_Time) {
		this.TB_Time = TB_Time;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
