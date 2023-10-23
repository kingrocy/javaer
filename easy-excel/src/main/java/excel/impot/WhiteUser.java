package excel.impot;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 *
 * Created on 2021-10-14
 */
@Data
public class WhiteUser {


    @ExcelProperty(index = 1)
    @JSONField(ordinal = 1)
    private Long authorId;

    @ExcelProperty(index = 2)
    @JSONField(serialize = false)
    private String authorName;

    @ExcelProperty(index = 3)
    @JSONField(serialize = false)
    private String livePlanStartTimeStr;

    @ExcelProperty(index = 4)
    @JSONField(serialize = false)
    private String livePlanEndTimeStr;

    /**
     * 提报gmv 单位分
     */
    @ExcelProperty(index = 5)
    @JSONField(ordinal = 4)
    private Long targetGmv;

    /**
     * 粉丝爱称
     */
    @ExcelProperty(index = 6)
    @JSONField(ordinal = 5)
    private String fansNameAlias;

    @JSONField(ordinal = 9999)
    private String desc;

    @JSONField(ordinal = 2)
    private Long livePlanStartTime;

    @JSONField(ordinal = 3)
    private Long livePlanEndTime;

}
