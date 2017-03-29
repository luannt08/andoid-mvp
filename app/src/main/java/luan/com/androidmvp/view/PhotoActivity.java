package luan.com.androidmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import luan.com.androidmvp.R;
import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.base.PhotoAplication;
import luan.com.androidmvp.dagger.component.DaggerPhotoComponent;
import luan.com.androidmvp.dagger.component.RetrofitComponent;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.presenter.PhotoPresenter;

public class PhotoActivity extends AppCompatActivity implements Photo.View {

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Bind(R.id.recylerview_photo)
    RecyclerView mRecylerViewPhoto;

    @Inject
    public PhotoPresenter mMainPresenter;

    private List<luan.com.androidmvp.model.entity.Photo> mListPhotos;
    private PhotoAdapter mMainAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initDagger();
        initMvp();
        initInstance();
    }

    @Override
    public void updateDataToView(List<?> data) {
        mListPhotos.addAll((Collection<? extends luan.com.androidmvp.model.entity.Photo>) data);
        mMainAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading(boolean isShow) {
        if (isShow) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
    }

    private void initDagger() {
        RetrofitComponent retrofitComponent = ((PhotoAplication)getApplication()).getRetrofitComponent();
        DaggerPhotoComponent
                .builder()
                .retrofitComponent(retrofitComponent)
                .photoModule(new PhotoModule())
                .build()
                .inject(this);
    }

    private void initMvp(){
        mMainPresenter.takeView(this);
    }

    private void initInstance() {
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mListPhotos = new ArrayList<>();
        mMainAdapter = new PhotoAdapter(mListPhotos, getApplicationContext());

        mRecylerViewPhoto.setLayoutManager(mLayoutManager);
        mRecylerViewPhoto.setAdapter(mMainAdapter);
        mMainPresenter.requestToModelToGetData(getString(R.string.token));
    }
}
