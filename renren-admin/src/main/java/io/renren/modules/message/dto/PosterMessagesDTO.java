package io.renren.modules.message.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 消息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "消息管理")
public class PosterMessagesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "消息编号")
	private Integer id;

	@SchemaProperty(name = "所在学校ID")
	private String schoolId;

	@SchemaProperty(name = "消息标题")
	private String messageTitle;

	@SchemaProperty(name = "消息内容")
	private String messageContent;

	@SchemaProperty(name = "接收者ID")
	private String receiverUid;

	@SchemaProperty(name = "发送时间")
	private Long sendTime;

	@SchemaProperty(name = "是否为官方消息")
	private Integer isOfficial;

	@SchemaProperty(name = "是否已读")
	private Integer isRead;

	@SchemaProperty(name = "已接受者ID列表")
	private String receivedUid;


}
