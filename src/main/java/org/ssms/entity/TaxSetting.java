package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
public class TaxSetting extends Model<TaxSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 交税级别
     */
	private Integer level;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Double getMinNum() {
		return minNum;
	}

	public void setMinNum(Double minNum) {
		this.minNum = minNum;
	}

	public Double getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Double maxNum) {
		this.maxNum = maxNum;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getCalcuNum() {
		return calcuNum;
	}

	public void setCalcuNum(Double calcuNum) {
		this.calcuNum = calcuNum;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
