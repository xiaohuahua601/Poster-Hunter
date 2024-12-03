package io.renren.modules.message.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 消息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterMessagesExcel {
    @ExcelProperty(value = "消息编号")
    private Integer id;
    @ExcelProperty(value = "所在学校ID")
    private String schoolId;
    @ExcelProperty(value = "消息标题")
    private String messageTitle;
    @ExcelProperty(value = "消息内容")
    private String messageContent;
    @ExcelProperty(value = "接收者ID")
    private String receiverUid;
    @ExcelProperty(value = "发送时间")
    private Long sendTime;
    @ExcelProperty(value = "是否为官方消息")
    private Integer isOfficial;
    @ExcelProperty(value = "是否已读")
    private Integer isRead;
    @ExcelProperty(value = "已接受者ID列表")
    private String receivedUid;

}