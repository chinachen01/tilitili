package com.focus.tilitili.module.setting;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.focus.tilitili.R;
import com.focus.tilitili.base.BaseActivity;
import com.focus.tilitili.databinding.ActivitySettingBinding;
import com.focus.tilitili.utils.PreConstants;
import com.focus.tilitili.utils.PreUtils;

/**
 * Created by focus on 17/4/21.
 */

public class SettingActivity extends BaseActivity implements ColorChooserDialog.ColorCallback{
    private ActivitySettingBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(PreUtils.getInt(this, PreConstants.KEY_THEME, R.style.ThemeBlue));
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_theme:
                PreUtils.putInt(this, PreConstants.KEY_THEME, R.style.ThemePink);
                Intent intent = getIntent();
                overridePendingTransition(0, 0);//不设置进入退出动画
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {

    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }
}
