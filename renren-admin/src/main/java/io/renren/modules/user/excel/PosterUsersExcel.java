package io.renren.modules.user.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 用户管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterUsersExcel {
    @ExcelProperty(value = "用户ID")
    private String id;
    @ExcelProperty(value = "用户身份")
    private String identity;
    @ExcelProperty(value = "手机号")
    private String mobilePhoneNumber;
    @ExcelProperty(value = "用户昵称")
    private String nickname;
    @ExcelProperty(value = "密码")
    private String password;
    @ExcelProperty(value = "是否为管理员")
    private Integer isAdmin;
    @ExcelProperty(value = "是否在线")
    private Integer isOnline;
    @ExcelProperty(value = "所在学校ID")
    private String schoolId;

}