package luan.com.android_mvp.presenter;


import java.util.List;

import luan.com.android_mvp.base.Main;


public class MainPresenter implements Main.Presenter {

    private Main.Model mModel;
    private Main.View mView;

    @Override
    public void requestToModelToGetData(String url) {
        mModel.getDataFromServer(url);
        mView.showLoading(true);
    }

    @Override
    public void getDataFromModel(List<?> data) {
        mView.updateDataToView(data);
        mView.showLoading(false);
    }

    @Override
    public void takeView(Main.View view) {
        mView = view;
    }

    @Override
    public void takeModel(Main.Model model) {
        mModel = model;
    }

    @Override
    public void error() {
        mView.showLoading(false);
        mView.showError();
    }
}
