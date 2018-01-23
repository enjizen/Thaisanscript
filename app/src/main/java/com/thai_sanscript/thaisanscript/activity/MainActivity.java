package com.thai_sanscript.thaisanscript.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bigscreen.iconictabbar.view.IconicTab;
import com.bigscreen.iconictabbar.view.IconicTabBar;
import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.fragment.MainFragment;
import com.thai_sanscript.thaisanscript.fragment.TranslateFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bottom_bar)
    IconicTabBar iconicTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container, MainFragment.newInstance())
                    .commit();
        }

        setListener();
    }

    private void setListener() {

        iconicTabBar.setOnTabSelectedListener(onTabSelectedListener);
    }


    /**********************
     *
     * Listener
     *
     **********************/

    IconicTabBar.OnTabSelectedListener onTabSelectedListener = new IconicTabBar.OnTabSelectedListener() {
        @Override
        public void onSelected(IconicTab tab, int position) {
            switch (tab.getId()) {
                case R.id.bottom_home:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_container, MainFragment.newInstance())
                            .commit();

                    break;
                case R.id.bottom_translate:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_container, TranslateFragment.newInstance())
                            .commit();

                    break;
                case R.id.bottom_article:

                    break;
                case R.id.bottom_hamburger:

                    break;
                default:
                    break;
            }
        }

        @Override
        public void onUnselected(IconicTab tab, int position) {

        }
    };
}
