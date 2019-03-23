package mx.com.iubix.thefm;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.upax.zeusloginsdk.entity.User;
import com.upax.zeusloginsdk.interfaces.ILoginZeusResult;
import com.upax.zeusloginsdk.ui.login.LoginFragment;
import com.upax.zeusloginsdk.util.Util;

import java.util.ArrayList;

import mx.com.iubix.thefm.ui.adapter.PagerAdapter;
import mx.com.iubix.thefm.ui.fragment.HypedArtistFragment;
import mx.com.iubix.thefm.ui.fragment.TopArtistFragment;

public class MainActivity extends AppCompatActivity implements ILoginZeusResult {
    private static final String TAG = MainActivity.class.getSimpleName();

    Toolbar toolbar;

    ViewPager viewPager;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setupViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private void setupViewPager(){
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragment()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private ArrayList<Fragment> buildFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(LoginFragment.newInstance());
        fragments.add(new HypedArtistFragment());
        fragments.add(new TopArtistFragment());

        return fragments;
    }

    @Override
    public void loginSuccess(User user) {
        Util.toast(getBaseContext() , user.getName());
    }

    @Override
    public void loginError(Exception e) {
        Util.toast(getBaseContext() , e.getMessage());

    }
}
