package luan.com.androidmvp.dagger.component;

import dagger.Component;
import luan.com.androidmvp.dagger.ViewScrope;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.view.PhotoActivity;

@ViewScrope
@Component (modules = {PhotoModule.class}, dependencies = {RetrofitComponent.class})
public interface PhotoComponent {
    void inject(PhotoActivity photoActivity);
}
