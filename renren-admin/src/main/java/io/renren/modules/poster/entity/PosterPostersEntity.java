package io.renren.modules.poster.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 海报管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_posters")
public class PosterPostersEntity {

    /**
     * 海报ID
     */
	private Integer id;
    /**
     * 所在学校ID
     */
	private String schoolId;
    /**
     * 海报标题
     */
	private String title;
    /**
     * 海报所有者ID
     */
	private String ownerUid;
    /**
     * 摘下海报者ID
     */
	private String pickerUid;
    /**
     * 海报内容
     */
	private String content;
    /**
     * 是否已收到奖励
     */
	private Integer isReceived;
    /**
     * 悬赏等级
     */
	private Integer bountyLevel;
    /**
     * 发布时间
     */
	private Long postTime;
    /**
     * 提交审核时间
     */
	private Long submitTime;
    /**
     * 硬币报酬
     */
	private Integer coinsRemuneration;
    /**
     * 经验报酬
     */
	private Integer expRemuneration;
    /**
     * 是否为官方发布
     */
	private Integer isOfficial;
    /**
     * 是否已被摘下
     */
	private Integer isPicked;
    /**
     * 是否已提交审核
     */
	private Integer isSubmitted;
}