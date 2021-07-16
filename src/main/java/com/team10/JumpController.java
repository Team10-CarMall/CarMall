package com.team10;

import com.team10.util.ReturnDataUtil;
import com.team10.util.TokenUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于页面的跳转....
 * @Author LINZHIPIN
 * @CreateTime 2021/07/13/00013 16:23:20
 */
@Controller
public class JumpController {

	//跳转到主页
	@RequestMapping("/")
	public String index1() {
		return "index";
	}

	//跳转到类目聚合页
	@RequestMapping("/leimujuhe")
	public String leimujuhe() {
		return "leimujuhe";
	}

	//跳转到商品详情页
	@RequestMapping("/goodsDetail")
	public String goodsDetail() {
		return "goodsDetail";
	}

	//跳转到登录页
	@RequestMapping("/loginTest")
	public String login() {
		return "login";
	}

	//跳转到我的页面前进行确认
	@RequestMapping("/myCheck")
	@ResponseBody
	public Object myCheck() {
		Boolean flag = TokenUtils.checkToken();
		if(!flag) {
			return ReturnDataUtil.getReturnMap(888, "用户未登录",null);
		} else {
			return ReturnDataUtil.getReturnMap(1000, "操作成功", null);
		}
	}

	//跳转到我的页面
	@RequestMapping("/my")
	public String my() {
		return "my";
	}

	//跳转到新增我的地址页
	@RequestMapping("/myAddr-add")
	public String myAddradd() {
		return "myAddr-add";
	}

	//跳转到我的地址编辑页
	@RequestMapping("/myAddr-edit")
	public String myAddredit() {
		return "myAddr-edit";
	}

	//跳转到我的地址页
	@RequestMapping("/myAddress")
	public String myAddress() {
		return "myAddress";
	}

	//跳转到我的订单页
	@RequestMapping("/myOrder")
	public String myOrder() {
		return "myOrder";
	}

	//跳转到下单详情页
	@RequestMapping("/placeOrderDetail")
	public String placeOrderDetail() {
		return "placeOrderDetail";
	}
}
