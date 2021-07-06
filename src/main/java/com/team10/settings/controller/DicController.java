package com.team10.settings.controller;

import com.team10.settings.model.DicType;
import com.team10.settings.service.DicService;
import com.team10.util.ReturnDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07 3:29:53
 */
@RestController
public class DicController {
	@Autowired
	private DicService dicService;

	@RequestMapping(value = "/settings/getGoodsType", method = RequestMethod.GET)
	public Object getGoodsType() {
		List<DicType> list = dicService.getGoodsType();
		return ReturnDataUtil.getReturnModel("查询数据成功", list);
	}
}
