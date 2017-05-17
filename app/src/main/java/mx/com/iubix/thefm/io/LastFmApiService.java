package mx.com.iubix.thefm.io;

import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by raily on 17/05/2017.
 */

public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtist(Callback<HypedArtistResponse> serverResponse);


}
