package io.renren.modules.poster.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 海报管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterPostersExcel {
    @ExcelProperty(value = "海报ID")
    private Integer id;
    @ExcelProperty(value = "所在学校ID")
    private String schoolId;
    @ExcelProperty(value = "海报标题")
    private String title;
    @ExcelProperty(value = "海报所有者ID")
    private String ownerUid;
    @ExcelProperty(value = "摘下海报者ID")
    private String pickerUid;
    @ExcelProperty(value = "海报内容")
    private String content;
    @ExcelProperty(value = "是否已收到奖励")
    private Integer isReceived;
    @ExcelProperty(value = "悬赏等级")
    private Integer bountyLevel;
    @ExcelProperty(value = "发布时间")
    private Long postTime;
    @ExcelProperty(value = "提交审核时间")
    private Long submitTime;
    @ExcelProperty(value = "硬币报酬")
    private Integer coinsRemuneration;
    @ExcelProperty(value = "经验报酬")
    private Integer expRemuneration;
    @ExcelProperty(value = "是否为官方发布")
    private Integer isOfficial;
    @ExcelProperty(value = "是否已被摘下")
    private Integer isPicked;
    @ExcelProperty(value = "是否已提交审核")
    private Integer isSubmitted;

}