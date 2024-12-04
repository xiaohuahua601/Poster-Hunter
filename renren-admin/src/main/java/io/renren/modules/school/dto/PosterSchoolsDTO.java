package io.renren.modules.school.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 学校管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "学校管理")
public class PosterSchoolsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "学校ID")
	private String id;

	@SchemaProperty(name = "学校名称")
	private String unvname;

}
