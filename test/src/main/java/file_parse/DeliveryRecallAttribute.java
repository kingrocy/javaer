package file_parse;

import lombok.Data;

/**
 * Created on 2023-10-27
 */
@Data
public class DeliveryRecallAttribute {


    private Long item_id; //商品
    private Long cate1_id; //商品一级类目id
    private Long cate3_id; //商品三级类目id
    private Long leaf_cate_id; //商品叶子类目id
    private Long brand_id; //商品品牌id
    private Long price; //商品价格 ，分单位
    private Long author_id; //商家id
    private Long promoter_id; //当前达人ID
}
