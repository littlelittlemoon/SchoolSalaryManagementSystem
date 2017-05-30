package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.Insurance;

/**
 * <p>
 * 五险一金表 Mapper 接口
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface InsuranceMapper extends BaseMapper<Insurance> {
    void sendToBank(@Param("departmentId") String departmentId, @Param("oriState") String oriState,
                    @Param("toState") String toState, @Param("condition") String condition);
}