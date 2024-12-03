package io.renren.modules.student.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.student.entity.PosterStudentsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterStudentsDao extends BaseDao<PosterStudentsEntity> {
	
}