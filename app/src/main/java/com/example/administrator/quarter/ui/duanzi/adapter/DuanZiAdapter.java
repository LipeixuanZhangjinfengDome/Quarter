package com.example.administrator.quarter.ui.duanzi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.DuanZiBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.ui.Recommend.adapter.RecommendAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class DuanZiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<DuanZiBean.DataBean> list;
    private LayoutInflater inflate;

    public DuanZiAdapter(Context context, List<DuanZiBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflate=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflate.inflate(R.layout.duanzi_item, parent, false);
        JViewHolder jViewHolder = new JViewHolder(view);
        return jViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final JViewHolder jViewHolder = (JViewHolder) holder;
        DuanZiBean.DataBean dataBean = list.get(position);
        jViewHolder.image.setImageURI(dataBean.getUser().getIcon());
        jViewHolder.tv1.setText(dataBean.getContent());
        jViewHolder.tv2.setText(dataBean.getCreateTime());
        //jViewHolder.tv3.setText(dataBean.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class JViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        public JViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);
        }

    }
}
