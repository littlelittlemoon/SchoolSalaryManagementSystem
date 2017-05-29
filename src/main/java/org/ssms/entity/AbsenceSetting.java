package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAbsentType() {
		return absentType;
	}

	public void setAbsentType(String absentType) {
		this.absentType = absentType;
	}

	public Double getProportion() {
		return proportion;
	}

	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}

	public Double getShouldDays() {
		return shouldDays;
	}

	public void setShouldDays(Double shouldDays) {
		this.shouldDays = shouldDays;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
