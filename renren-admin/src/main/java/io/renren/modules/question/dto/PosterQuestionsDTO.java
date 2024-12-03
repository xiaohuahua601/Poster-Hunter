package io.renren.modules.question.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "存储问题及其选项和答案")
public class PosterQuestionsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "问题ID")
	private Integer id;

	@SchemaProperty(name = "海报ID")
	private Integer posterId;

	@SchemaProperty(name = "问题内容")
	private String questionContent;

	@SchemaProperty(name = "问题选项")
	private String choices;

	@SchemaProperty(name = "正确答案")
	private String answer;


}
