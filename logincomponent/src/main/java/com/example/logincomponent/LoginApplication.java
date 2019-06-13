package com.example.logincomponent;

import android.app.Application;

import com.example.componentlib.IAppComponent;
import com.example.componentlib.ServiceFactory;

/**
 * author:  ycl
 * date:  2019/06/13 21:41
 * desc:
 */
public class LoginApplication extends Application implements IAppComponent {

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
        ServiceFactory.getInstance().setLoginService(new LoginService());
    }
}
