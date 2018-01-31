package com.thai_sanscript.thaisanscript.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.view.state.BundleSavedState;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ScopeOfWorkView extends BaseCustomViewGroup {




    private String text = "";
    private String textContent = "";
    private boolean selected;


    private TextView scopeOfWorkDetail;
    private TextView titleScopeOfWork;
    private ToggleButton toggleButton;
    private ImageView imageBackgroundView;
    private Animation slideUp;


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


         slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        // findViewById here

        titleScopeOfWork = findViewById(R.id.title_scope_of_work);
        scopeOfWorkDetail = findViewById(R.id.detail_scope_of_work);
        toggleButton = findViewById(R.id.toggle_button);

        imageBackgroundView = findViewById(R.id.image_background_view);

        toggleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){
                    setSelected(true);
                }
                else {
                    setSelected(false);
                }
            }
        });



    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.scope_of_work,
                defStyleAttr, defStyleRes);

        try {
            updateAttribute(typedArray);

        } finally {
            typedArray.recycle();
        }

    }

    private void updateAttribute(TypedArray typedArray) {
        text = typedArray.getString(R.styleable.scope_of_work_textTitle);
        textContent = typedArray.getString(R.styleable.scope_of_work_textContent);
        selected = typedArray.getBoolean(R.styleable.scope_of_work_selected,false);
        updateView();

    }

    private void updateView(){
        this.setTitleText(text);
        this.setContentText(textContent);
        this.setSelected(selected);
    }


    public void setTitleText(String text){
        this.titleScopeOfWork.setText(text);
    }

    public void setContentText(String text){
        this.scopeOfWorkDetail.setText(text);
    }

    public void setSelected(boolean isSelected){
        if(isSelected) {
            titleScopeOfWork.setBackgroundColor(getResources().getColor(R.color.black));
            imageBackgroundView.setBackgroundColor(getResources().getColor(R.color.red));
            toggleButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_arrow_white));
            toggleButton.setChecked(true);

            scopeOfWorkDetail.startAnimation(slideUp);
            scopeOfWorkDetail.setVisibility(View.VISIBLE);

        }
        else{
            titleScopeOfWork.setBackgroundColor(getResources().getColor(R.color.dark_grey));
            imageBackgroundView.setBackgroundColor(getResources().getColor(R.color.dark_grey));
            toggleButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_arrow_black));
            toggleButton.setChecked(false);
            scopeOfWorkDetail.startAnimation(slideUp);
            scopeOfWorkDetail.setVisibility(View.GONE);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        savedState.getBundle().putBoolean("selected",selected);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();


        selected = bundle.getBoolean("selected");

        this.setSelected(selected);


        // Restore State from bundle here
    }



}
