package io.renren.modules.question.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 存储问题及其选项和答案
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterQuestionsExcel {
    @ExcelProperty(value = "问题ID")
    private Integer id;
    @ExcelProperty(value = "海报ID")
    private Integer posterId;
    @ExcelProperty(value = "问题内容")
    private String questionContent;
    @ExcelProperty(value = "问题选项")
    private String choices;
    @ExcelProperty(value = "正确答案")
    private String answer;

}