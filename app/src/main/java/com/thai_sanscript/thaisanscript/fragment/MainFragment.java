package com.thai_sanscript.thaisanscript.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.adapter.RecycleViewAdapter;
import com.thai_sanscript.thaisanscript.model.TitleFirstViewModel;
import com.thai_sanscript.thaisanscript.view.ScopeOfWorkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.recycleViewMain)
    RecyclerView recycleViewMain;

    /*@BindView(R.id.scope_of_work_1)
    ScopeOfWorkView scopeOfWorkView1;*/

   /* @BindView(R.id.testExpandable)
    TextView testExpandable;

    @BindView(R.id.expandable_layout)
    ExpandableLayout expandableLayout;*/

    private final String RECYCLE_VIEW_MAIN_POSITION = "Recycle View Main Position";
    private static final String POSITION = "position";




    private RecycleViewAdapter recycleViewAdapter;
    private List<TitleFirstViewModel> titleFirstViewModelList;
    private int recycleLastPosition;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * new Instance Fragment
     * @return
     */
    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle arg = new Bundle();
        arg.putInt(POSITION,0);
        fragment.setArguments(arg);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setData();


        if(savedInstanceState != null){
            onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,rootView);
        setUpListener();
        setUpViewData();
        return rootView;
    }

    private void setUpListener() {
       /* testExpandable.setOnClickListener(this);
        expandableLayout.setOnClickListener(this);*/
    }

    private void setUpViewData() {
        bindRecycleView();
        recycleViewAdapter.notifyDataSetChanged();
        recycleViewMain.scrollToPosition(getArguments().getInt(POSITION));

    }


    /**
     * Set Data Slide
     */
    private void setData() {
        titleFirstViewModelList  = new ArrayList<>();

        TitleFirstViewModel titleFirstViewModel = new TitleFirstViewModel();
        titleFirstViewModel.setUrlImage(getString(R.string.url_image_one));
        titleFirstViewModel.setTitle(getString(R.string.title_page_one));
        titleFirstViewModel.setTitleDetail(getString(R.string.title_detail_page_one));
        titleFirstViewModel.setSubTitleDetail(getString(R.string.title_sub_detail_page_one));
        titleFirstViewModelList.add(titleFirstViewModel);

        titleFirstViewModel = new TitleFirstViewModel();
        titleFirstViewModel.setUrlImage(getString(R.string.url_image_two));
        titleFirstViewModel.setTitle(getString(R.string.title_page_two));
        titleFirstViewModel.setTitleDetail(getString(R.string.title_detail_page_two));
        titleFirstViewModel.setSubTitleDetail(getString(R.string.title_sub_detail_page_two));
        titleFirstViewModelList.add(titleFirstViewModel);

        titleFirstViewModel = new TitleFirstViewModel();
        titleFirstViewModel.setUrlImage(getString(R.string.url_image_three));
        titleFirstViewModel.setTitle(getString(R.string.title_page_three));
        titleFirstViewModel.setTitleDetail(getString(R.string.title_detail_page_three));
        titleFirstViewModel.setSubTitleDetail(getString(R.string.title_sub_detail_page_three));
        titleFirstViewModelList.add(titleFirstViewModel);


    }

    /**
     * Bind Recycle View
     */
    private void bindRecycleView() {

        recycleViewAdapter = new RecycleViewAdapter(getContext(),titleFirstViewModelList);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recycleViewMain.setLayoutManager(mLayoutManager);
        recycleViewMain.setAdapter(recycleViewAdapter);
        recycleViewMain.setItemAnimator(new SlideInLeftAnimator());
        recycleViewMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                recycleLastPosition = mLayoutManager.findLastVisibleItemPosition();

                getArguments().putInt(POSITION,recycleLastPosition);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RECYCLE_VIEW_MAIN_POSITION,recycleLastPosition);
    }

    /**
     * @param savedInstanceState
     */
    private void onRestoreInstanceState(Bundle savedInstanceState){
         recycleLastPosition = savedInstanceState.getInt(RECYCLE_VIEW_MAIN_POSITION);
    }

    @Override
    public void onClick(View v) {
      /*  switch (v.getId()){
            case R.id.testExpandable:
                    expandableLayout.expand(true);
                break;
        }*/
    }
}
