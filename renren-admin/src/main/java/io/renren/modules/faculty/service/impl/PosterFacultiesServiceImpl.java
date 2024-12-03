package io.renren.modules.faculty.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.faculty.dao.PosterFacultiesDao;
import io.renren.modules.faculty.dto.PosterFacultiesDTO;
import io.renren.modules.faculty.entity.PosterFacultiesEntity;
import io.renren.modules.faculty.service.PosterFacultiesService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterFacultiesServiceImpl extends CrudServiceImpl<PosterFacultiesDao, PosterFacultiesEntity, PosterFacultiesDTO> implements PosterFacultiesService {

    @Override
    public QueryWrapper<PosterFacultiesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterFacultiesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}