package com.team10.settings.controller;

import com.team10.annotation.EmptyCheck;
import com.team10.exception.AccessException;
import com.team10.settings.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07 3:29:53
 */
@RestController
public class DicController {
	@Autowired
	private DicService dicService;

	//获得商品的一级分类列表
	@RequestMapping(value = "/settings/getGoodsType", method = RequestMethod.GET)
	public Object getGoodsType() {
		 return dicService.getGoodsType(true);
	}

	//根据商品的一级分类的id获取二级分类
	@RequestMapping(value = "/settings/getGoodsSubType", method = RequestMethod.GET)
	@EmptyCheck
	public Object getGoodsSubType(String id) throws AccessException {
		Map<String, Object> map = dicService.getGoodsSubType(id);
		return map;
	}
}
