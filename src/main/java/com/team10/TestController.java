package com.team10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/11/00011 9:34:25
 */
@Controller
public class TestController {
	@RequestMapping("/test")
	public String index() {
		return "test";
	}
}
