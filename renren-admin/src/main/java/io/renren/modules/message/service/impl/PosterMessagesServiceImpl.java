package io.renren.modules.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.message.dao.PosterMessagesDao;
import io.renren.modules.message.dto.PosterMessagesDTO;
import io.renren.modules.message.entity.PosterMessagesEntity;
import io.renren.modules.message.service.PosterMessagesService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 消息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterMessagesServiceImpl extends CrudServiceImpl<PosterMessagesDao, PosterMessagesEntity, PosterMessagesDTO> implements PosterMessagesService {

    @Override
    public QueryWrapper<PosterMessagesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterMessagesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}