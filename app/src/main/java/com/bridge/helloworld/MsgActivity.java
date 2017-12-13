package com.bridge.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bridge.helloworld.adapter.MsgAdapter;
import com.bridge.helloworld.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends AppCompatActivity {

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

        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //adapter.notifyItemChanged();
                }
            }
        });

    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello man.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("Hello，Who is that.",Msg.TYPE_RECEIVED);
        msgList.add(msg2);

        Msg msg3 = new Msg("This is Tom，Nice talking to you.",Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }
}
