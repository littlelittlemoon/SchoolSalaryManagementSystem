package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.Tax;

/**
 * <p>
 * 纳税款表 Mapper 接口
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface TaxMapper extends BaseMapper<Tax> {
    void sentToFs(String departmentId);

    void sendToBank(@Param("departmentId") String departmentId, @Param("oriState") String oriState,
                    @Param("toState") String toState, @Param("condition") String condition);
}