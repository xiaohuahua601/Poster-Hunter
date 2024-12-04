package io.renren.modules.school.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 学校管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_schools")
public class PosterSchoolsEntity {

    /**
     * 学校ID
     */
	private String id;
    /**
     * 学校名称
     */
    private String unvname;
}