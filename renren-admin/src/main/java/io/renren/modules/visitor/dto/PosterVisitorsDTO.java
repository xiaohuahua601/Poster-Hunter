package io.renren.modules.visitor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 访客管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "访客管理")
public class PosterVisitorsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "访客ID")
	private String id;


}
