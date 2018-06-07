package com.example.administrator.quarter.ui.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.HotVideosBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.ui.Recommend.adapter.RecommendAdapter;
import com.example.administrator.quarter.ui.video.VideoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HotVideosBean.DataBean> list;
    private LayoutInflater inflate;

    public HotAdapter(Context context, List<HotVideosBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflate=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflate.inflate(R.layout.hotvideos_item, parent, false);
        JViewHolder jViewHolder = new JViewHolder(view);

        return jViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final JViewHolder jViewHolder = (JViewHolder) holder;
        final HotVideosBean.DataBean dataBean = list.get(position);
        String uri = dataBean.getCover();
        //jViewHolder.image.setImageURI(Uri.parse(uri));
        Glide.with(context).load(uri)
                .into(jViewHolder.image);
        jViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("bean",dataBean.getVideoUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class JViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;


        public JViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.masonry_item_img);
        }

    }
}
