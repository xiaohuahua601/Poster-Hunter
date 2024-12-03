package io.renren.modules.question.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_questions")
public class PosterQuestionsEntity {

    /**
     * 问题ID
     */
	private Integer id;
    /**
     * 海报ID
     */
	private Integer posterId;
    /**
     * 问题内容
     */
	private String questionContent;
    /**
     * 问题选项
     */
	private String choices;
    /**
     * 正确答案
     */
	private String answer;
}