package io.renren.modules.faculty.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "教职工信息管理")
public class PosterFacultiesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "用户ID")
	private String id;

	@SchemaProperty(name = "教职工编号")
	private String facultyId;


}
