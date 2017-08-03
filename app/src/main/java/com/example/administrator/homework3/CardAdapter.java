package com.example.administrator.homework3;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {
    private TypedArray imgArray;
    private TypedArray nameArray;
    private TypedArray statusArray;
    private TypedArray picArray;

    public CardAdapter(Context context) {
        imgArray = context.getResources().obtainTypedArray(R.array.img_post);
        nameArray = context.getResources().obtainTypedArray(R.array.name_post);
        statusArray = context.getResources().obtainTypedArray(R.array.status_post);
        picArray = context.getResources().obtainTypedArray(R.array.pic_post);
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card
                , parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.imageView.setImageResource(imgArray.getResourceId(position
                , R.drawable.cake_logo));
        holder.nameTextView.setText(nameArray.getString(position));
        holder.statusTextView.setText(statusArray.getString(position));
        holder.picImageView.setImageResource(picArray.getResourceId(position
                , R.drawable.bg_candy));
    }

    @Override
    public int getItemCount() {
        return nameArray.length();
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        CardView cardView;

        @BindView(R.id.img_post)
        ImageView imageView;

        @BindView(R.id.name_post)
        TextView nameTextView;

        @BindView(R.id.status_post)
        TextView statusTextView;

        @BindView(R.id.pic_post)
        ImageView picImageView;

        public CardHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
