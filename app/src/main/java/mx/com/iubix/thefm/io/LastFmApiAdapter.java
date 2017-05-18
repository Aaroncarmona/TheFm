package mx.com.iubix.thefm.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.iubix.thefm.io.deserializer.HypedArtistsDeserializer;
import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

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
                .create();
        return new GsonConverter(gsonConf);

    }

}