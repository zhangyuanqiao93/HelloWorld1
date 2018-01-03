package com.bridge.helloworld.dao;

import com.bridge.helloworld.entity.Shop;
import com.bridge.helloworld.util.BaseApplication;


import java.util.List;

/**
 * Created by Bridge on 2018/1/3.
 * LoveDao管理,GreenDao的增删改查
 */

public class LoveDao {



    /**
     * 添加数据，传入shop对象，如果有重复，就覆盖掉
     * @param shop
     */
    public static void insertLove(Shop shop){
        BaseApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
    }

    /**
     * 删除数据，通过id寻找到该记录
     * @param id
     */
    public static void deleteLove(Long id){
        //BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        //BaseApplication.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        //return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
        return null;
    }

    /**
     * 查询全部数据
     */
    public static List<Shop> queryAll() {
        //return BaseApplication.getDaoInstant().getShopDao().loadAll();
        return null;
    }

}
