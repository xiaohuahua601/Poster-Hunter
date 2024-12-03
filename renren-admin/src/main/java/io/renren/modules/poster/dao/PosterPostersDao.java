package io.renren.modules.poster.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.poster.entity.PosterPostersEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 海报管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterPostersDao extends BaseDao<PosterPostersEntity> {
	
}