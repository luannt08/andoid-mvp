package luan.com.android_mvp.model;

import java.util.List;

import luan.com.android_mvp.base.Main;
import luan.com.android_mvp.entity.Photo;
import luan.com.android_mvp.presenter.MainPresenter;
import luan.com.android_mvp.retrofit.RetrofitAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainModel implements Main.Model {

    private MainPresenter mMainPresenter;

    @Override
    public void getDataFromServer(String token) {
        RetrofitAdapter.getInstance().getApiService().getPhotoNewWithOrderBy(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<List<Photo>>() {
                               @Override
                               public void call(List<Photo> photos) {
                                   mMainPresenter.getDataFromModel(photos);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                mMainPresenter.error();
                            }
                        });
    }

    @Override
    public void takePresenter(Main.Presenter presenter) {
        mMainPresenter = (MainPresenter) presenter;
    }
}
