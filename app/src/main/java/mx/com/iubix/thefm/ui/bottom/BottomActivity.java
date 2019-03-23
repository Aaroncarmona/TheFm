package mx.com.iubix.thefm.ui.bottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.iubix.thefm.R;
import mx.com.iubix.thefm.ui.fragment.HypedArtistFragment;
import mx.com.iubix.thefm.ui.fragment.TopArtistFragment;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>(){{
        add(new HypedArtistFragment());
        add(new TopArtistFragment());
    }};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replace(fragments.get(0));
                    return true;
                case R.id.navigation_dashboard:
                    replace(fragments.get(1));
                    return true;
                case R.id.navigation_notifications:
                    replace(fragments.get(2));
                    return true;
            }
            return false;
        }
    };

    public void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.replace( R.id.fragment , fragment );
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
