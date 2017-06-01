package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.AbsentMoney;
import org.ssms.mapper.result.HrAbsentInfo;
import org.ssms.mapper.result.HrAbsentMoney;

import java.util.List;

/**
 * <p>
 * 考勤扣款表 Mapper 接口
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface AbsentMoneyMapper extends BaseMapper<AbsentMoney> {
    /**
     * 分页查询未计算的列表
     *
     * @param pagination
     * @param searchCondition
     * @return
     */
    /**
     * 人事部门获取待计算缺勤金的员工缺勤信息
     * @param pagination
     * @param searchCondition
     * @return
     */
    List<HrAbsentInfo> getHrAbsentInfo(Pagination pagination, @Param("searchCondition") String searchCondition);

    /**
     * 人事部门获取计算后的缺勤扣款
     * @param pagination
     * @param searchCondition
     * @param departmentId
     * @param absentMoneyState
     * @return
     */
    List<HrAbsentMoney> getHrAbsentMoney(Pagination pagination, @Param("searchCondition") String searchCondition,
                                         @Param("departmentId") String departmentId, @Param("absentMoneyState") String absentMoneyState);

    List<HrAbsentMoney> getAbsentMoney(Pagination pagination, @Param("departmentId") String departmentId,
                                       @Param("searchCondition") String searchCondition,
                                       @Param("time") String time, @Param("code") Integer code);

    //
    void sendToBank(@Param("departmentId") String departmentId, @Param("oriState") String oriState,
                    @Param("toState") String toState, @Param("condition") String condition);
}