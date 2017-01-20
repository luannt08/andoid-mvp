package luan.com.android_mvp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import luan.com.android_mvp.R;

public class MainViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImgPhoto;

    public MainViewHolder(View itemView) {
        super(itemView);
        mImgPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
    }
}
