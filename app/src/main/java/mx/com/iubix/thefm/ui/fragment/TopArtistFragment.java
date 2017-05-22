package mx.com.iubix.thefm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.iubix.thefm.R;
import mx.com.iubix.thefm.io.LastFmApiAdapter;
import mx.com.iubix.thefm.io.model.TopArtistResponse;
import mx.com.iubix.thefm.ui.adapter.TopArtistAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class TopArtistFragment extends Fragment {

    private RecyclerView artistList;
    private TopArtistAdapter topArtistAdapter;

    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topArtistAdapter = new TopArtistAdapter(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService()
                .getTopArtists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistResponse>() {
                    @Override
                    public void call(TopArtistResponse topArtistResponse) {
                        topArtistAdapter.addAll(topArtistResponse.getArtist());
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_artist, container, false);
        artistList = (RecyclerView) root.findViewById(R.id.rv_topArtist_list);

        topArtistAdapter = new TopArtistAdapter(getActivity());

        setupList();

        return root;
    }

    public void setupList(){
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(topArtistAdapter);
    }

}
