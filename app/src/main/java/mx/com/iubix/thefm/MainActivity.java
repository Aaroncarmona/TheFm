package mx.com.iubix.thefm;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.com.iubix.thefm.ui.HypedArtistFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( savedInstanceState == null ){
            getSupportFragmentManager().beginTransaction()
                    .add( R.id.fl_main_activity , new HypedArtistFragment() )
                    .commit();
        }

    }
}
