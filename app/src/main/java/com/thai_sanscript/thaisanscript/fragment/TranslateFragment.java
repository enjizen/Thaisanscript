package com.thai_sanscript.thaisanscript.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.model.DropDownModel;
import com.thai_sanscript.thaisanscript.adapter.SpinnerWordAdapter;
import com.thai_sanscript.thaisanscript.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateFragment extends BaseFragment {

    @BindView(R.id.tvHello)
    TextView tvHello;

    @BindView(R.id.spinner_source_type)
    AppCompatSpinner spinnerSourceType;

    @BindView(R.id.spinner_destination_type)
    AppCompatSpinner spinnerDestinationType;

    @BindView(R.id.spinner_lang)
    AppCompatSpinner spinnerLang;

    @BindView(R.id.btn_exchange)
    Button btnExchange;

    private List<DropDownModel> dropDownSourceTypeList = new ArrayList<>();
    private List<DropDownModel> dropDownDestinationTypeList = new ArrayList<>();
    private List<DropDownModel> dropDownLanguageList = new ArrayList<>();


    public TranslateFragment() {
        // Required empty public constructor
    }

    public static TranslateFragment newInstance() {
        TranslateFragment fragment = new TranslateFragment();
        Bundle arg = new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_translate, container, false);
        ButterKnife.bind(this, rootView);
        setUpViewData();
        setUpListener();
        return rootView;
    }


    private void setUpViewData() {
        setSpinnerSourceType();
        setDestinationType();
        setLanguage();
    }


    private void setSpinnerSourceType() {

        // Group อุษาคเนย์
        DropDownModel dropDownModel = new DropDownModel();
        dropDownModel.setName(getString(R.string.drop_down_name_uae));
        dropDownModel.setType(1);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_thai));
        dropDownModel.setName(getString(R.string.drop_down_name_thai_traditional));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_burmese));
        dropDownModel.setName(getString(R.string.drop_down_name_myanmar));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        // Group อินเดีย
        dropDownModel = new DropDownModel();
        dropDownModel.setName(getString(R.string.drop_down_name_india));
        dropDownModel.setType(1);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_devanagari));
        dropDownModel.setName(getString(R.string.drop_down_name_devanagari));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_bengali));
        dropDownModel.setName(getString(R.string.drop_down_name_bengali));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_gurmukhi));
        dropDownModel.setName(getString(R.string.drop_down_name_kurum));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_gujarati));
        dropDownModel.setName(getString(R.string.drop_down_name_gujarati));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_oriya));
        dropDownModel.setName(getString(R.string.drop_down_name_oriya));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_tamil));
        dropDownModel.setName(getString(R.string.drop_down_name_tamil));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_telugu));
        dropDownModel.setName(getString(R.string.drop_down_name_telugu));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_kannada));
        dropDownModel.setName(getString(R.string.drop_down_name_kannada));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_malayalam));
        dropDownModel.setName(getString(R.string.drop_down_name_malayalam));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        // Group โรมัน
        dropDownModel = new DropDownModel();
        dropDownModel.setName(getString(R.string.drop_down_name_roman));
        dropDownModel.setType(1);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_iast));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_iast));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_kolkata));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_kolkata));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_itrans));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_itrans));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_harvard_kyoto));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_harvard_kyoto));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_slp));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_slp));
        dropDownModel.setType(0);
        dropDownSourceTypeList.add(dropDownModel);


        SpinnerWordAdapter spinnerSourceTypeAdapter = new SpinnerWordAdapter(getContext(), dropDownSourceTypeList);
        spinnerSourceType.setAdapter(spinnerSourceTypeAdapter);
        int positionSourceType = spinnerSourceTypeAdapter.getItemId(getString(R.string.drop_down_name_devanagari));
        spinnerSourceType.setSelection(positionSourceType);
    }

    private void setDestinationType() {
        // Group อินเดีย
        DropDownModel dropDownModel = new DropDownModel();
        dropDownModel.setName(getString(R.string.drop_down_name_india));
        dropDownModel.setType(1);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_devanagari));
        dropDownModel.setName(getString(R.string.drop_down_name_devanagari));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_bengali));
        dropDownModel.setName(getString(R.string.drop_down_name_bengali));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_gurmukhi));
        dropDownModel.setName(getString(R.string.drop_down_name_kurum));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_gujarati));
        dropDownModel.setName(getString(R.string.drop_down_name_gujarati));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_oriya));
        dropDownModel.setName(getString(R.string.drop_down_name_oriya));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_tamil));
        dropDownModel.setName(getString(R.string.drop_down_name_tamil));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_telugu));
        dropDownModel.setName(getString(R.string.drop_down_name_telugu));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_kannada));
        dropDownModel.setName(getString(R.string.drop_down_name_kannada));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_malayalam));
        dropDownModel.setName(getString(R.string.drop_down_name_malayalam));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);


        dropDownModel = new DropDownModel();
        dropDownModel.setName(getString(R.string.drop_down_name_roman));
        dropDownModel.setType(1);
        dropDownDestinationTypeList.add(dropDownModel);


        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_iast));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_iast));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_kolkata));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_kolkata));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_itrans));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_itrans));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_harvard_kyoto));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_harvard_kyoto));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue(getString(R.string.drop_down_value_roman_slp));
        dropDownModel.setName(getString(R.string.drop_down_name_roman_slp));
        dropDownModel.setType(0);
        dropDownDestinationTypeList.add(dropDownModel);


        SpinnerWordAdapter spinnerDestinationTypeAdapter = new SpinnerWordAdapter(getContext(), dropDownDestinationTypeList);
        spinnerDestinationType.setAdapter(spinnerDestinationTypeAdapter);

        int positionDestinationType = spinnerDestinationTypeAdapter.getItemId(getString(R.string.drop_down_name_roman_iast));
        spinnerDestinationType.setSelection(positionDestinationType);

    }

    private void setLanguage() {
        DropDownModel dropDownModel = new DropDownModel();
        dropDownModel.setValue("sans");
        dropDownModel.setName("สันสกฤต");
        dropDownModel.setType(0);
        dropDownLanguageList.add(dropDownModel);

        dropDownModel = new DropDownModel();
        dropDownModel.setValue("pali");
        dropDownModel.setName("บาฬี");
        dropDownModel.setType(0);
        dropDownLanguageList.add(dropDownModel);

        SpinnerWordAdapter spinnerLanguageAdapter = new SpinnerWordAdapter(getContext(), dropDownLanguageList);
        spinnerLang.setAdapter(spinnerLanguageAdapter);

        int positionDestinationType = spinnerLanguageAdapter.getItemId(getString(R.string.drop_down_name_roman_iast));
        spinnerLang.setSelection(positionDestinationType);
    }

    private void setUpListener() {
        spinnerSourceType.setOnItemSelectedListener(sourceTypeListener);
        spinnerDestinationType.setOnItemSelectedListener(destinationType);
        spinnerLang.setOnItemSelectedListener(langListener);

        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApiService().getProvince("ทดสอบ","sans");
            }
        });
    }

    /***********************
     * Variable Listener
     ***********************/


    AdapterView.OnItemSelectedListener sourceTypeListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener destinationType = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener langListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}
