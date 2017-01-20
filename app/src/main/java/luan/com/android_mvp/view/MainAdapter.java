package luan.com.android_mvp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import luan.com.android_mvp.R;
import luan.com.android_mvp.entity.Photo;

public class MainAdapter extends RecyclerView.Adapter {

    private List<Photo> mPhotos;
    private Context mContext;

    public MainAdapter(List<Photo> photos, Context context) {
        mPhotos = photos;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        MainViewHolder mainViewHolder = new MainViewHolder(itemView);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainViewHolder mainViewHolder = (MainViewHolder) holder;
        Photo photo = mPhotos.get(position);

        Glide.with(mContext)
                .load(photo.getUrls().getRegular())
                .into(mainViewHolder.mImgPhoto);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
