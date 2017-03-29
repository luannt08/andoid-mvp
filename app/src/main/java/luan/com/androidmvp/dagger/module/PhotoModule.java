package luan.com.androidmvp.dagger.module;

import dagger.Module;
import dagger.Provides;
import luan.com.androidmvp.model.PhotoModel;
import luan.com.androidmvp.presenter.PhotoPresenter;
import luan.com.androidmvp.retrofit.RetrofitService;

@Module
public class PhotoModule {

    @Provides
    public PhotoModel provideMainModel(RetrofitService retrofitService) {
        return new PhotoModel(retrofitService);
    }

    @Provides
    public PhotoPresenter provideMainPresenter(PhotoModel mainModel) {
        return new PhotoPresenter(mainModel);
    }
}
