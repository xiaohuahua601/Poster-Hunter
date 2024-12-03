package io.renren.modules.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.school.dao.PosterSchoolsDao;
import io.renren.modules.school.dto.PosterSchoolsDTO;
import io.renren.modules.school.entity.PosterSchoolsEntity;
import io.renren.modules.school.service.PosterSchoolsService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 学校管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterSchoolsServiceImpl extends CrudServiceImpl<PosterSchoolsDao, PosterSchoolsEntity, PosterSchoolsDTO> implements PosterSchoolsService {

    @Override
    public QueryWrapper<PosterSchoolsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterSchoolsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}