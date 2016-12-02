package com.fengze.shop.service.impl;


import com.fengze.shop.dao.*;
import com.fengze.shop.dao.impl.*;
import com.fengze.shop.domain.*;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.utils.DaoFactory;
import com.fengze.shop.utils.JdbcUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务处理实现类
 */
public class BusinessServiceImpl implements BusinessService {
//通过反射调用工厂设计模式中创建对象;
    private UserDao userDao = DaoFactory.getInstance()
            .createDao("com.fengze.shop.dao.impl.UserDaoImpl", UserDaoImpl.class);

    private MenuDao menuDao = DaoFactory.getInstance()
            .createDao("com.fengze.shop.dao.impl.MenuDaoImpl", MenuDaoImpl.class);

    private CarDao carDao = DaoFactory.getInstance()
            .createDao("com.fengze.shop.dao.impl.CarDaoImpl", CarDaoImpl.class);

    public UserDo userLogin(String username, String password) {
        return userDao.find(username, password);
    }

    @Override
    public Boolean registerMember(UserDo user) {
        return userDao.add(user);
    }

    @Override
    public Map<Integer, List<Menu>> queryMenu() {
        return getMenuDetail(menuDao.queryMenu(0), 0, new LinkedHashMap<Integer, List<Menu>>());
    }

