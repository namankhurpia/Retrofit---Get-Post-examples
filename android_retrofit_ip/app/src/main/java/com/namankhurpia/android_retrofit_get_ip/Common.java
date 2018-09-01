package com.namankhurpia.android_retrofit_get_ip;

import com.namankhurpia.android_retrofit_get_ip.remote.RetrofitClient;
import com.namankhurpia.android_retrofit_get_ip.remote.ipService;

/**
 * Created by Naman Khurpia on 11-05-2018.
 */

public class Common {

    public static final String BASE_URL="http://ip.jsontest.com/";

    public static ipService getipservice()
    {
        return RetrofitClient.getClient(BASE_URL).create(ipService.class);
    }
}
