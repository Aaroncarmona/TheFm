package mx.com.iubix.thefm.domain;

import com.google.gson.annotations.SerializedName;

import mx.com.iubix.thefm.io.model.JsonKeys;

/**
 * Created by raily on 16/05/2017.
 */

public class Artist {

    @SerializedName(JsonKeys.ARTIST_NAME)
    private String name;
    private String urlMediumImage;
    private String urlLargeImage;

    public Artist(){

    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist(String name, String urlMediumImage , String urlLargeImage){
        this.name = name;
        this.urlMediumImage = urlMediumImage;
        this.urlLargeImage = urlLargeImage;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
