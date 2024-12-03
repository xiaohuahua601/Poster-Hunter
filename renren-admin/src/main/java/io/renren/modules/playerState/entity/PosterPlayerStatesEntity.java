package io.renren.modules.playerState.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 玩家状态管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_player_states")
public class PosterPlayerStatesEntity {

    /**
     * 用户ID
     */
	private String id;
    /**
     * 硬币数量
     */
	private Integer coins;
    /**
     * 猎人等级
     */
	private Integer hunterLevel;
    /**
     * 猎人经验
     */
	private Integer hunterExp;
    /**
     * 完成的海报数量
     */
	private Integer posterCompleted;
    /**
     * 德
     */
	private Integer morality;
    /**
     * 智
     */
	private Integer intelligence;
    /**
     * 体
     */
	private Integer physical;
    /**
     * 美
     */
	private Integer aesthetic;
    /**
     * 劳
     */
	private Integer labor;
    /**
     * 上
     */
	private Integer up;
    /**
     * 下
     */
	private Integer down;
    /**
     * 左
     */
	private Integer moveLeft;
    /**
     * 右
     */
	private Integer moveRight;
    /**
     * 交互
     */
	private Integer interact;
    /**
     * 朋友ID列表
     */
	private String friendsUid;
    /**
     * 音量
     */
	private Float volume;
    /**
     * 已摘下的海报ID列表
     */
	private Integer pickedPostersId;
}