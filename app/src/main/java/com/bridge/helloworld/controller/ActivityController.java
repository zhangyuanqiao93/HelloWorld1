package com.bridge.helloworld.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bridge on 2017/12/6.
 */

/**
 * function：创建一个活动管理器来管理当前的所有的活动，
 * 添加了三个静态方法，add，remove，finishAll；
 * author：Bridge
 * date：2017/12/6
 */
public class ActivityController {

    public static List<Activity> activities = new ArrayList<>();

    /**
     * 添加一个Activity
     * @param activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 移除一个Activity
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * 销毁所有的Activity
     */
    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }

}
