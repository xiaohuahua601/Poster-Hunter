package io.renren.modules.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@Schema(name = "用户管理")
public class PosterUsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@SchemaProperty(name = "用户ID")
	private String id;

	@SchemaProperty(name = "用户身份")
	private String identity;

	@SchemaProperty(name = "手机号")
	private String mobilePhoneNumber;

	@SchemaProperty(name = "用户昵称")
	private String nickname;

	@SchemaProperty(name = "密码")
	private String password;

	@SchemaProperty(name = "是否为管理员")
	private Integer isAdmin;

	@SchemaProperty(name = "是否在线")
	private Integer isOnline;

	@SchemaProperty(name = "所在学校ID")
	private String schoolId;


}
