package org.ssms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@TableName("t_department")
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId("department_id")
	private String departmentId;
    /**
     * 部门名称
     */
	@TableField("department_name")
	private String departmentName;


	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	protected Serializable pkVal() {
		return this.departmentId;
	}

}
