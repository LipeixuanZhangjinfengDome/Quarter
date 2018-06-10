package com.example.administrator.quarter.ui.sliding.addfavorite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

class AddfavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final LayoutInflater inflater;
    private Context context;
    private List<AddfavoriteBean.DataBean> data;

    public AddfavoriteAdapter(Context context, List<AddfavoriteBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jokes_item, null);
        AddfavoriteViewHolder collectionViewHolder = new AddfavoriteViewHolder(view);
        return collectionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AddfavoriteViewHolder addfavoriteViewHolder = (AddfavoriteViewHolder) holder;
        AddfavoriteBean.DataBean dataBean = data.get(position);
        addfavoriteViewHolder.image.setImageURI(dataBean.getUser().getIcon());
        addfavoriteViewHolder.tv1.setText(dataBean.getUser().getNickname());
        addfavoriteViewHolder.tv2.setText(dataBean.getCreateTime());
        addfavoriteViewHolder.tv3.setText(dataBean.getWorkDesc());
        addfavoriteViewHolder.tv4.setText(dataBean.getWorkDesc());
        addfavoriteViewHolder.tv5.setText(dataBean.getWorkDesc());

        String url = dataBean.getVideoUrl();
        addfavoriteViewHolder.video.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"视频播放");
        //Uri uri = Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        //jViewHolder.video.thumbImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));
        Glide.with(context).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(addfavoriteViewHolder.video.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class AddfavoriteViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView image;
        private final JCVideoPlayerStandard video;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final TextView tv4;
        private final TextView tv5;


        private boolean flag = true;
        public AddfavoriteViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            video = itemView.findViewById(R.id.video);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv5 = itemView.findViewById(R.id.tv5);
        }
    }
}
