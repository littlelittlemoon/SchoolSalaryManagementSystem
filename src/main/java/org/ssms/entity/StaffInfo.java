package org.ssms.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Data
@TableName("t_staff_info")
public class StaffInfo extends Model<StaffInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("staff_id")
	private String staffId;
    /**
     * 登录密码
     */
	@TableField("staff_pass_word")
	private String staffPassWord;
    /**
     * 员工姓名
     */
	@TableField("staff_name")
	private String staffName;
    /**
     * 员工性别
     */
	@TableField("staff_sex")
	private String staffSex;
    /**
     * 身份证号
     */
	@TableField("staff_identity_num")
	private String staffIdentityNum;
    /**
     * 所属部门编号
     */
	@TableField("department_id")
	private String departmentId;
    /**
     * 职称编号
     */
	@TableField("title_id")
	private String titleId;
    /**
     * 职务编号
     */
	@TableField("duty_id")
	private String dutyId;
    /**
     * 入职时间
     */
	@TableField("staff_entry_time")
	private String staffEntryTime;
    /**
     * 银行卡账号
     */
	@TableField("staff_bank_acount")
	private String staffBankAcount;
    /**
     * 电话号码&登录账号
     */
	@TableField("staff_tel")
	private String staffTel;
    /**
     * 角色编号
     */
	@TableField("role_id")
	private String roleId;

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

}
