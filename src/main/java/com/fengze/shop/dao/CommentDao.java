package com.fengze.shop.dao;

import com.fengze.shop.domain.CommentDo;
import com.fengze.shop.domain.ProductDo;

import java.util.List;

/**
 * Created by zhangls on 2016/11/3 0003.
 */
public interface CommentDao {
//评论模型  根据ID查询产品信息
    public List<CommentDo> queryComByProId(ProductDo pro);
}
