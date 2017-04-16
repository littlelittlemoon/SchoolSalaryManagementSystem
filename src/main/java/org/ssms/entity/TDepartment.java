package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 部门信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Department")
public class TDepartment extends Model<TDepartment> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
	@TableId
	private String Dep_Id;
    /**
     * 部门名称
     */
	private String Dep_Name;


	public String getDep_Id() {
		return Dep_Id;
	}

	public void setDep_Id(String Dep_Id) {
		this.Dep_Id = Dep_Id;
	}

	public String getDep_Name() {
		return Dep_Name;
	}

	public void setDep_Name(String Dep_Name) {
		this.Dep_Name = Dep_Name;
	}

	@Override
	protected Serializable pkVal() {
		return this.Dep_Id;
	}

}
