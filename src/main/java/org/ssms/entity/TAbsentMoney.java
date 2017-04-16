package org.ssms.test.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 考勤扣款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Absent_Money")
public class TAbsentMoney extends Model<TAbsentMoney> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	private String Sta_Id;
    /**
     * 应到天数
     */
	private Integer AM_Due_Days;
    /**
     * 实到天数
     */
	private Integer AM_Actual_Days;
    /**
     * 缺勤金
     */
	private Float AM_Money;
    /**
     * 考核年月
     */
	private Date AM_Time;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public Integer getAM_Due_Days() {
		return AM_Due_Days;
	}

	public void setAM_Due_Days(Integer AM_Due_Days) {
		this.AM_Due_Days = AM_Due_Days;
	}

	public Integer getAM_Actual_Days() {
		return AM_Actual_Days;
	}

	public void setAM_Actual_Days(Integer AM_Actual_Days) {
		this.AM_Actual_Days = AM_Actual_Days;
	}

	public Float getAM_Money() {
		return AM_Money;
	}

	public void setAM_Money(Float AM_Money) {
		this.AM_Money = AM_Money;
	}

	public Date getAM_Time() {
		return AM_Time;
	}

	public void setAM_Time(Date AM_Time) {
		this.AM_Time = AM_Time;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
