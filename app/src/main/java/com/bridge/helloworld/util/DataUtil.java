package com.bridge.helloworld.util;

/**
 * Created by Bridge on 2017/12/27.
 */

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;



/**
 * 数据存储以及持久化
 */
public class DataUtil {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    /**
     * 文件形式存储数据
     */
    public static void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            //执行到此处报空指针异常
            out = context.openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
