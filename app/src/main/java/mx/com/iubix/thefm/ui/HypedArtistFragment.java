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

import mx.com.iubix.thefm.MainActivity;
import mx.com.iubix.thefm.R;

public class HypedArtistFragment extends Fragment {

    public static final String LOG_TAG = HypedArtistFragment.class.getName();
    public static final int NUM_COLS = 2;

    private RecyclerView mHyRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artist, container , false );

        mHyRecyclerView = (RecyclerView) root.findViewById(R.id.rv_hyped_artist);

        return root;
    }

    public void setup(){
        mHyRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COLS));
    }
}
