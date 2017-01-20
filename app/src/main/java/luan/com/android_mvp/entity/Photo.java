package luan.com.android_mvp.entity;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("urls")
    private Url urls;

    public Url getUrls() {
        return urls;
    }
}
