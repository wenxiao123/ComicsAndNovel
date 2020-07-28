package com.collection.comicsandnovel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.collection.comicsandnovel.R;


import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;

/**
 * @author Created on 2020/2/28
 */
public class BottomTitleAdapter extends RecyclerView.Adapter {
    private static final String TAG = "BookshelfNovelsAdapter";

    private Context mContext;
    private List<Integer> integers;
    private List<Integer> integers_checks;
    public interface BookshelfNovelListener {
        void clickItem(int position);
        void longClick(int position);
    }

    public BottomTitleAdapter(Context mContext,List<Integer> integers,List<Integer> integers_checks) {
        this.mContext = mContext;
        this.integers = integers;
        this.integers_checks = integers_checks;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_item, parent,false);
        return new ContentViewHolder(LayoutInflater.from(mContext).inflate(
                R.layout.item_bookshelf_novel, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i, @NonNull List payloads) {
        final ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_title)
        ImageView img_title;
        @BindView(R.id.txt_title)
        TextView txt_title;
        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
