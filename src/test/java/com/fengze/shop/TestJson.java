package com.fengze.shop;

import java.util.List;

/**
 * Created by zhangls on 2016/11/9 0009.
 */
public class TestJson {

    public static void main(String[] args) {
        String sts = "[CarDo(userId=2, prodId=1, proSize=XL, proColor=black, proNum=4, proPrice=499.21, talPrice=1996.84, pro=ProductDo(proName=淑女成衣真丝裙子，活动促销中, proRealPrice=null, proNowPrice=null, isStock=1, proDesc=活动促销中,活动促销中,活动促销中,活动促销中,活动促销中, proSize=null, proColor=null, proScore=null, proTypeId=9, proPicId=null, proPicUri=/super-shop/shop/assets/temp/products/model1.jpg, picLs=null, commentLs=null, proDetailDo=null)), CarDo(userId=2, prodId=2, proSize=XL, proColor=black, proNum=2, proPrice=49.26, talPrice=98.52, pro=ProductDo(proName=女生高档眼镜，活动促销中, proRealPrice=null, proNowPrice=null, isStock=1, proDesc=活动促销中,活动促销中,活动促销中,活动促销中,活动促销中, proSize=null, proColor=null, proScore=null, proTypeId=9, proPicId=null, proPicUri=/super-shop/shop/assets/temp/products/model1.jpg, picLs=null, commentLs=null, proDetailDo=null))]";

        List list = java.util.Arrays.asList(sts);

        System.out.println("");
    }
}
