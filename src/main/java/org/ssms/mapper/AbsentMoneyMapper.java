package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.AbsentMoney;
import org.ssms.mapper.result.HrAbsentInfo;
import org.ssms.web.result.Absence;

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
    List<HrAbsentInfo> getHrAbsentInfo(Pagination pagination, @Param("searchCondition") String searchCondition);
}