package io.renren.modules.province.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 省份管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_provinces")
public class PosterProvincesEntity {

    /**
     * 省份ID
     */
	private String id;
    /**
     * 学校ID
     */
	private String schoolId;
}