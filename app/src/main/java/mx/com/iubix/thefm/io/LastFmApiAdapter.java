package mx.com.iubix.thefm.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.iubix.thefm.BuildConfig;
import mx.com.iubix.thefm.io.deserializer.HypedArtistsDeserializer;
import mx.com.iubix.thefm.io.deserializer.TopArtistsDeserializer;
import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import mx.com.iubix.thefm.io.model.TopArtistResponse;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

public class LastFmApiAdapter {
    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){
        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);

        }
        return API_SERVICE;
    }

    private static GsonConverter buildLastFmApiGsonConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistResponse.class, new HypedArtistsDeserializer())
                .registerTypeAdapter(TopArtistResponse.class, new TopArtistsDeserializer())
                .create();
        return new GsonConverter(gsonConf);

    }
    /*
    public static Observable<HypedArtistResponse> getHypedArtist(){
        return getApiService().getHypedArtist(obtainApiKey());
    }

    public static Observable<TopArtistResponse> getTopArtist(){
        return getApiService().getTopArtists(obtainApiKey());
    }*/

    private static String obtainApiKey(){
        return BuildConfig.LAST_FM_API_KEY;
    }
}