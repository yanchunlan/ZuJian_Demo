package com.example.zujian_demo;

import android.app.Application;

import com.example.componentlib.AppConfig;
import com.example.componentlib.IAppComponent;

/**
 * author:  ycl
 * date:  2019/06/10 22:53
 * desc:
 */
public class MainApplication extends Application implements IAppComponent {

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

        // 如果是它自己是一个Application就会自己注入，如果不是application，就在当前主Application里面注册
        // 将主app的上下文传到login以及mine application中
        for (String component : AppConfig.COMPONENTS) {
            try {
                Class<?> clazz = Class.forName(component);
                Object object = clazz.newInstance();
                if (object instanceof IAppComponent) {
                    ((IAppComponent) object).initializa(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
