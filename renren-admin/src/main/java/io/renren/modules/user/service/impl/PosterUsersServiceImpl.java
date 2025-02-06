package io.renren.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.security.user.SecurityUser;
import io.renren.modules.security.user.UserDetail;
import io.renren.modules.sys.enums.SuperAdminEnum;
import io.renren.modules.user.dao.PosterUsersDao;
import io.renren.modules.user.dto.PosterUsersDTO;
import io.renren.modules.user.entity.PosterUsersEntity;
import io.renren.modules.user.service.PosterUsersService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @Override
    public PageData<PosterUsersDTO> page(Map<String, Object> params) {
        // 打印 params 内容
//        log.debug("Params: " + params.toString());

        // 转换成模糊匹配
        paramsToLike(params, "nickname");

        // 分页
        IPage<PosterUsersEntity> page = getPage(params);

        // 查询
        List<PosterUsersEntity> list = baseDao.getList(params);

        return getPageData(list, page.getTotal(), PosterUsersDTO.class);
    }

}