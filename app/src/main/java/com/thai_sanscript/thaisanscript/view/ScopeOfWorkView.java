package com.thai_sanscript.thaisanscript.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.view.state.BundleSavedState;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ScopeOfWorkView extends BaseCustomViewGroup {

    private TextView tvTitle;


    public ScopeOfWorkView(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public ScopeOfWorkView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public ScopeOfWorkView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public ScopeOfWorkView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.view_scope_of_work, this);
    }

    private void initInstances() {
        // findViewById here

        tvTitle = findViewById(R.id.tv_scope_of_work_title);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.scope_of_work,
                defStyleAttr, defStyleRes);

        try {
            updateView(typedArray);

        } finally {
            typedArray.recycle();
        }

    }

    private void updateView(TypedArray typedArray) {
        this.setText(typedArray.getString(R.styleable.scope_of_work_text));
    }


    public void setText(String text){
        this.tvTitle.setText(text);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }


}
