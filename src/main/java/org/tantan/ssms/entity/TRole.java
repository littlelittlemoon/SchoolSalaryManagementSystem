package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_role")
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;

	/**
	 * 角色编号
	 */
	@TableId(value = "R_Id")
	@TableField(value="R_Id")
	private String rId;

	/**
	 * 角色名称
	 */
	@TableField(value="R_Name")
	private String rName;



	public String getRId() {
		return rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getRName() {
		return rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	@Override
	protected Serializable pkVal() {
		return rId;
	}
}
