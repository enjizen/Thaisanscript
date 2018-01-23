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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    @BindView(R.id.recycleViewMain)
    RecyclerView recycleViewMain;




    private RecycleViewAdapter recycleViewAdapter;
    private List<TitleFirstViewModel> titleFirstViewModelList = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle arg = new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);

        bindRecycleView();

        setData();
    }

    private void setData() {

        TitleFirstViewModel titleFirstViewModel = new TitleFirstViewModel();
        titleFirstViewModel.setUrlImage("http://www.thai-sanscript.com/inc/images/slider/bg1.jpg");
        titleFirstViewModel.setTitle("การทำงาน");
        titleFirstViewModel.setTitleDetail("\n" +
                "                                    ไทย-สันสคริปท์ เป็นโปรแกรมช่วยในการปริวรรตอักษร \n" +
                "                                    จาก โรมัน-สันสกฤต มาเป็น ไทย-สันสกฤต ตามมาตรฐาน \n" +
                "                                    International Alphabet of Sanskrit Transliteration (IAST)\n" +
                "                                ");
        titleFirstViewModel.setSubTitleDetail("\n" +
                "                                    ภาษาสันสกฤตมีพัฒนาการมาจาก ภาษาพระเวท ที่ปรากฏในคัมภีร์ฤคเวท \n" +
                "                                    เมื่อราว 1,200 ปีก่อน ค.ศ. \n" +
                "                                    อันเป็นบทสวดสรรเสริญพระเจ้าในลัทธิพราหมณ์ในยุคต้น ๆ \n" +
                "                                    ภาษาพระเวทดั้งเดิมยังมิได้มีการวางกฎเกณฑ์ให้เป็นระเบียบรัดกุมและสละสลวย\n" +
                "                                    และมีหลักทางไวยากรณ์อย่างกว้าง ๆ \n" +
                "                                ");
        titleFirstViewModelList.add(titleFirstViewModel);

        titleFirstViewModel = new TitleFirstViewModel();
        titleFirstViewModel.setUrlImage("http://www.thai-sanscript.com/inc/images/slider/bg2.jpg");
        titleFirstViewModelList.add(titleFirstViewModel);

        recycleViewAdapter.notifyDataSetChanged();
    }

    private void bindRecycleView() {


        recycleViewAdapter = new RecycleViewAdapter(getContext(),titleFirstViewModelList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        recycleViewMain.setLayoutManager(mLayoutManager);
        recycleViewMain.setAdapter(recycleViewAdapter);

    }
}
