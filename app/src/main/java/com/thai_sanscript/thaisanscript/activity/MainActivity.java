package com.thai_sanscript.thaisanscript.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.fragment.MainFragment;
import com.thai_sanscript.thaisanscript.fragment.TranslateFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;





    private final String TAG_MAIN_FRAGMENT = "MainFragment";
    private final String TAG_TRANSLATE_FRAGMENT = "TranslateFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        if (savedInstanceState == null) {

            MainFragment mainFragment = MainFragment.newInstance();
            TranslateFragment translateFragment = TranslateFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container,translateFragment, TAG_TRANSLATE_FRAGMENT)
                    .attach(translateFragment)
                    .commit();


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container, mainFragment,TAG_MAIN_FRAGMENT)
                    .attach(mainFragment)
                    .detach(mainFragment)
                    .commit();




        }
        bottomNavigation.setSelectedItemId(R.id.item_translate);
        setListener();



    }



    private void setListener() {

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item_main:
                        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);
                        TranslateFragment translateFragment = (TranslateFragment) getSupportFragmentManager().findFragmentByTag(TAG_TRANSLATE_FRAGMENT);
                        getSupportFragmentManager().beginTransaction()
                                .attach(mainFragment)
                                .detach(translateFragment)
                                .commit();
                        return true;
                    case R.id.item_translate:
                         mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT);
                         translateFragment = (TranslateFragment) getSupportFragmentManager().findFragmentByTag(TAG_TRANSLATE_FRAGMENT);
                        getSupportFragmentManager().beginTransaction()
                                .attach(translateFragment)
                                .detach(mainFragment)
                                .commit();
                        return true;
                }

                return false;
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
