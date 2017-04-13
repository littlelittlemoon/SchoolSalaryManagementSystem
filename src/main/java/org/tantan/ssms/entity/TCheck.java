package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 考勤信息表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_check")
public class TCheck extends Model<TCheck> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(value = "Sta_Id")
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 缺勤原因
	 */
	@TableField(value="Che_Reason")
	private String cheReason;

	/**
	 * 考勤时间
	 */
	@TableField(value="Che_Time")
	private Date cheTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public String getCheReason() {
		return cheReason;
	}

	public void setCheReason(String cheReason) {
		this.cheReason = cheReason;
	}

	public Date getCheTime() {
		return cheTime;
	}

	public void setCheTime(Date cheTime) {
		this.cheTime = cheTime;
	}

	@Override
	protected Serializable pkVal() {
		return staId;
	}
}
