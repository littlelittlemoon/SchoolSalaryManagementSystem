package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 绩效奖金表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Prize")
public class TPrize extends Model<TPrize> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
	private String Sta_Id;
    /**
     * 工龄津贴
     */
	private Float Pr_Long_Pay;
    /**
     * 福利补贴
     */
	private Float Pr_Welfare;
    /**
     * 全勤奖
     */
	private Float Pr_Full_Bonus;
    /**
     * 考核年月
     */
	private Date Pr_Time;
    /**
     * 审核状态
     */
	private String Pr_State;


	public String getSta_Id() {
		return Sta_Id;
	}

	public void setSta_Id(String Sta_Id) {
		this.Sta_Id = Sta_Id;
	}

	public Float getPr_Long_Pay() {
		return Pr_Long_Pay;
	}

	public void setPr_Long_Pay(Float Pr_Long_Pay) {
		this.Pr_Long_Pay = Pr_Long_Pay;
	}

	public Float getPr_Welfare() {
		return Pr_Welfare;
	}

	public void setPr_Welfare(Float Pr_Welfare) {
		this.Pr_Welfare = Pr_Welfare;
	}

	public Float getPr_Full_Bonus() {
		return Pr_Full_Bonus;
	}

	public void setPr_Full_Bonus(Float Pr_Full_Bonus) {
		this.Pr_Full_Bonus = Pr_Full_Bonus;
	}

	public Date getPr_Time() {
		return Pr_Time;
	}

	public void setPr_Time(Date Pr_Time) {
		this.Pr_Time = Pr_Time;
	}

	public String getPr_State() {
		return Pr_State;
	}

	public void setPr_State(String Pr_State) {
		this.Pr_State = Pr_State;
	}

	@Override
	protected Serializable pkVal() {
		return this.Sta_Id;
	}

}
