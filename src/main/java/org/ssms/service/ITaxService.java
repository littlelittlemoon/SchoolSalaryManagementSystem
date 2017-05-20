package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.Tax;
import org.ssms.web.param.TaxQueryParam;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 纳税款表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface ITaxService extends IService<Tax> {
	BaseResponse countTaxMoney(List<String> staffIds);

	BaseResponse taxMoneyResult(TaxQueryParam param);
}
