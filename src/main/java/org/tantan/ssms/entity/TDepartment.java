package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 部门信息表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_department")
public class TDepartment extends Model<TDepartment> {

    private static final long serialVersionUID = 1L;

	/**
	 * 部门编号
	 */
	@TableId(value = "Dep_Id")
	@TableField(value="Dep_Id")
	private String depId;

	/**
	 * 部门名称
	 */
	@TableField(value="Dep_Name")
	private String depName;



	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
