package com.fengze.shop.dao;


import com.fengze.shop.domain.UserDo;
//用户接口
public interface UserDao {
//添加
	Boolean add(UserDo user);
//查找
	UserDo find(String id);
//查找
	UserDo find(String username, String password);

}