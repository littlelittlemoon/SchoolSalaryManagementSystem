package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 纳税款表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_tax")
@Data
public class Tax extends Model<Tax> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 应纳税所得额
     */
	@TableField("tax_taxable")
	private Float taxTaxable;
    /**
     * 适用税率
     */
	@TableField("tax_rate")
	private Float taxRate;
    /**
     * 速算扣除数
     */
	@TableField("tax_calcu")
	private Float taxCalcu;
    /**
     * 纳税金额
     */
	@TableField("tax_tax_money")
	private Float taxTaxMoney;
    /**
     * 审核时间
     */
	@TableField("check_time")
	private String checkTime;
    /**
     * 审核状态
     */
	@TableField("tax_state")
	private String taxState;

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
