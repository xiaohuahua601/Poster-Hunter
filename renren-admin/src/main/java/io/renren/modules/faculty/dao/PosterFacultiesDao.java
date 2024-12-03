package io.renren.modules.faculty.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.faculty.entity.PosterFacultiesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterFacultiesDao extends BaseDao<PosterFacultiesEntity> {
	
}