package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.ToBank;
import org.ssms.web.param.SalaryQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.SalaryDetail;

import java.util.List;

/**
 * <p>
 * 银行发放表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IToBankService extends IService<ToBank> {
	BaseResponse<List<SalaryDetail>> checkSalaryList(SalaryQueryParam param);

	BaseResponse sendToBank(SalaryQueryParam param);

	BaseResponse sendToDepartment(SalaryQueryParam param);

	BaseResponse historySalaryList(SalaryQueryParam param);
}
