package com.fengze.shop.dao;

import com.fengze.shop.domain.Page;
import com.fengze.shop.domain.PicDo;
import com.fengze.shop.domain.ProDetailDo;
import com.fengze.shop.domain.ProductDo;

import java.util.List;

/**
 * Created by zhangls on 2016/10/31 0031.
 */
public interface ProductDao {

    public List<ProductDo> queryMenuProduct(Integer menuId);

    public Boolean addProduct(ProductDo pro);

    public ProductDo queryProByName(ProductDo productDo);

    public Boolean addPicInfo(List<PicDo> ls);

    public PicDo queryPicByPic(ProductDo productDo);

    public Boolean updatePro(ProductDo productDo);

    public Page<ProductDo> queryProductList(Page<ProductDo> page);

    public Integer queryProListConunt(ProductDo proDo);

    public Boolean addProDetail(ProDetailDo proDetailDo);

    public ProductDo queryProductById(String proId);

    public List<PicDo> queryPicList(ProductDo proDo);
}
