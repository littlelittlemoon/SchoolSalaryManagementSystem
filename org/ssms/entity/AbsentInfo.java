package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 考勤信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_absent_info")
public class AbsentInfo extends Model<AbsentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 缺勤原因
     */
	@TableField("absent_reason")
	private String absentReason;
    /**
     * 开始时间
     */
	@TableField("absent_start_time")
	private Date absentStartTime;
    /**
     * 结束时间
     */
	@TableField("absent_end_time")
	private Date absentEndTime;
    /**
     * 请假天数
     */
	@TableField("absent_days")
	private Date absentDays;
    /**
     * 审核状态
     */
	@TableField("absent_state")
	private String absentState;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getAbsentReason() {
		return absentReason;
	}

	public void setAbsentReason(String absentReason) {
		this.absentReason = absentReason;
	}

	public Date getAbsentStartTime() {
		return absentStartTime;
	}

	public void setAbsentStartTime(Date absentStartTime) {
		this.absentStartTime = absentStartTime;
	}

	public Date getAbsentEndTime() {
		return absentEndTime;
	}

	public void setAbsentEndTime(Date absentEndTime) {
		this.absentEndTime = absentEndTime;
	}

	public Date getAbsentDays() {
		return absentDays;
	}

	public void setAbsentDays(Date absentDays) {
		this.absentDays = absentDays;
	}

	public String getAbsentState() {
		return absentState;
	}

	public void setAbsentState(String absentState) {
		this.absentState = absentState;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
