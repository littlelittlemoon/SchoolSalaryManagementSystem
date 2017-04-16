package org.ssms.test.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Staff_Info")
public class TStaffInfo extends Model<TStaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	private String Sta_Id;
    /**
     * 登录密码
     */
	private String Sta_Pass_Word;
    /**
     * 员工姓名
     */
	private String Sta_Name;
    /**
     * 员工性别
     */
	private String Sta_Sex;
    /**
     * 身份证号
     */
	private String Sta_Identity_Num;
    /**
     * 所属部门编号
     */
	private String Dep_Id;
    /**
     * 职称编号
     */
	private String Tit_Id;
    /**
     * 职务编号
     */
	private String Du_Id;
    /**
     * 入职时间
     */
	private Date Sta_Entry_Time;
    /**
     * 银行卡账号
     */
	private String Sta_Bank_Acount;
    /**
     * 电话号码&登录账号
     */
	private String Sta_Tel;
    /**
     * 角色编号
     */
	private String R_Id;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public String getSta_Pass_Word() {
		return Sta_Pass_Word;
	}

	public void setSta_Pass_Word(String Sta_Pass_Word) {
		this.Sta_Pass_Word = Sta_Pass_Word;
	}

	public String getSta_Name() {
		return Sta_Name;
	}

	public void setSta_Name(String Sta_Name) {
		this.Sta_Name = Sta_Name;
	}

	public String getSta_Sex() {
		return Sta_Sex;
	}

	public void setSta_Sex(String Sta_Sex) {
		this.Sta_Sex = Sta_Sex;
	}

	public String getSta_Identity_Num() {
		return Sta_Identity_Num;
	}

	public void setSta_Identity_Num(String Sta_Identity_Num) {
		this.Sta_Identity_Num = Sta_Identity_Num;
	}

	public String getDep_Id() {
		return Dep_Id;
	}

	public void setDep_Id(String Dep_Id) {
		this.Dep_Id = Dep_Id;
	}

	public String getTit_Id() {
		return Tit_Id;
	}

	public void setTit_Id(String Tit_Id) {
		this.Tit_Id = Tit_Id;
	}

	public String getDu_Id() {
		return Du_Id;
	}

	public void setDu_Id(String Du_Id) {
		this.Du_Id = Du_Id;
	}

	public Date getSta_Entry_Time() {
		return Sta_Entry_Time;
	}

	public void setSta_Entry_Time(Date Sta_Entry_Time) {
		this.Sta_Entry_Time = Sta_Entry_Time;
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

	public String getR_Id() {
		return R_Id;
	}

	public void setR_Id(String R_Id) {
		this.R_Id = R_Id;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
