package com.thai_sanscript.thaisanscript.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.model.DropDownModel;

import java.util.List;


/**
 * Created by wanchalermyuphasuk on 30/10/2017 AD.
 */

public class SpinnerWordAdapter extends BaseAdapter {

    private List<DropDownModel> dropDownModelList;
    LayoutInflater inflater;

    public SpinnerWordAdapter(Context context, List<DropDownModel> dropDownModelList) {
        this.dropDownModelList = dropDownModelList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dropDownModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean isEnabled(int position) {
        return dropDownModelList.get(position).getType() != 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        switch (dropDownModelList.get(i).getType()) {
            case 0:
                return setViewItem(i);
            case 1:
                return setViewGroupHeader(i);
            default:
                return view;
        }

    }

    public int getItemId(String itemName){
        for (int position = 0 ;position < dropDownModelList.size(); position++) {
            if(dropDownModelList.get(position).getName().equals(itemName)){
                return position;
            }
        }

        return 0;
    }

    @NonNull
    private View setViewItem(int i) {
        View view = inflater.inflate(R.layout.item_spinner_item, null);
        TextView itemName = view.findViewById(R.id.item_name);
        itemName.setText(dropDownModelList.get(i).getName());
        return view;
    }

    @NonNull
    private View setViewGroupHeader(int i) {
        View view = inflater.inflate(R.layout.item_spinner_group_header, null);
        TextView itemName = view.findViewById(R.id.item_group);
        itemName.setText(dropDownModelList.get(i).getName());
        return view;
    }
}
