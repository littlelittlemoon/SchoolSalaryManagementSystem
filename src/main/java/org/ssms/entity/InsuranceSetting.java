package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 五险一金扣款规则表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@TableName("t_insurance_setting")
@Data
public class InsuranceSetting extends Model<InsuranceSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 缴纳基数比例
     */
    @TableField("base_rate")
    private Double baseRate;
    /**
     * 医疗保险扣除比例
     */
    @TableField("medical_rate")
    private Double medicalRate;
    /**
     * 养老保险扣除比例
     */
    @TableField("aged_rate")
    private Double agedRate;
    /**
     * 失业保险扣除比例
     */
    @TableField("unemp_rate")
    private Double unempRate;
    /**
     * 公积金扣除比例
     */
    @TableField("accu_rate")
    private Double accuRate;

    @TableField("status")
    private String status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
