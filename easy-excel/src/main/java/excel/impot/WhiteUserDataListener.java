package excel.impot;

import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * Created on 2021-10-13
 */
@Slf4j
public class WhiteUserDataListener
        extends AnalysisEventListener<WhiteUser> {


    private List<WhiteUser> whiteUserList;
    boolean needDesc = false;

    public WhiteUserDataListener(List<WhiteUser> whiteUserList, boolean needDesc) {
        this.whiteUserList = whiteUserList;
        this.needDesc = needDesc;
    }

    @Override
    public void invoke(WhiteUser whiteUser,
            AnalysisContext analysisContext) {
        if (whiteUser.getAuthorId() == null || whiteUser.getAuthorId() == 0) {
            return;
        }
        if (StringUtils.isEmpty(whiteUser.getFansNameAlias())) {
            whiteUser.setFansNameAlias("家人");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d HH:mm:ss");
            whiteUser.setLivePlanStartTime(sdf.parse(whiteUser.getLivePlanStartTimeStr()).getTime());
            whiteUser.setLivePlanEndTime(sdf.parse(whiteUser.getLivePlanEndTimeStr()).getTime());
            if (whiteUser.getLivePlanEndTime() <= whiteUser.getLivePlanStartTime()) {
                System.out.println("authorId:" + whiteUser.getAuthorId() + ",结束时间小于开始时间，请检查后重试");
                return;
            }
        } catch (Exception e) {
            System.out.println("authorId:" + whiteUser.getAuthorId() + ",时间格式错误，请检查后重试");
            return;
        }
        whiteUser.setTargetGmv(whiteUser.getTargetGmv() * 100);
        if (needDesc) {
            whiteUser.setDesc(
                    whiteUser.getAuthorName() + "【" + whiteUser.getLivePlanStartTimeStr() + "-" + whiteUser
                            .getLivePlanEndTimeStr() + "】");
        }
        whiteUserList.add(whiteUser);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
