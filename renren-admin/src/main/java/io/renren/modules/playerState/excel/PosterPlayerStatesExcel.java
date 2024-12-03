package io.renren.modules.playerState.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 玩家状态管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@Data
public class PosterPlayerStatesExcel {
    @ExcelProperty(value = "用户ID")
    private String id;
    @ExcelProperty(value = "硬币数量")
    private Integer coins;
    @ExcelProperty(value = "猎人等级")
    private Integer hunterLevel;
    @ExcelProperty(value = "猎人经验")
    private Integer hunterExp;
    @ExcelProperty(value = "完成的海报数量")
    private Integer posterCompleted;
    @ExcelProperty(value = "德")
    private Integer morality;
    @ExcelProperty(value = "智")
    private Integer intelligence;
    @ExcelProperty(value = "体")
    private Integer physical;
    @ExcelProperty(value = "美")
    private Integer aesthetic;
    @ExcelProperty(value = "劳")
    private Integer labor;
    @ExcelProperty(value = "上")
    private Integer up;
    @ExcelProperty(value = "下")
    private Integer down;
    @ExcelProperty(value = "左")
    private Integer moveLeft;
    @ExcelProperty(value = "右")
    private Integer moveRight;
    @ExcelProperty(value = "交互")
    private Integer interact;
    @ExcelProperty(value = "朋友ID列表")
    private String friendsUid;
    @ExcelProperty(value = "音量")
    private Float volume;
    @ExcelProperty(value = "已摘下的海报ID列表")
    private Integer pickedPostersId;

}