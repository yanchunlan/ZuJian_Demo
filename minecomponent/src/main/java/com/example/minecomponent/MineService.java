package com.example.minecomponent;

import android.content.Context;
import android.content.Intent;

import com.example.componentlib.IMineService;

/**
 * author:  ycl
 * date:  2019/06/13 22:17
 * desc:
 */
public class MineService implements IMineService {

    private static final String USERID = "userId";

    @Override
    public void launch(Context context, int userId) {
        Intent intent = new Intent(context,MineActivity.class);
        intent.putExtra(MineService.USERID,userId);
        context.startActivity(intent);
    }
}
