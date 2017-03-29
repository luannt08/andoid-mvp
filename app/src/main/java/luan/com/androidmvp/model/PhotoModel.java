package luan.com.androidmvp.model;

import android.util.Log;

import java.util.List;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.presenter.PhotoPresenter;
import luan.com.androidmvp.retrofit.RetrofitService;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PhotoModel implements Photo.Model {

    private final String TAG = PhotoModel.class.getSimpleName();
    private PhotoPresenter mMainPresenter;
    private RetrofitService mRetrofitService;

    public PhotoModel(RetrofitService retrofitService) {
        mRetrofitService = retrofitService;
    }

    @Override
    public void getDataFromServer(String token) {
        mRetrofitService.getPhoto(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<List<luan.com.androidmvp.model.entity.Photo>>() {
                               @Override
                               public void call(List<luan.com.androidmvp.model.entity.Photo> photos) {
                                   Log.e(TAG, "getDataFromServer - photos : " + photos);
                                   mMainPresenter.getDataFromModel(photos);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                Log.e(TAG, "getDataFromServer - error");
                                throwable.printStackTrace();

                                mMainPresenter.error();
                            }
                        });
    }

    @Override
    public void takePresenter(Photo.Presenter presenter) {
        mMainPresenter = (PhotoPresenter) presenter;
    }
}
