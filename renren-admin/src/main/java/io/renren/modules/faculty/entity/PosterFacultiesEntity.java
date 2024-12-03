package io.renren.modules.faculty.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_faculties")
public class PosterFacultiesEntity {

    /**
     * 用户ID
     */
	private String id;
    /**
     * 教职工编号
     */
	private String facultyId;
}