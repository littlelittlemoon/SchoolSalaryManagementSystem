package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职称信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_title")
public class Title extends Model<Title> {

    private static final long serialVersionUID = 1L;

    /**
     * 职称编号
     */
    @TableId("title_id")
	private String titleId;
    /**
     * 职称名称
     */
	@TableField("title_name")
	private String titleName;
    /**
     * 职称工资
     */
	@TableField("title_salary")
	private Float titleSalary;
    /**
     * 基本工资
     */
	@TableField("title_basesalary")
	private Float titleBasesalary;


	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Float getTitleSalary() {
		return titleSalary;
	}

	public void setTitleSalary(Float titleSalary) {
		this.titleSalary = titleSalary;
	}

	public Float getTitleBasesalary() {
		return titleBasesalary;
	}

	public void setTitleBasesalary(Float titleBasesalary) {
		this.titleBasesalary = titleBasesalary;
	}

	@Override
	protected Serializable pkVal() {
		return this.titleId;
	}

}
