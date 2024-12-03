package io.renren.modules.playerState.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.playerState.entity.PosterPlayerStatesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 玩家状态管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterPlayerStatesDao extends BaseDao<PosterPlayerStatesEntity> {
	
}