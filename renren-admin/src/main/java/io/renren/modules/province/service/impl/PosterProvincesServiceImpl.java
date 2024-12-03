package io.renren.modules.province.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.province.dao.PosterProvincesDao;
import io.renren.modules.province.dto.PosterProvincesDTO;
import io.renren.modules.province.entity.PosterProvincesEntity;
import io.renren.modules.province.service.PosterProvincesService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 省份管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterProvincesServiceImpl extends CrudServiceImpl<PosterProvincesDao, PosterProvincesEntity, PosterProvincesDTO> implements PosterProvincesService {

    @Override
    public QueryWrapper<PosterProvincesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterProvincesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}