    /**
     * 添加产品信息
     * 第一步 插入产品信息
     * 第二步 查询产品信息
     * 第三步 插入产品图片表
     * 第四步 查询图片生成表
     * 第四步 更新产品表
     *
     * @param pro
     * @return
     */
    @Override
    public Boolean addProduct(ProductDo pro) {
        try {
            JdbcUtils.startTransaction(); //开启事务
            //注意这行代码一定要放在开启事务之后 ，连接才会被创建
            ProductDao dao = DaoFactory.getInstance().createDao("com.fengze.shop.dao.impl.ProductDaoImpl", ProductDaoImpl.class);

            if (dao.addProduct(pro)) {//插入产品成功
                ProductDo productDo = dao.queryProByName(pro);//查询产品Id

                pro.getProDetailDo().setProId(productDo.getId());//添加产品ID到产品明细

                dao.addProDetail(pro.getProDetailDo());//新增产品明细

                for (PicDo pic : pro.getPicLs()) {
                    pic.setProId(productDo.getId());//添加产品ID到图片表
                }

                if (dao.addPicInfo(pro.getPicLs())) {//添加产品图片信息
                    PicDo pic = dao.queryPicByPic(productDo);//查询产品图片默认ID
                    pro.setProPicId(pic.getId());
                    dao.updatePro(pro);//更新产品表默认图片ID
                }
                JdbcUtils.commit();//提交事务
                return Boolean.TRUE;
            } else {
                JdbcUtils.rollback();//回滚事务
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            JdbcUtils.rollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }

    }

    /**
     * 递归方法，实现菜单信息的查询
     *
     * @param ls
     * @param menuId
     * @param map
     * @return
     */
    private Map<Integer, List<Menu>> getMenuDetail(List<Menu> ls, Integer menuId, Map<Integer, List<Menu>> map) {
        map.put(menuId, ls);

        for (Menu menu : ls) {
            getMenuDetail(menuDao.queryMenu(menu.getId()), menu.getId(), map);
        }

        return map;
    }

    @Override
    public List<ProductDo> queryMenuPro(Integer menuId) {
        try {
            JdbcUtils.startTransaction(); //开启事务

            ProductDao dao = DaoFactory.getInstance().createDao("com.fengze.shop.dao.impl.ProductDaoImpl", ProductDaoImpl.class);

            return dao.queryMenuProduct(menuId);
        } catch (Exception e) {
            JdbcUtils.rollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }

    /**
     * 查询产品列表
     *
     * @param proDo
     * @param currentPage
     * @return
     */
    @Override
    public Page<ProductDo> queryProductList(ProductDo proDo, Integer currentPage) {
        try {
            JdbcUtils.startTransaction(); //开启事务
            ProductDao dao = DaoFactory.getInstance().createDao("com.fengze.shop.dao.impl.ProductDaoImpl", ProductDaoImpl.class);
            Page<ProductDo> page = new Page<ProductDo>(currentPage, dao.queryProListConunt(proDo));
            List<ProductDo> ls = new ArrayList<ProductDo>();
            ls.add(proDo);
            page.setList(ls);

            return dao.queryProductList(page);
        } catch (Exception e) {
            JdbcUtils.rollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }

    /**
     * 添加购物车
     *
     * @param carDo
     * @return
     */
    @Override
    public Boolean addCarInfo(CarDo carDo) {

        //1. 要判断现有产品是否重复添加，重复添加更新proNum数量即可
        //首先要查询购物车表中现有数据
        Integer carId = carDao.queryCarByPro(carDo);

        if (0 != carId) {
            carDao.updateCarNum(carId);
        } else {
            carDao.addCarInfo(carDo);
        }

        return Boolean.TRUE;
    }

    /**
     * 查询购物车信息
     */
    @Override
    public List<CarDo> queryCarInfo(UserDo user) {
        return carDao.queryCarInfo(user);
    }

    /**
     * 根据ID查询产品信息
     *
     * @param proId
     * @return
     */
    @Override
    public ProductDo queryProductById(String proId) {
        try {
            JdbcUtils.startTransaction(); //开启事务

            ProductDao dao = DaoFactory.getInstance().createDao("com.fengze.shop.dao.impl.ProductDaoImpl", ProductDaoImpl.class);
            CommentDao cdao = DaoFactory.getInstance().createDao("com.fengze.shop.dao.impl.CommentDaoImpl", CommentDaoImpl.class);

            ProductDo proDo = dao.queryProductById(proId);

            proDo.setCommentLs(cdao.queryComByProId(proDo));

            proDo.setPicLs(dao.queryPicList(proDo));

            return proDo;
        } catch (Exception e) {
            JdbcUtils.rollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }

    @Override
    public Integer queryCarNum(UserDo user) {
        return carDao.queryCarCount(user);
    }

    @Override
    public Boolean delCarItem(String carId) {
        return carDao.delCarItem(carId);
    }

    @Override
    public Boolean updCarItem(String carId, String proNum) {
        return carDao.updCarItem(carId, proNum);
    }

    @Override
    public Boolean addOrder(OrderDo order) {
        try {
            JdbcUtils.startTransaction(); //开启事务

            OrderDao orderDao = DaoFactory.getInstance()
                    .createDao("com.fengze.shop.dao.impl.OrderDaoImpl", OrderDaoImpl.class);
            CarDao carDao = DaoFactory.getInstance()
                    .createDao("com.fengze.shop.dao.impl.CarDaoImpl", CarDaoImpl.class);

            String orderId = orderDao.queryOrderId();//查询数据库生成订单编号

            UserDo user = new UserDo();
            user.setId(order.getUserId());

            order.setOrderId(orderId);
            order.setDetLs(getOrderDetLs(orderId, carDao.queryCarInfo(user)));

            if (orderDao.addOrder(order) && orderDao.addOrderDet(order.getDetLs()) && carDao.delCarByUser(order.getUserId())) {
                JdbcUtils.commit();
                return Boolean.TRUE;
            } else {
                JdbcUtils.rollback();//回滚事务
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            JdbcUtils.rollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }


    private List<OrderDetDo> getOrderDetLs(String orderId, List<CarDo> ls){
        List<OrderDetDo> orderLs = new ArrayList<OrderDetDo>();

        for(CarDo car : ls){
            OrderDetDo dto = new OrderDetDo();

            dto.setOrderId(orderId);
            dto.setProId(car.getProdId());
            dto.setProName(car.getPro().getProName());
            dto.setProNum(car.getProNum());
            dto.setProDesc(car.getPro().getProDesc());
            dto.setProSize(car.getProSize());
            dto.setProColor(car.getProColor());
            dto.setProPrice(car.getProPrice());
            dto.setTalPrice(car.getTalPrice());
            dto.setCreateBy(car.getCreateBy());
            dto.setUpdateBy(car.getUpdateBy());

            orderLs.add(dto);
        }

        return orderLs;
    }
}
