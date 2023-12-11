package com.android.system.talker.view;



import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;


import com.android.schedule.corelibrary.utils.NwqCallBack;
import com.android.system.talker.R;
import com.android.system.talker.databinding.ViewComboControlBinding;

public class ComboControlsView extends LinearLayoutCompat {

    private ViewComboControlBinding viewComboControlBinding;

    private NwqCallBack<Boolean> selectCallBack;

    public void setSelectCallBack(NwqCallBack<Boolean> selectCallBack) {
        this.selectCallBack = selectCallBack;
    }

    public ComboControlsView(@NonNull Context context) {
        super(context);
    }

    public ComboControlsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setMyAttribute(context,attrs);

    }

    public ComboControlsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMyAttribute(context,attrs);

    }


    private void setMyAttribute(Context context,  @Nullable AttributeSet attrs) {
      if (attrs == null)
            return;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ComboControlsView);
        boolean isSelect = typedArray.getBoolean(R.styleable.ComboControlsView_is_select, false);
        boolean showSelect = typedArray.getBoolean(R.styleable.ComboControlsView_show_select, true);
        int titleStr = typedArray.getResourceId(R.styleable.ComboControlsView_title_str, R.string.app_name);

        viewComboControlBinding = ViewComboControlBinding.inflate(LayoutInflater.from(getContext()),this,true);

        if(!showSelect){
            viewComboControlBinding.sw.setVisibility(GONE);
        }
        viewComboControlBinding.sw.setChecked(isSelect);
        viewComboControlBinding.titleStr.setText(titleStr);
        viewComboControlBinding.sw.setOnClickListener(v -> {
            if(selectCallBack!=null){
                selectCallBack.onCallBack(viewComboControlBinding.sw.isChecked());
            }
        });
        typedArray.recycle();

    }

    public void setChecked(boolean checked) {
        viewComboControlBinding.sw.setChecked(checked);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();


    }
}
