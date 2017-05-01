package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

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
@Data
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
    private String absentStartTime;
    /**
     * 结束时间
     */
    @TableField("absent_end_time")
    private String absentEndTime;
    /**
     * 请假天数
     */
    @TableField("absent_days")
    private Integer absentDays;
    /**
     * 审核状态
     */
    @TableField("absent_state")
    private String absentState;

    /**
     * 申请时间
     */
    @TableField("absent_apply_time")
    private String absentApplyTime;

    /**
     * 审核时间
     */
    @TableField("absent_check_time")
    private String absentCheckTime;

    @Override
    protected Serializable pkVal() {
        return this.staffId;
    }

}
