package org.myproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.myproject.entity.AppTestEntity;
import org.myproject.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;


@RefreshScope
@RestController
@RequestMapping(value = "/app")
@Api("AppController相关的api")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@Value("${test}")
	private String test;
	
	@Autowired
    private Environment environment;
	
	@GetMapping("/test")
	public String test(){
		return "from value:"+test+"\n"+"from environment:"+environment.getProperty("test");
	}
	
	@ApiOperation(value = "saveAppTest", notes = "saveAppTest")
	@PostMapping("/saveAppTest")
	public void saveAppTest(@RequestBody AppTestEntity appTestEntity){
		if(appTestEntity == null){
			throw new RuntimeException("appTestEntity不能为空");
		}
		if(appTestEntity.getId() == null){
			throw new RuntimeException("id不能为空");
		}
		if(StringUtils.isEmpty(appTestEntity.getName())){
			throw new RuntimeException("name不能为空");
		}
		appService.saveAppTest(appTestEntity);
	}
	
}
