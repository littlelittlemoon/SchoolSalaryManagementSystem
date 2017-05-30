package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 缺勤扣款规则表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@TableName("t_absence_setting")
@Data
public class AbsenceSetting extends Model<AbsenceSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 缺勤类型
     */
    @TableField("absent_type")
    private String absentType;
    /**
     * 扣除比例
     */
    private Double proportion;
    /**
     * 应到天数
     */
    @TableField("should_days")
    private Double shouldDays;

    @TableField("status")
    private String status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
