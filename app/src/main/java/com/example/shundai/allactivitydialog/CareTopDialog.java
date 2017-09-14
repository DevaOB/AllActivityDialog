package com.example.shundai.allactivitydialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by win7 on 2017/8/28.
 */

public class CareTopDialog extends Dialog {

    @BindView(R.id.rl_care)
    RelativeLayout rlCare;
    @BindView(R.id.rl_care_close)
    RelativeLayout rlCareClose;
    private Handler handler = new Handler();
    private Context context;

    public CareTopDialog(Context context) {
        super(context, R.style.search_dialog);
        this.context = context;
        initView();
    }

    private void initView() {
        View dialogView = LayoutInflater.from(context).inflate(R.layout.careabout_notification_dialog, null);
        ButterKnife.bind(this,dialogView);
        Window window = getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.TOP);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.top_anim_style);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        setCancelable(false);
        setCanceledOnTouchOutside(true);
        //将自定义布局加载到dialog上
        setContentView(dialogView);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 6000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @OnClick({R.id.rl_care, R.id.rl_care_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_care:
                getContext().startActivity(new Intent(context,Main2Activity.class));
                dismiss();
                break;
            case R.id.rl_care_close:
                dismiss();
                break;
        }
    }
}
