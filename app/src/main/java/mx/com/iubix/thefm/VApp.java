package mx.com.iubix.thefm;

import android.app.Application;
import android.content.Context;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class VApp extends Application {
    private static final String TAG =Class.class.getSimpleName() ;
    private static Context instance;

    @Override
    public void onCreate() {


        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                //.assetFile("my.realm")
                .build();
        Realm.setDefaultConfiguration(config);


        instance=this;

        super.onCreate();
    }

    @Override
    public void onLowMemory() {

        super.onLowMemory();
    }

}
