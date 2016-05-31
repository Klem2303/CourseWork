package com.awesomedevelop.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by klem on 31.05.16.
 */

public class Up {
    @SerializedName("1")
    @Expose
    private String _1;

    /**
     *
     * @return
     * The _1
     */
    public String get1() {
        return _1;
    }

    /**
     *
     * @param _1
     * The 1
     */
    public void set1(String _1) {
        this._1 = _1;
    }
}
