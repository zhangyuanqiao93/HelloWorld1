package com.bridge.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * function：UI_Widget Demo活动
 * author：Bridge
 * date：2017/12/6
 */
public class UIWidgetActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "UIWidgetActivity";
    /**
     * 实现点击按钮获取文本框内容
     */
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiwidget);
        init();
    }

    private void init() {
        editText = findViewById(R.id.edit_text);
        //editText.setOnClickListener(this);

        button = findViewById(R.id.ui_btn);
        button.setOnClickListener(this);

        imageView = findViewById(R.id.image_view);
        //imageView.setOnClickListener(this);

        progressBar = findViewById(R.id.progress_bar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ui_btn:

                /***---------点击按钮获取文本框的内容start-----------***/
                //String inputText = editText.getText().toString();
                //Log.d(TAG, "UIWidgetActivity onClick: "+ inputText);
                //Toast.makeText(UIWidgetActivity.this,inputText,Toast.LENGTH_SHORT).show();
                /***---------点击按钮获取文本框的内容end-----------***/

                //imageView.setImageResource(R.mipmap.apple_logo01);

                /***---------progress直线进度条start-----------***/
              /*  int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);*/
                /***---------progress直线进度条end-----------***/


                /***---------progress圆形进度条start-----------***/
             /*   if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }*/
                /***---------progress圆形进度条end-----------***/


                /***---------点击按钮获取提示框start-----------***/
                /*AlertDialog.Builder dialog = new AlertDialog.Builder(UIWidgetActivity.this);
                dialog.setTitle("警告");//设置弹出提示框的标题
                dialog.setMessage("重要提示：关闭后将不可使用该功能，确定关闭？");//内容
                dialog.setCancelable(false);//是否可用Back键关闭
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.show();*/
                /***---------点击按钮获取提示框end-----------***/



                /***---------点击按钮获取ProgressDialog提示框start-----------***/
                ProgressDialog progressDialog = new ProgressDialog(UIWidgetActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                /***---------点击按钮获取ProgressDialog提示框end-----------***/


                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
