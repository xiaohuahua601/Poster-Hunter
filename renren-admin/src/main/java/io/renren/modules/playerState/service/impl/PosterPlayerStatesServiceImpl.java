package io.renren.modules.playerState.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.playerState.dao.PosterPlayerStatesDao;
import io.renren.modules.playerState.dto.PosterPlayerStatesDTO;
import io.renren.modules.playerState.entity.PosterPlayerStatesEntity;
import io.renren.modules.playerState.service.PosterPlayerStatesService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 玩家状态管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Service
public class PosterPlayerStatesServiceImpl extends CrudServiceImpl<PosterPlayerStatesDao, PosterPlayerStatesEntity, PosterPlayerStatesDTO> implements PosterPlayerStatesService {

    @Override
    public QueryWrapper<PosterPlayerStatesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PosterPlayerStatesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}