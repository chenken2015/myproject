package org.myproject.dao;

import org.myproject.entity.AppTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppTestEntityRepository extends JpaRepository<AppTestEntity,Long>{
	
	
	
}
