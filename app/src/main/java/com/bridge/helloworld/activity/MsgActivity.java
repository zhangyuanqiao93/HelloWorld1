package com.bridge.helloworld.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bridge.helloworld.R;
import com.bridge.helloworld.adapter.MsgAdapter;
import com.bridge.helloworld.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends AppCompatActivity {

    private static final String TAG = "MsgActivity";
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        initMsgs();//初始化消息

        initText();//初始化组件
    }

    private void initText() {

        Log.d(TAG, "initText: 开始初始化组件Button和EditText");
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //adapter = new MsgAdapter(msgList);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 点击发送按钮事件");
                String content = inputText.getText().toString();
                Log.d(TAG, "onClick: "+content);
                Toast.makeText(MsgActivity.this,content,Toast.LENGTH_SHORT).show();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //有消息时刷新Recycler中的显示
                    adapter.notifyItemInserted(msgList.size()-1);

                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位到最后一行

                    inputText.setText("");//清空输入框中的内容

                }
            }
        });

    }

    private void initMsgs() {
        Log.d(TAG, "initMsgs: 初始化Msgs");
        Msg msg1 = new Msg("Hello man.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("Hello，Who is that.",Msg.TYPE_RECEIVED);
        msgList.add(msg2);

        Msg msg3 = new Msg("This is Tom，Nice talking to you.",Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }
}
