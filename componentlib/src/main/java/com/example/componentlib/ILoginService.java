package com.example.componentlib;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * author:  ycl
 * date:  2019/06/13 21:31
 * desc:
 */
public interface ILoginService {

    void launch(Context context, String targetClass);

    Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle);

}
