package io.renren.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.user.dao.PosterUsersDao;
import io.renren.modules.user.dto.PosterUsersDTO;
import io.renren.modules.user.entity.PosterUsersEntity;
import io.renren.modules.user.service.PosterUsersService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterUsersServiceImpl extends CrudServiceImpl<PosterUsersDao, PosterUsersEntity, PosterUsersDTO> implements PosterUsersService {

    @Override
    public QueryWrapper<PosterUsersEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterUsersEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}