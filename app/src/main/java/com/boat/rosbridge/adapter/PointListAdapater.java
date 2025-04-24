package com.boat.rosbridge.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boat.rosbridge.R;
import com.boat.support.slam.entity.floors.Points;

import java.util.LinkedList;
import java.util.List;

public class PointListAdapater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Points> mDatas = new LinkedList<>();
    private OnItemClickListener onItemClickListener;

    public PointListAdapater(Context context) {
        mContext = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Points> data){
        mDatas = data;
//        Log.d("TAG", "setData: mDatas "+mDatas.size());
        notifyDataSetChanged();
    }

    public void setOnItemClick(OnItemClickListener onItemClick){
        onItemClickListener = onItemClick;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_point, parent, false);

        return new NormalHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NormalHolder normalHolder = (NormalHolder) holder;
        normalHolder.tv_point.setText(mDatas.get(position).getPointName());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class NormalHolder extends RecyclerView.ViewHolder {

        public TextView tv_point;
        public RelativeLayout rl_bn;

        public NormalHolder(View itemView) {
            super(itemView);
            tv_point = itemView.findViewById(R.id.text_item_point);
            rl_bn = (RelativeLayout) itemView.findViewById(R.id.item_point_rl);
            rl_bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
            rl_bn.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemClickListener!=null){
                        onItemClickListener.onItemLongClick(v, getAdapterPosition());
                        return true;
                    }
                    return false;
                }
            });
        }

    }
    public interface OnItemClickListener {
        //参数（父组件，当前单击的View,单击的View的位置，数据）
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }
}