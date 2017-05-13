package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 考勤扣款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_absent_money")
@Data
public class AbsentMoney extends Model<AbsentMoney> {

	private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId("staff_id")
	private String staffId;
	/**
	 * 应到天数
	 */
	@TableField("due_days")
	private Integer dueDays;
	/**
	 * 实到天数
	 */
	@TableField("actual_days")
	private Integer actualDays;
	/**
	 * 缺勤金
	 */
	private Double money;
	/**
	 * 考核年月
	 */
	@TableField("check_time")
	private String checkTime;
	/**
	 * 审核状态
	 */
	@TableField("absent_money_state")
	private String absentMoneyState;


	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
