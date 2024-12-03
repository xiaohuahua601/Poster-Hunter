package io.renren.modules.visitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.visitor.dao.PosterVisitorsDao;
import io.renren.modules.visitor.dto.PosterVisitorsDTO;
import io.renren.modules.visitor.entity.PosterVisitorsEntity;
import io.renren.modules.visitor.service.PosterVisitorsService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 访客管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterVisitorsServiceImpl extends CrudServiceImpl<PosterVisitorsDao, PosterVisitorsEntity, PosterVisitorsDTO> implements PosterVisitorsService {

    @Override
    public QueryWrapper<PosterVisitorsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterVisitorsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}