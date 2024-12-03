package io.renren.modules.visitor.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 访客管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_visitors")
public class PosterVisitorsEntity {

    /**
     * 访客ID
     */
	private String id;
}