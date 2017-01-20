package luan.com.android_mvp.retrofit;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    public final String END_POINT = "https://api.unsplash.com/";
    private Retrofit retrofit;
    private APIService mApiService;

    private RetrofitAdapter() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(END_POINT)
                .build();

        mApiService = retrofit.create(APIService.class);
    }

    private static class RetrofitHolderInstance {
        public static final RetrofitAdapter instance = new RetrofitAdapter();
    }

    public static RetrofitAdapter getInstance() {
        return RetrofitHolderInstance.instance;
    }

    public APIService getApiService() {
        return mApiService;
    }
}
