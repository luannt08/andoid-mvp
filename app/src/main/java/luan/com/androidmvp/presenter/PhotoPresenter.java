package luan.com.androidmvp.presenter;

import java.util.List;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.model.PhotoModel;

public class PhotoPresenter implements Photo.Presenter {

    private PhotoModel mModel;
    private Photo.View mView;

    public PhotoPresenter(PhotoModel mainModel) {
        mModel = mainModel;
        mModel.takePresenter(this);
    }

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
    public void takeView(Photo.View view) {
        mView = view;
    }

    @Override
    public void error() {
        mView.showLoading(false);
        mView.showError();
    }
}
