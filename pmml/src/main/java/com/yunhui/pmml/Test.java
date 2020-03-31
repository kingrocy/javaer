package com.yunhui.pmml;

import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.ProbabilityDistribution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2019-10-11 13:52
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {
        Map<FieldName, Object> paramsMap = new HashMap();
        paramsMap.put(FieldName.create("ordhour"), 0);
        paramsMap.put(FieldName.create("ordadvanceday"), 2);
        paramsMap.put(FieldName.create("isoverflow_h"), 0);
        paramsMap.put(FieldName.create("room_avg_orddate"), 542);
        paramsMap.put(FieldName.create("remainder_saletime"), 67.38888889D);
        paramsMap.put(FieldName.create("mhtl_nocancelroomnum_efdt_30d"), 3);
        paramsMap.put(FieldName.create("mhtl_submitordnum_noroom_efdt_30d"), 0);
        paramsMap.put(FieldName.create("mhtl_submitordnum_efdt_30d"), 3);
        paramsMap.put(FieldName.create("mhtl_ordtime_median_efdt_30d"), 11.05D);
        paramsMap.put(FieldName.create("htl_nocancelroomnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_noroom_efdt_30d"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("htl_ordtime_median_efdt_30d"), 452.6333333D);
        paramsMap.put(FieldName.create("mbroom_submitordnum_noroom_efdt_30d"), 0);
        paramsMap.put(FieldName.create("mbroom_submitordnum_efdt_30d"), 2);
        paramsMap.put(FieldName.create("mbroom_nocancelroomnum_efdt_30d"), 2);
        paramsMap.put(FieldName.create("broom_submitordnum_noroom_efdt_30d"), 0);
        paramsMap.put(FieldName.create("broom_submitordnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("broom_nocancelroomnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("room_submitordnum_noroom_efdt_30d"), 0);
        paramsMap.put(FieldName.create("room_submitordnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("room_nocancelroomnum_efdt_30d"), 0);
        paramsMap.put(FieldName.create("roomrecommendlevel"), 2);
        paramsMap.put(FieldName.create("mhtlroomquantity"), 158);
        paramsMap.put(FieldName.create("mhtl_customereval"), 4.44958D);
        paramsMap.put(FieldName.create("mhtl_maxroomnum_30d"), 18);
        paramsMap.put(FieldName.create("htl_maxroomnum_30d"), -999);
        paramsMap.put(FieldName.create("broom_maxroomnum_30d"), -999);
        paramsMap.put(FieldName.create("room_maxroomnum_30d"), -999);
        paramsMap.put(FieldName.create("mbroom_maxroomnum_30d"), 11);
        paramsMap.put(FieldName.create("mhtl_maxroomnum_180d"), 28);
        paramsMap.put(FieldName.create("htl_maxroomnum_180d"), -999);
        paramsMap.put(FieldName.create("mbroom_maxroomnum_180d"), 26);
        paramsMap.put(FieldName.create("room_maxroomnum_180d"), -999);
        paramsMap.put(FieldName.create("mhtl_submitordnum_30d"), 160);
        paramsMap.put(FieldName.create("mhtl_submitordnum_noroom_30d"), 0);
        paramsMap.put(FieldName.create("mhtl_submitordnum_hold_30d"), 157);
        paramsMap.put(FieldName.create("mhtl_submitordnum_hold_noroom_30d"), 0);
        paramsMap.put(FieldName.create("mhtl_submitordnum_free_30d"), 3);
        paramsMap.put(FieldName.create("mhtl_submitordnum_free_noroom_30d"), 0);
        paramsMap.put(FieldName.create("mbroom_submitordnum_30d"), 90);
        paramsMap.put(FieldName.create("mbroom_submitordnum_noroom_30d"), 0);
        paramsMap.put(FieldName.create("mbroom_submitordnum_hold_30d"), 90);
        paramsMap.put(FieldName.create("mbroom_submitordnum_hold_noroom_30d"), 0);
        paramsMap.put(FieldName.create("mbroom_submitordnum_free_30d"), 0);
        paramsMap.put(FieldName.create("mbroom_submitordnum_free_noroom_30d"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_30d"), -999);
        paramsMap.put(FieldName.create("htl_submitordnum_noroom_30d"), -999);
        paramsMap.put(FieldName.create("htl_submitordnum_hold_30d"), -999);
        paramsMap.put(FieldName.create("htl_submitordnum_hold_noroom_30d"), -999);
        paramsMap.put(FieldName.create("htl_submitordnum_free_30d"), -999);
        paramsMap.put(FieldName.create("htl_submitordnum_free_noroom_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_noroom_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_hold_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_hold_noroom_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_free_30d"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_free_noroom_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_noroom_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_hold_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_hold_noroom_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_free_30d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_free_noroom_30d"), -999);
        paramsMap.put(FieldName.create("group_submitordnum_30d"), -999);
        paramsMap.put(FieldName.create("group_submitordnum_noroom_30d"), -999);
        paramsMap.put(FieldName.create("supplier_submitordnum_30d"), 508);
        paramsMap.put(FieldName.create("supplier_submitordnum_noroom_30d"), 0);
        paramsMap.put(FieldName.create("supplier_ordtime_median_efdt_30d"), 2.5D);
        paramsMap.put(FieldName.create("room_submitordnum_14d"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_noroom_14d"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_14d"), 55);
        paramsMap.put(FieldName.create("mbroom_submitordnum_noroom_14d"), 0);
        paramsMap.put(FieldName.create("cityi"), 0.13931029D);
        paramsMap.put(FieldName.create("cityi_diff"), 9.1438E-4D);
        paramsMap.put(FieldName.create("zonei"), 0.13623674D);
        paramsMap.put(FieldName.create("zonei_diff"), 0.002093807D);
        paramsMap.put(FieldName.create("zonestari"), 0.16207951D);
        paramsMap.put(FieldName.create("zonestari_diff"), 0);
        paramsMap.put(FieldName.create("highestdegree"), -999);
        paramsMap.put(FieldName.create("lowestdegree"), -999);
        paramsMap.put(FieldName.create("roomclass_contractrooms_efdt"), -999);
        paramsMap.put(FieldName.create("holiday_ord"), 0);
        paramsMap.put(FieldName.create("day_of_holiday_ord"), 0);
        paramsMap.put(FieldName.create("mhtl_submitordnum_efdt_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_efdt_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_efdt_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("broom_submitordnum_efdt_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_efdt_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mhtl_submitordnum_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("broom_submitordnum_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mhtl_submitordnum_hold_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_hold_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_hold_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("broom_submitordnum_hold_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_hold_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mhtl_submitordnum_free_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("htl_submitordnum_free_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_free_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("broom_submitordnum_free_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_free_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("group_submitordnum_30d_mfratio"), -999);
        paramsMap.put(FieldName.create("supplier_submitordnum_30d_mfratio"), 0);
        paramsMap.put(FieldName.create("room_submitordnum_14d_mfratio"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_14d_mfratio"), 0);
        paramsMap.put(FieldName.create("mhtl_submitordnum_efdt_30d_mfratio_compare"), -0.001266154D);
        paramsMap.put(FieldName.create("htl_submitordnum_efdt_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_efdt_30d_mfratio_compare"), -0.001013757D);
        paramsMap.put(FieldName.create("broom_submitordnum_efdt_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_efdt_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("mhtl_submitordnum_30d_mfratio_compare"), -0.002918646D);
        paramsMap.put(FieldName.create("htl_submitordnum_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_30d_mfratio_compare"), -0.002753233D);
        paramsMap.put(FieldName.create("broom_submitordnum_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_30d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("room_submitordnum_14d_mfratio_compare"), -999);
        paramsMap.put(FieldName.create("mbroom_submitordnum_14d_mfratio_compare"), -0.002744489D);
        paramsMap.put(FieldName.create("room_avg_orddate_compare"), 1);
        paramsMap.put(FieldName.create("degree"), 0);
        paramsMap.put(FieldName.create("weather"), 0);
        paramsMap.put(FieldName.create("timeperiod_1"), 1);
        paramsMap.put(FieldName.create("timeperiod_2"), 0);
        paramsMap.put(FieldName.create("timeperiod_3"), 0);
        paramsMap.put(FieldName.create("isstraightconnect_0"), 1);
        paramsMap.put(FieldName.create("isstraightconnect_1"), 0);
        paramsMap.put(FieldName.create("star_0"), 0);
        paramsMap.put(FieldName.create("star_2"), 0);
        paramsMap.put(FieldName.create("star_3"), 0);
        paramsMap.put(FieldName.create("star_4"), 1);
        paramsMap.put(FieldName.create("star_5"), 0);
        paramsMap.put(FieldName.create("cprflag_0"), 1);
        paramsMap.put(FieldName.create("cprflag_1"), 0);
        paramsMap.put(FieldName.create("cprflag_2"), 0);
        paramsMap.put(FieldName.create("cprflag_3"), 0);
        paramsMap.put(FieldName.create("cprflag_4"), 0);
        paramsMap.put(FieldName.create("is_belong_group_0"), 1);
        paramsMap.put(FieldName.create("is_belong_group_1"), 0);
        ModelInvoker invoker = new ModelInvoker("PredFalseHoldRoom.pmml");
        Map<FieldName, ?> scoreMap = invoker.invoke(paramsMap);

        ProbabilityDistribution probabilityDistribution = (ProbabilityDistribution) scoreMap.get(FieldName.create("y"));

        Double value1 = probabilityDistribution.getValue("0");
        Double value2 = probabilityDistribution.getValue("1");


        System.out.println(scoreMap.get(FieldName.create("probability_0")));
        System.out.println(scoreMap.get(FieldName.create("probability_1")));
    }

}
