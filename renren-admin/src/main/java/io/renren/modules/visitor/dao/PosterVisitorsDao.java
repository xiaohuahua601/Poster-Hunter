package io.renren.modules.visitor.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.visitor.entity.PosterVisitorsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 访客管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterVisitorsDao extends BaseDao<PosterVisitorsEntity> {
	
}