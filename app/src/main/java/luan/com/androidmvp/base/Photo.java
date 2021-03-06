package luan.com.androidmvp.base;


import java.util.List;

/*
* For each module, we declare the separated module to easy control
* Ex : Photo module has sub mvp to control things of photo module.
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
