package io.renren.modules.poster.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 海报管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "海报管理")
public class PosterPostersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "海报ID")
	private Integer id;

	@SchemaProperty(name = "所在学校ID")
	private String schoolId;

	@SchemaProperty(name = "海报标题")
	private String title;

	@SchemaProperty(name = "海报所有者ID")
	private String ownerUid;

	@SchemaProperty(name = "摘下海报者ID")
	private String pickerUid;

	@SchemaProperty(name = "海报内容")
	private String content;

	@SchemaProperty(name = "是否已收到奖励")
	private Integer isReceived;

	@SchemaProperty(name = "悬赏等级")
	private Integer bountyLevel;

	@SchemaProperty(name = "发布时间")
	private Long postTime;

	@SchemaProperty(name = "提交审核时间")
	private Long submitTime;

	@SchemaProperty(name = "硬币报酬")
	private Integer coinsRemuneration;

	@SchemaProperty(name = "经验报酬")
	private Integer expRemuneration;

	@SchemaProperty(name = "是否为官方发布")
	private Integer isOfficial;

	@SchemaProperty(name = "是否已被摘下")
	private Integer isPicked;

	@SchemaProperty(name = "是否已提交审核")
	private Integer isSubmitted;


}
