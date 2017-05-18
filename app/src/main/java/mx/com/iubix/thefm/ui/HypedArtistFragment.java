package mx.com.iubix.thefm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.iubix.thefm.MainActivity;
import mx.com.iubix.thefm.R;
import mx.com.iubix.thefm.domain.Artist;
import mx.com.iubix.thefm.io.ApiConstants;
import mx.com.iubix.thefm.io.LastFmApiAdapter;
import mx.com.iubix.thefm.io.model.HypedArtistResponse;
import mx.com.iubix.thefm.ui.adapter.HypedArtistAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

public class HypedArtistFragment extends Fragment implements Callback<HypedArtistResponse> {

    public static final String LOG_TAG = HypedArtistFragment.class.getName();
    public static final int NUM_COLS = 2;

    private RecyclerView mHyperArtistList;
    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistAdapter(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artist, container , false );

        mHyperArtistList = (RecyclerView) root.findViewById(R.id.rv_hyped_artist);

        setupArtistList();

        mHyperArtistList.addItemDecoration(new ItemOffsetDecoration(getActivity(),R.integer.offset));
        return root;
    }

    public void setupArtistList(){
        mHyperArtistList.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COLS));
        mHyperArtistList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService()
                .getHypedArtist(this);

    }

    private void setDummyContent(){
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("No hay artistas disponibles..." ));
        adapter.addAll(artists);
    }

    @Override
    public void success(HypedArtistResponse hypedArtistResponse, Response response) {
        adapter.addAll(hypedArtistResponse.getArtist());
    }

    @Override
    public void failure(RetrofitError error) {
        setDummyContent();
        error.printStackTrace();
    }
}
