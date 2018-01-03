# 重拾Android之路（一）
## 从《Android第一行代码（第二版）》入门，再次起航Android之路

**1.Android studio 开发环境的搭建**

**2. 创建自己的第一个Android项目**

**3.activity是什么？如何进行数据传递？生命周期？**


#新增 GreenDao 

### GreenDao中Dao对象其他API的介绍

**增加单个数据** 

getShopDao().insert(shop);

getShopDao().insertOrReplace(shop);

**增加多个数据** 

getShopDao().insertInTx(shopList);

getShopDao().insertOrReplaceInTx(shopList);


**查询全部** 

List< Shop> list = getShopDao().loadAll();

List< Shop> list = getShopDao().queryBuilder().list();


**查询附加单个条件** 

.where()

.whereOr()


**查询附加多个条件** 

.where(, , ,)

.whereOr(, , ,)


**查询附加排序** 

.orderDesc()

.orderAsc()


**查询限制当页个数** 

.limit()

**查询总个数** 

.count()


**修改单个数据** 

getShopDao().update(shop);

**修改多个数据** 

getShopDao().updateInTx(shopList);

**删除单个数据** 

getTABUserDao().delete(user);

**删除多个数据** 

getUserDao().deleteInTx(userList);

**删除数据ByKey** 

getTABUserDao().deleteByKey();