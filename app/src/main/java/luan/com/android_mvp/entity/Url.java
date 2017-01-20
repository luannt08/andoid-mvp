package luan.com.android_mvp.entity;

import com.google.gson.annotations.SerializedName;

public class Url {
    @SerializedName("full")
    private String full;

    @SerializedName("regular")
    private String regular;

    @SerializedName("small")
    private String small;

    public String getFull() {
        return full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }
}
