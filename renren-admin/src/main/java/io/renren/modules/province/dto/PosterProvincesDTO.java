package io.renren.modules.province.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 省份管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "省份管理")
public class PosterProvincesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "省份ID")
	private String id;

	@SchemaProperty(name = "省份名称")
	private String provname;

	@SchemaProperty(name = "学校ID")
	private String schoolId;

}
