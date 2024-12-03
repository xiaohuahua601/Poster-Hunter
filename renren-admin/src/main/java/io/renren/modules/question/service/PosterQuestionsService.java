package io.renren.modules.question.service;

import io.renren.common.service.CrudService;
import io.renren.modules.question.dto.PosterQuestionsDTO;
import io.renren.modules.question.entity.PosterQuestionsEntity;

/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
public interface PosterQuestionsService extends CrudService<PosterQuestionsEntity, PosterQuestionsDTO> {

}