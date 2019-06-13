package com.example.logincomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.componentlib.ILoginService;

/**
 * author:  ycl
 * date:  2019/06/13 21:38
 * desc:
 */
public class LoginService implements ILoginService {

    @Override
    public void launch(Context context, String targetClass) {
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_TARGET_CLASS,targetClass);
        context.startActivity(intent);
    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fm, int viewId, Bundle bundle) {
        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(bundle);
        fm.beginTransaction()
                .add(viewId, fragment)
                .commit();
        return fragment;
    }
}
