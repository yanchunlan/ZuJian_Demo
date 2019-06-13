package com.example.minecomponent;

import android.app.Application;
import com.example.componentlib.IAppComponent;
import com.example.componentlib.ServiceFactory;

/**
 * author:  ycl
 * date:  2019/06/13 21:27
 * desc:
 */
public class MineApplication extends Application implements IAppComponent {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializa(this);
    }

    @Override
    public void initializa(Application application) {
        sApplication = application;
        ServiceFactory.getInstance().setMineService(new MineService());
    }
}
