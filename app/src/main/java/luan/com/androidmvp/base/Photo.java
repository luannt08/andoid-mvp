package luan.com.androidmvp.base;


import java.util.List;

/*
* This is base mvp class for Photo module
*/
public interface Photo {

    interface Model extends Mvp.Model<Photo.Presenter> {
        void getDataFromServer(String url);
    }

    interface View extends Mvp.View {
        void updateDataToView(List<?> data);
    }

    interface Presenter extends Mvp.Presenter<Photo.View, Photo.Model> {
        void requestToModelToGetData(String token);

        void getDataFromModel(List<?> data);
    }
}
