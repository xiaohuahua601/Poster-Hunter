package io.renren.modules.faculty.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterFacultiesExcel {
    @ExcelProperty(value = "用户ID")
    private String id;
    @ExcelProperty(value = "教职工编号")
    private String facultyId;

}