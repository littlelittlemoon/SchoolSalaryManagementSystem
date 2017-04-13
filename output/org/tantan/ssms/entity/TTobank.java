package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 银行发放表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_tobank")
public class TTobank extends Model<TTobank> {

    private static final long serialVersionUID = 1L;

	/**
	 * 员工编号
	 */
	@TableId(type = IdType.AUTO)
	@TableField(value="Sta_Id")
	private String staId;

	/**
	 * 身份证号
	 */
	@TableField(value="Sta_IdentityNum")
	private String staIdentitynum;

	/**
	 * 银行卡账号
	 */
	@TableField(value="Sta_BankAcount")
	private String staBankacount;

	/**
	 * 全勤奖
	 */
	@TableField(value="Pr_FullBonus")
	private Float prFullbonus;

	/**
	 * 应发金额
	 */
	@TableField(value="TB_TatalMoney")
	private Float tbTatalmoney;

	/**
	 * 发放时间
	 */
	@TableField(value="TB_Time")
	private Date tbTime;



	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public String getStaIdentitynum() {
		return staIdentitynum;
	}

	public void setStaIdentitynum(String staIdentitynum) {
		this.staIdentitynum = staIdentitynum;
	}

	public String getStaBankacount() {
		return staBankacount;
	}

	public void setStaBankacount(String staBankacount) {
		this.staBankacount = staBankacount;
	}

	public Float getPrFullbonus() {
		return prFullbonus;
	}

	public void setPrFullbonus(Float prFullbonus) {
		this.prFullbonus = prFullbonus;
	}

	public Float getTbTatalmoney() {
		return tbTatalmoney;
	}

	public void setTbTatalmoney(Float tbTatalmoney) {
		this.tbTatalmoney = tbTatalmoney;
	}

	public Date getTbTime() {
		return tbTime;
	}

	public void setTbTime(Date tbTime) {
		this.tbTime = tbTime;
	}

}
