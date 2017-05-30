package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 扣税规则表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@TableName("t_tax_setting")
@Data
public class TaxSetting extends Model<TaxSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 上界
     */
	@TableField("min_num")
	private Double minNum;
    /**
     * 下界
     */
	@TableField("max_num")
	private Double maxNum;
    /**
     * 适用税率
     */
	private Double rate;
    /**
     * 速算扣除数
     */
	@TableField("calcu_num")
	private Double calcuNum;

	@TableField("status")
	private String status;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
