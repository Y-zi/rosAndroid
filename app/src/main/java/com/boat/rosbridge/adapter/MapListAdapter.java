package com.boat.rosbridge.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boat.rosbridge.R;
import com.boat.support.slam.entity.floors.Maps;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MapListAdapter extends RecyclerView.Adapter<MapListAdapter.MapViewHolder> {
    private List<Maps> mapsList = new ArrayList<Maps>();
    long currentMapId = 0;
    private Context context;
    private OnClick onclick;
    private String displayString;

    public MapListAdapter(Context context) {
        this.context = context;
    }

    public void setListData(List<Maps> mapsList, long currentMapId) {
        this.currentMapId = currentMapId;
        this.mapsList = mapsList;
        this.notifyDataSetChanged();
    }

    public void setOnclickItem(OnClick onclick) {
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public MapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_map, parent, false);
        MapViewHolder holder = new MapViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MapViewHolder holder, int position) {
        holder.rl_bn.setTag(position);
        holder.tv.setText(mapsList.get(position).getMapName());

        if (mapsList.get(position).getMapId() == currentMapId) {
            holder.tv.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.tv.setTextColor(context.getResources().getColor(R.color.item_time_color));
        }

    }

    @Override
    public int getItemCount() {
        return mapsList == null ? 0 : mapsList.size();
    }


    public class MapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


        private TextView tv;
        RelativeLayout rl_bn;

        public MapViewHolder(View itemView) {
            super(itemView);

            rl_bn = (RelativeLayout) itemView.findViewById(R.id.item_map_rl);
            tv = (TextView) itemView.findViewById(R.id.text_item_map);
            //tv_mapid = (TextView) itemView.findViewById(R.id.tv_mapid);

            rl_bn.setOnClickListener(this);
            rl_bn.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onclick != null)
                onclick.click(v);
        }

        @Override
        public boolean onLongClick(View v) {
            if (onclick != null)
                onclick.longlick(v);
            return false;
        }
    }

    public interface OnClick {
        void longlick(View v);

        void click(View v);

    }

}
