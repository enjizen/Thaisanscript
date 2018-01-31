package com.thai_sanscript.thaisanscript.model;

/**
 * Created by streami.t.mobiledeveloper1 on 30/1/2018 AD.
 */

public class DropDownModel {
    private String value;
    private String name;
    /**
     * type ใช้สำหรับ check ว่าเป็น ชื่อ Group รึเปล่า ถ้าเปล่า จะได้
     * ค่าเป็น 1 ถ้าไม่ใช่ จะเป็น 0
     */
    private int type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
