package mx.com.iubix.thefm.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.com.iubix.thefm.domain.Artist;
import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import mx.com.iubix.thefm.io.model.JsonKeys;

public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistResponse>{
    @Override
    public HypedArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        HypedArtistResponse response = gson.fromJson(json, HypedArtistResponse.class);

        //Obtener el objeto artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTIST_RESULTS);

        //Obtener el array de artist
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTIST_ARRAY);

        //Convertir el JsonArray de artist a objetos de la clase Artist
        response.setArtists(extractArtistFromJsonArray(artistArray));

        return response;
    }

    private ArrayList<Artist> extractArtistFromJsonArray(JsonArray array){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0 ; i < array.size() ; i++){
            JsonObject artistData = array.get(i).getAsJsonObject();

            //Se obtuvo el nombre
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            //Se obtuvieron las imagenes
            JsonArray imageArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGE);
            String [] images = extractArtistsImagesFromJsonArray(imageArray);

            artists.add(new Artist(name,images[0],images[1]));
        }
        return artists;
    }

    private String [] extractArtistsImagesFromJsonArray(JsonArray imageArray){
        String [] image = new String[2];
        for (int i = 0 ; i < imageArray.size() ; i++ ){
            JsonObject imageData =  imageArray.get(i).getAsJsonObject();

            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();

            if (url.isEmpty())
                url = null;
            else
                url = url.replace("\\/", "/");

            if(size.matches(JsonKeys.IMAGE_MEDIUM)) {
                image[0] = url;
            }

            else if(size.matches(JsonKeys.IMAGE_LARGE)) {
                url = url.replace("\\/", "/");
                image[1] = url;
            }
        }
        return image;
    }
}
