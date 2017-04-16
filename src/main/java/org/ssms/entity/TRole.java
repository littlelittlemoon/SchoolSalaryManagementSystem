package org.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 角色表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@TableName("T_Role")
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
	@TableId
	private String R_Id;
    /**
     * 角色名称
     */
	private String R_Name;


	public String getR_Id() {
		return R_Id;
	}

	public void setR_Id(String R_Id) {
		this.R_Id = R_Id;
	}

	public String getR_Name() {
		return R_Name;
	}

	public void setR_Name(String R_Name) {
		this.R_Name = R_Name;
	}

	@Override
	protected Serializable pkVal() {
		return this.R_Id;
	}

}
