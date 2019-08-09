package com.cnipr.open.ms.gateway.web;

import com.cnipr.open.ms.gateway.utils.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bi Yunfei
 * @date 2019/8/8 14:18
 */
@RestController
public class IndexController {
	@GetMapping("/index")
	@DoneTime(param = "IndexController")
	public String index(){
		System.out.println("方法执行");
		return "hello world";
	}

	@GetMapping("/index2")
	public String index2(){
		System.out.println("方法2执行");
		return "hello world";
	}
}
