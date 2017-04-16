package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 考勤信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Absent_Info")
public class TAbsentInfo extends Model<TAbsentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	@TableId
	private String Sta_Id;
    /**
     * 缺勤原因
     */
	private String Abs_Reason;
    /**
     * 开始时间
     */
	private Date Abs_Start_Time;
    /**
     * 结束时间
     */
	private Date Abs_End_Time;
    /**
     * 请假天数
     */
	private Date Abs_Days;
    /**
     * 审核状态
     */
	private String Abs_State;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public String getAbs_Reason() {
		return Abs_Reason;
	}

	public void setAbs_Reason(String Abs_Reason) {
		this.Abs_Reason = Abs_Reason;
	}

	public Date getAbs_Start_Time() {
		return Abs_Start_Time;
	}

	public void setAbs_Start_Time(Date Abs_Start_Time) {
		this.Abs_Start_Time = Abs_Start_Time;
	}

	public Date getAbs_End_Time() {
		return Abs_End_Time;
	}

	public void setAbs_End_Time(Date Abs_End_Time) {
		this.Abs_End_Time = Abs_End_Time;
	}

	public Date getAbs_Days() {
		return Abs_Days;
	}

	public void setAbs_Days(Date Abs_Days) {
		this.Abs_Days = Abs_Days;
	}

	public String getAbs_State() {
		return Abs_State;
	}

	public void setAbs_State(String Abs_State) {
		this.Abs_State = Abs_State;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
