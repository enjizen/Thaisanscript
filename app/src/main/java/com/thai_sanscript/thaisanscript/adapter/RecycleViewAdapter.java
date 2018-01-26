package com.thai_sanscript.thaisanscript.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.model.TitleFirstViewModel;
import com.thai_sanscript.thaisanscript.util.LogUtil;

import java.util.List;

/**
 * Created by streami.t.mobiledeveloper1 on 23/1/2018 AD.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolderAdapter> {

    private List<TitleFirstViewModel> titleFirstViewModelList;
    private Context context;

    public RecycleViewAdapter(Context context
            ,List<TitleFirstViewModel> titleFirstViewModelList){

        this.context = context;
        this.titleFirstViewModelList = titleFirstViewModelList;

    }

    @Override
    public ViewHolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycle_view,parent,false);

         return new ViewHolderAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapter holder, int position) {

        TitleFirstViewModel titleFirstViewModel = titleFirstViewModelList.get(position);
        holder.tvTitle.setText(titleFirstViewModel.getTitle());
        holder.tvTitleDetail.setText(titleFirstViewModel.getTitleDetail());
        holder.tvSubTitleDetail.setText(titleFirstViewModel.getSubTitleDetail());
        Glide.with(context)
                .load(titleFirstViewModel.getUrlImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return this.titleFirstViewModelList.size();
    }

    class ViewHolderAdapter extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvTitle,tvTitleDetail,tvSubTitleDetail;

        private ViewHolderAdapter(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTitleDetail = itemView.findViewById(R.id.tv_title_detail);
            tvSubTitleDetail = itemView.findViewById(R.id.tv_subtitle_detail);

           // tvMessageDetail = itemView.findViewById(R.id.tv)

        }
    }

}
