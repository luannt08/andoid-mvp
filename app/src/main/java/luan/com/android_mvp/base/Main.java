package luan.com.android_mvp.base;


import java.util.List;

public interface Main {

    interface Model extends Mvp.Model<Main.Presenter> {
        void getDataFromServer(String url);
    }

    interface View extends Mvp.View {
        void updateDataToView(List<?> data);
    }

    interface Presenter extends Mvp.Presenter<Main.View, Main.Model> {
        void requestToModelToGetData(String token);

        void getDataFromModel(List<?> data);
    }
}
