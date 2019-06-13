package com.example.componentlib;

/**
 * author:  ycl
 * date:  2019/06/13 21:48
 * desc:
 */
public class ServiceFactory {

    private static volatile ServiceFactory sInstance = null;

    public static ServiceFactory getInstance() {
        if (sInstance == null) {
            synchronized (ServiceFactory.class) {
                if (sInstance == null) {
                    sInstance = new ServiceFactory();
                }
            }
        }
        return sInstance;
    }

    public ServiceFactory() {
    }

    private ILoginService mLoginService;

    private IMineService mMineService;

    public ILoginService getLoginService() {
        return mLoginService;
    }

    public void setLoginService(ILoginService loginService) {
        mLoginService = loginService;
    }

    public IMineService getMineService() {
        return mMineService;
    }

    public void setMineService(IMineService mineService) {
        mMineService = mineService;
    }
}
