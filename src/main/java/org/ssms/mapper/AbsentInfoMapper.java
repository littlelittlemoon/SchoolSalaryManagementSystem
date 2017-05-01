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
    List<AbsentInfoCheck> getAbsentInfoCheck(Pagination pagination, String staffId);
}