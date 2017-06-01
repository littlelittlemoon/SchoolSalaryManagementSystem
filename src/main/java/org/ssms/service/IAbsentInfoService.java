package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.AbsentInfo;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.param.CheckAbsentInfoParam;
import org.ssms.web.result.AbsentInfoCheckResult;
import org.ssms.web.result.AbsentInfoResult;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.StaffAbsentInfoResult;

/**
 * <p>
 * 考勤信息表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IAbsentInfoService extends IService<AbsentInfo> {
    /**
     * 添加员工请加信息
     *
     * @param param
     * @return
     */
    BaseResponse addAbsentInfo(ApplyLeaveParam param);

    /**
     * 员工获取自己的请假记录
     *
     * @param param
     * @return
     */
    BaseResponse<AbsentInfoResult> getAbsentInfoList(AbsentInfoQueryParam param);

    /**
     * 管理员获取部门员工待审核请假记录
     *
     * @param param
     * @return
     */
    BaseResponse<AbsentInfoCheckResult> getAbsentInfoCheckList(AbsentInfoQueryParam param);

    /**
     * 审核通过或者打回
     *
     * @param param
     * @return
     */
    BaseResponse updateAbsentInfo(CheckAbsentInfoParam param);

    /**
     * 管理员获取已通过的员工请假记录
     *
     * @param param
     * @return
     */
    BaseResponse<StaffAbsentInfoResult> staffAbsentInfoList(AbsentInfoQueryParam param);

    BaseResponse sendAbsentInfoToHr(String staffId);

    BaseResponse<StaffAbsentInfoResult> hrCheckAbsentInfo(AbsentInfoQueryParam param);


    BaseResponse turnBackApplication(ApplyLeaveParam applyLeaveParam);
}
