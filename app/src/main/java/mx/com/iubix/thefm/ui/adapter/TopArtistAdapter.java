package mx.com.iubix.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.com.iubix.thefm.R;
import mx.com.iubix.thefm.domain.Artist;

/**
 * Created by raily on 17/05/2017.
 */

public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistHolder>{
    ArrayList<Artist> artists;
    Context context;

    public TopArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public TopArtistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_top_artist, parent, false);
        return new TopArtistHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopArtistHolder holder, int position) {
        Artist currentArtist = artists.get(position);

        holder.setArtistname(currentArtist.getName());
        holder.setArtistPlayCount(currentArtist.getPlayCount());
        holder.setArtistListeners(currentArtist.getListeners());

        if (currentArtist.getUrlMediumImage() != null ) {
            holder.setArtistImage(currentArtist.getUrlMediumImage());
        }
        else {
            holder.setArtistDefaultImage();
        }

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



    public class TopArtistHolder extends RecyclerView.ViewHolder{

        TextView artistName;
        TextView artistPlayCount;
        TextView artistListeners;

        ImageView artistImage;

        public TopArtistHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txtArtistNameItemTopArtist);
            artistPlayCount = (TextView) itemView.findViewById(R.id.txtPlayCountItemTopArtist);
            artistListeners = (TextView) itemView.findViewById(R.id.txtListenerItemTopArtist);
            artistImage = (ImageView) itemView.findViewById(R.id.imgCoverItemTopArtist);


        }

        public void setArtistname(String name){
            artistName.setText(name);
        }

        public void setArtistPlayCount(String playCount){
            artistPlayCount.setText(playCount);
        }

        public void setArtistListeners(String listeners){
            artistListeners.setText(listeners);
        }

        public void setArtistImage(String url) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.placeholder_artist)
                    .into(artistImage);
        }

        public void setArtistDefaultImage(){
            Picasso.with(context)
                    .load(R.drawable.placeholder_artist)
                    .into(artistImage);
        }
    }
}
