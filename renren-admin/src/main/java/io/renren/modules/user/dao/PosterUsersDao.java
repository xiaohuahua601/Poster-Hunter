package io.renren.modules.user.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.user.entity.PosterUsersEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterUsersDao extends BaseDao<PosterUsersEntity> {
	
}