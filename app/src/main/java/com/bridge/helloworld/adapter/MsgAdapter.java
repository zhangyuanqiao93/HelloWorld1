package com.bridge.helloworld.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bridge.helloworld.R;
import com.bridge.helloworld.entity.Msg;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Bridge on 2017/12/13.
 */

/**
 * function：Msg适配器的适配
 * date：2017/12/13
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout,rightLayout;
        TextView leftMsg,rightMsg;


        public ViewHolder(View view){
            super(view);

            Log.i(TAG, "ViewHolder: 开始初始化组件");
            /**
             * 初始化组件
             */
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);

            leftMsg = view.findViewById(R.id.left_msg);
            rightMsg = view.findViewById(R.id.right_msg);

        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            Log.d(TAG, "onBindViewHolder: 收到消息 ");
            //如果是收到消息，则显示左边的消息布局 ，将右边的消息隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if(msg.getType() == Msg.TYPE_SENT){
            //如果是发送消息，则显示右边的消息布局 ，将左边的消息隐藏

            Log.d(TAG, "onBindViewHolder: 发送消息 ");
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        Log.w(TAG, "getItemCount: "+ mMsgList.size() );
        return mMsgList.size();
    }

}
