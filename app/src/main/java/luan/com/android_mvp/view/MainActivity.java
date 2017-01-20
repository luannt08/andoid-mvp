package luan.com.android_mvp.view;

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

import luan.com.android_mvp.R;
import luan.com.android_mvp.base.Main;
import luan.com.android_mvp.entity.Photo;
import luan.com.android_mvp.model.MainModel;
import luan.com.android_mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements Main.View {

    private MainPresenter mMainPresenter;
    private MainModel mMainModel;

    private ProgressBar mProgressBar;
    private RecyclerView mRecylerViewPhoto;

    private List<Photo> mListPhotos;
    private MainAdapter mMainAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mRecylerViewPhoto = (RecyclerView) findViewById(R.id.recylerview_photo);

        initMvp();
        initInstance();

        mRecylerViewPhoto.setLayoutManager(mLayoutManager);
        mRecylerViewPhoto.setAdapter(mMainAdapter);
        mMainPresenter.requestToModelToGetData(getString(R.string.token));
    }

    @Override
    public void updateDataToView(List<?> data) {
        mListPhotos.addAll((Collection<? extends Photo>) data);
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

    private void initMvp(){
        mMainPresenter = new MainPresenter();
        mMainModel = new MainModel();

        mMainPresenter.takeView(this);
        mMainPresenter.takeModel(mMainModel);
        mMainModel.takePresenter(mMainPresenter);
    }

    private void initInstance() {
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mListPhotos = new ArrayList<>();
        mMainAdapter = new MainAdapter(mListPhotos, getApplicationContext());
    }
}
