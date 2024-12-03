package io.renren.modules.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.question.dao.PosterQuestionsDao;
import io.renren.modules.question.dto.PosterQuestionsDTO;
import io.renren.modules.question.entity.PosterQuestionsEntity;
import io.renren.modules.question.service.PosterQuestionsService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterQuestionsServiceImpl extends CrudServiceImpl<PosterQuestionsDao, PosterQuestionsEntity, PosterQuestionsDTO> implements PosterQuestionsService {

    @Override
    public QueryWrapper<PosterQuestionsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterQuestionsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}