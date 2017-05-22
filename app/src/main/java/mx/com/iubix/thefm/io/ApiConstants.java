package mx.com.iubix.thefm.io;

/**
 * Created by raily on 17/05/2017.
 */

public class ApiConstants {

    public static final String API_KEY = "6607277371d9085d83ac451bddcf1836";
    public static final String URL_BASE= "http://ws.audioscrobbler.com";
    public static final String PATH_VERSION = "/2.0/";

    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";

    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.gettopartists";
    public static final String VALUE_TOP_ARTIST = "chart.gettopartists";

    public static final String VALUE_JSON = "json";


    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "?" +
            PARAM_API_KEY + "=" + API_KEY + "&" +
            PARAM_METHOD + "=" + VALUE_HYPED_ARTIST_METHOD + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;


    public static final String URL_TOP_ARTISTS = PATH_VERSION + "?" +
            PARAM_API_KEY + "=" + API_KEY + "&" +
            PARAM_METHOD + "=" + VALUE_TOP_ARTIST + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;
}
