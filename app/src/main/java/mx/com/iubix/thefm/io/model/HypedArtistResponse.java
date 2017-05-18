package mx.com.iubix.thefm.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import mx.com.iubix.thefm.domain.Artist;

/**
 * Created by raily on 17/05/2017.
 */

public class HypedArtistResponse {
    @SerializedName(JsonKeys.ARTIST_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtist(){
        return results.artists;
    }

    public void setArtists(ArrayList<Artist> artists){
        this.results.artists = artists;
    }

    private class HypedArtistsResults{
       /* @SerializedName(JsonKeys.ARTIST_ARRAY)
        ArrayList<Artist> artists;*/

       ArrayList<Artist> artists;
    }

}
