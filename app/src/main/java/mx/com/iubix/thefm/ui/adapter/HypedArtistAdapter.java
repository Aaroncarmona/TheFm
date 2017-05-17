package mx.com.iubix.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.iubix.thefm.R;
import mx.com.iubix.thefm.domain.Artist;

/**
 * Created by raily on 17/05/2017.
 */

public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder>{
    ArrayList<Artist> artists;
    Context context;

    public HypedArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artists, parent, false);
        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.setArtistname(currentArtist.getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){
        if (artists == null )
            throw new NullPointerException("La lista no puede ser NULA ");

        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount(), artists.size());
    }



    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{
        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name_artist);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistname(String name){
            artistName.setText(name);
        }
    }
}
