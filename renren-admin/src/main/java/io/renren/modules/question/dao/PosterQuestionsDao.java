package io.renren.modules.question.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.question.entity.PosterQuestionsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Mapper
public interface PosterQuestionsDao extends BaseDao<PosterQuestionsEntity> {
	
}