package org.tantan.ssms.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 五险一金表
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@TableName("t_insurance")
public class TInsurance extends Model<TInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "Sta_Id")
    @TableField(value = "Sta_Id")
    private String staId;

    /**
     * 医疗保险
     */
    @TableField(value = "Ins_Medical")
    private Float insMedical;

    /**
     * 养老保险
     */
    @TableField(value = "Ins_Aged")
    private Float insAged;

    /**
     * 失业保险
     */
    @TableField(value = "Ins_Unemp")
    private Float insUnemp;

    /**
     * 公积金
     */
    @TableField(value = "Ins_Accu")
    private Float insAccu;

    /**
     * 五险一金总计
     */
    @TableField(value = "Ins_Total")
    private Float insTotal;

    /**
     * 考核年月
     */
    @TableField(value = "Ins_Time")
    private Date insTime;


    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId;
    }

    public Float getInsMedical() {
        return insMedical;
    }

    public void setInsMedical(Float insMedical) {
        this.insMedical = insMedical;
    }

    public Float getInsAged() {
        return insAged;
    }

    public void setInsAged(Float insAged) {
        this.insAged = insAged;
    }

    public Float getInsUnemp() {
        return insUnemp;
    }

    public void setInsUnemp(Float insUnemp) {
        this.insUnemp = insUnemp;
    }

    public Float getInsAccu() {
        return insAccu;
    }

    public void setInsAccu(Float insAccu) {
        this.insAccu = insAccu;
    }

    public Float getInsTotal() {
        return insTotal;
    }

    public void setInsTotal(Float insTotal) {
        this.insTotal = insTotal;
    }

    public Date getInsTime() {
        return insTime;
    }

    public void setInsTime(Date insTime) {
        this.insTime = insTime;
    }

    @Override
    protected Serializable pkVal() {
        return staId;
    }
}
