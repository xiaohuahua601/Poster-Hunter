package io.renren.modules.message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 消息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_messages")
public class PosterMessagesEntity {

    /**
     * 消息编号
     */
	private Integer id;
    /**
     * 所在学校ID
     */
	private String schoolId;
    /**
     * 消息标题
     */
	private String messageTitle;
    /**
     * 消息内容
     */
	private String messageContent;
    /**
     * 接收者ID
     */
	private String receiverUid;
    /**
     * 发送时间
     */
	private Long sendTime;
    /**
     * 是否为官方消息
     */
	private Integer isOfficial;
    /**
     * 是否已读
     */
	private Integer isRead;
    /**
     * 已接受者ID列表
     */
	private String receivedUid;
}