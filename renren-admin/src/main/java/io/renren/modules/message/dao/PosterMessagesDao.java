package io.renren.modules.message.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.message.entity.PosterMessagesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterMessagesDao extends BaseDao<PosterMessagesEntity> {
	
}