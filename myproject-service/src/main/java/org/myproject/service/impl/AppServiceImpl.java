package org.myproject.service.impl;

import org.myproject.dao.AppTestEntityRepository;
import org.myproject.entity.AppTestEntity;
import org.myproject.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppServiceImpl implements AppService{

	@Autowired
	private AppTestEntityRepository appTestEntityRepository;

	@Override
	public void saveAppTest(AppTestEntity appTestEntity) {
		appTestEntityRepository.save(appTestEntity);
	}
	
}
