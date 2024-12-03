package io.renren.modules.student.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 学生信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterStudentsExcel {
    @ExcelProperty(value = "用户ID")
    private String id;
    @ExcelProperty(value = "学号")
    private String studentId;
    @ExcelProperty(value = "家长ID")
    private String parentsUid;

}