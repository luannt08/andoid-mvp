package luan.com.android_mvp.retrofit;

import java.util.List;

import luan.com.android_mvp.entity.Photo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIService {
    @GET("photos")
    Observable<List<Photo>> getPhotoNewWithOrderBy(
            @Query("access_token") String accessToken
    );
}
