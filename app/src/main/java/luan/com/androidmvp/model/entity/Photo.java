package luan.com.androidmvp.model.entity;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("urls")
    private Url mUrls;

    @SerializedName("color")
    private String mColor;

    public Url getUrls() {
        return mUrls;
    }

    public String getColor() {
        return mColor;
    }
}
