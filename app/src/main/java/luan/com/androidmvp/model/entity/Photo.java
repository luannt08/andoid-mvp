package luan.com.androidmvp.model.entity;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("urls")
    private Url mUrls;

    public Url getUrls() {
        return mUrls;
    }
}
