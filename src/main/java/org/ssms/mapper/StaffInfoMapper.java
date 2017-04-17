package org.ssms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ssms.entity.StaffInfo;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.web.param.StaffQueryParam;

import java.util.List;

/**
 * <p>
 * 员工信息表 Mapper 接口
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface StaffInfoMapper extends BaseMapper<StaffInfo> {
    List<StaffInfoView> selectStaffView(@Param("param") StaffQueryParam param);
}