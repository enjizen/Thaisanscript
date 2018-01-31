package com.thai_sanscript.thaisanscript.activity;


import android.os.Bundle;
import android.util.Log;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;
import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.fragment.MainFragment;
import com.thai_sanscript.thaisanscript.fragment.TranslateFragment;
import com.thai_sanscript.thaisanscript.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigation bottomNavigation;

    private int selectedNumber;




    private final String TAG_MAIN_FRAGMENT = "MainFragment";
    private final String TAG_TRANSLATE_FRAGMENT = "TranslateFragment";
    private final String SELECTED_NUMBER = "selected number";
    private boolean firstOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            MainFragment mainFragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container, mainFragment,TAG_MAIN_FRAGMENT)
                    .attach(mainFragment)
                    .commit();


            TranslateFragment translateFragment = TranslateFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container,translateFragment, TAG_TRANSLATE_FRAGMENT)
                    .detach(translateFragment)
                    .commit();

        }
        else{
            LogUtil.getInstance().i("MainActivity","Selected Number = " + selectedNumber);
        }



        setListener();


    }



    private void setListener() {
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int i) {
                switch (i) {
                    case R.id.tab_home:

                        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);
                        TranslateFragment translateFragment = (TranslateFragment) getSupportFragmentManager().findFragmentByTag(TAG_TRANSLATE_FRAGMENT);

                        if(!firstOpen) {
                            selectedNumber = 0;
                            getSupportFragmentManager().beginTransaction()
                                    .attach(mainFragment)
                                    .detach(translateFragment)
                                    .commit();
                        }
                        else{
                            firstOpen = false;
                        }


                        break;
                    case R.id.tab_translate:

                        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);
                        translateFragment = (TranslateFragment) getSupportFragmentManager().findFragmentByTag(TAG_TRANSLATE_FRAGMENT);

                        getSupportFragmentManager().beginTransaction()
                                .attach(translateFragment)
                                .detach(mainFragment)
                                .commit();

                        selectedNumber = 1;
                        break;
                    case R.id.tab_article:

                        break;
                    case R.id.tab_more:

                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SELECTED_NUMBER,selectedNumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        selectedNumber = savedInstanceState.getInt(SELECTED_NUMBER);
    }
}
