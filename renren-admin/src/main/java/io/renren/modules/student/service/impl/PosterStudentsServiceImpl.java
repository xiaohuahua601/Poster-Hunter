package io.renren.modules.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.student.dao.PosterStudentsDao;
import io.renren.modules.student.dto.PosterStudentsDTO;
import io.renren.modules.student.entity.PosterStudentsEntity;
import io.renren.modules.student.service.PosterStudentsService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 学生信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterStudentsServiceImpl extends CrudServiceImpl<PosterStudentsDao, PosterStudentsEntity, PosterStudentsDTO> implements PosterStudentsService {

    @Override
    public QueryWrapper<PosterStudentsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterStudentsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}