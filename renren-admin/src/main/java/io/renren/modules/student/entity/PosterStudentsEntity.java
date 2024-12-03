package io.renren.modules.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 学生信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
@TableName("poster_students")
public class PosterStudentsEntity {

    /**
     * 用户ID
     */
	private String id;
    /**
     * 学号
     */
	private String studentId;
    /**
     * 家长ID
     */
	private String parentsUid;
}