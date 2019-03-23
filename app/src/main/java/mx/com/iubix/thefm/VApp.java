package mx.com.iubix.thefm;

import android.app.Application;
import android.content.Context;

import com.upax.surveyssdk.Factory.ZeusSurveys;
import com.upax.surveyssdk.Utilities.ZeusException;
import com.upax.surveyssdk.Utils.LogClass;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class VApp extends Application {
    private static final String TAG =Class.class.getSimpleName() ;
    private static ZeusSurveys zeusSurveys;
    private static Context instance;

    @Override
    public void onCreate() {
        LogClass.d(TAG, "Oncreate");


        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                //.assetFile("my.realm")
                .build();
        Realm.setDefaultConfiguration(config);


        instance=this;
        getSurveyContext();

        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        LogClass.d(TAG,"onLowMemory");

        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        LogClass.d(TAG,"onTrimMemory "+level);

        super.onTrimMemory(level);
    }

    public static ZeusSurveys getSurveyContext() {
        try {
            if(zeusSurveys==null)
                zeusSurveys = new ZeusSurveys(instance,"DemoZeus","FISH" , instance.getPackageName());

        } catch (ZeusException e) {
            e.printStackTrace();
        }
        return zeusSurveys;
    }
}
