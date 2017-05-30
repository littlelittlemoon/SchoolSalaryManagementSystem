package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.AbsentInfo;
import org.ssms.mapper.result.AbsentInfoCheck;

import java.util.List;

/**
 * <p>
 * 考勤信息表 Mapper 接口
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface AbsentInfoMapper extends BaseMapper<AbsentInfo> {
    /**
     * 下面两个方法部门用
     */
    List<AbsentInfoCheck> getAbsentInfoCheck(Pagination pagination, @Param("staffId") String staffId,
                                             @Param("state") String state);

    List<String> getStaffAbsentInfoPage(Pagination pagination, @Param("staffId") String staffId, @Param("searchCondition") String searchCondition,
                                        @Param("id") String id, @Param("time") String time,@Param("state")String state);

    /**
     * 下面两个方法人事处用
     */
    List<String> getStaffAbsentInfoPageByDep(Pagination pagination, @Param("departmentId") String departmentId, @Param("searchCondition") String searchCondition);

    List<AbsentInfoCheck> getAbsentInfoCheckByDep(Pagination pagination, @Param("departmentId") String departmentId);

    void updateStatebatch(String staffId);
}