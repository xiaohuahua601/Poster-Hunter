package io.renren.modules.playerState.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 玩家状态管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "玩家状态管理")
public class PosterPlayerStatesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "用户ID")
	private String id;

	@SchemaProperty(name = "硬币数量")
	private Integer coins;

	@SchemaProperty(name = "猎人等级")
	private Integer hunterLevel;

	@SchemaProperty(name = "猎人经验")
	private Integer hunterExp;

	@SchemaProperty(name = "完成的海报数量")
	private Integer posterCompleted;

	@SchemaProperty(name = "德")
	private Integer morality;

	@SchemaProperty(name = "智")
	private Integer intelligence;

	@SchemaProperty(name = "体")
	private Integer physical;

	@SchemaProperty(name = "美")
	private Integer aesthetic;

	@SchemaProperty(name = "劳")
	private Integer labor;

	@SchemaProperty(name = "上")
	private Integer up;

	@SchemaProperty(name = "下")
	private Integer down;

	@SchemaProperty(name = "左")
	private Integer moveLeft;

	@SchemaProperty(name = "右")
	private Integer moveRight;

	@SchemaProperty(name = "交互")
	private Integer interact;

	@SchemaProperty(name = "朋友ID列表")
	private String friendsUid;

	@SchemaProperty(name = "音量")
	private Float volume;

	@SchemaProperty(name = "已摘下的海报ID列表")
	private Integer pickedPostersId;


}
