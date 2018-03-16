package com.thai_sanscript.thaisanscript.manager.http;


import java.util.List;

/**
 * Created by wanchalermyuphasuk on 26/1/2018 AD.
 */

public interface CallApiServiceManagerListener {

    void translateResponse(List<String> resultList);
}
