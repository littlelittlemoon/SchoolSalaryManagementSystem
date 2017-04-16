package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 五险一金表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Insurance")
public class TInsurance extends Model<TInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	private String Sta_Id;
    /**
     * 医疗保险
     */
	private Float Ins_Medical;
    /**
     * 养老保险
     */
	private Float Ins_Aged;
    /**
     * 失业保险
     */
	private Float Ins_Unemp;
    /**
     * 公积金
     */
	private Float Ins_Accu;
    /**
     * 考核年月
     */
	private Date Ins_Time;
    /**
     * 审核状态
     */
	private String Ins_State;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public Float getIns_Medical() {
		return Ins_Medical;
	}

	public void setIns_Medical(Float Ins_Medical) {
		this.Ins_Medical = Ins_Medical;
	}

	public Float getIns_Aged() {
		return Ins_Aged;
	}

	public void setIns_Aged(Float Ins_Aged) {
		this.Ins_Aged = Ins_Aged;
	}

	public Float getIns_Unemp() {
		return Ins_Unemp;
	}

	public void setIns_Unemp(Float Ins_Unemp) {
		this.Ins_Unemp = Ins_Unemp;
	}

	public Float getIns_Accu() {
		return Ins_Accu;
	}

	public void setIns_Accu(Float Ins_Accu) {
		this.Ins_Accu = Ins_Accu;
	}

	public Date getIns_Time() {
		return Ins_Time;
	}

	public void setIns_Time(Date Ins_Time) {
		this.Ins_Time = Ins_Time;
	}

	public String getIns_State() {
		return Ins_State;
	}

	public void setIns_State(String Ins_State) {
		this.Ins_State = Ins_State;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
