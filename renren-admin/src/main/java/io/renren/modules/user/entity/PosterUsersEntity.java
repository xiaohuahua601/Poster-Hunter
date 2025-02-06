package io.renren.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_users")
public class PosterUsersEntity {

    /**
     * 用户ID
     */
	private String id;
    /**
     * 用户身份   student：学生   faculty：教师    visitor：访客
     */
	private String identity;
    /**
     * 手机号
     */
	private String mobilePhoneNumber;
    /**
     * 用户昵称
     */
	private String nickname;
    /**
     * 密码
     */
	private String password;
    /**
     * 是否为管理员
     */
	private Integer isAdmin;
    /**
     * 是否在线
     */
	private Integer isOnline;
    /**
     * 所在学校ID
     */
	private String schoolId;
}