package mx.com.iubix.thefm.io;

import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import mx.com.iubix.thefm.io.model.TopArtistResponse;
import retrofit.Callback;
import retrofit.http.GET;
import rx.Observable;


/**
 * Created by raily on 17/05/2017.
 */

public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtist(Callback<HypedArtistResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ARTISTS)
    Observable<TopArtistResponse> getTopArtists();

    /*@GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(@Query(ApiConstants.PARAM_API_KEY) String key,Callback<HypedArtistResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ARTIST)
    void getTopArtists(@Query(ApiConstants.PARAM_API_KEY) String key,Callback<TopArtistsResponse> serverRespones);*/

}
