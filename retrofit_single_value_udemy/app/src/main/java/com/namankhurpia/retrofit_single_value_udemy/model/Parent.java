package com.namankhurpia.retrofit_single_value_udemy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parent {


        @SerializedName("RestResponse")
        @Expose
        private RestResponse restResponse;

        public RestResponse getRestResponse() {
            return restResponse;
        }

        public void setRestResponse(RestResponse restResponse) {
            this.restResponse = restResponse;
        }


}
