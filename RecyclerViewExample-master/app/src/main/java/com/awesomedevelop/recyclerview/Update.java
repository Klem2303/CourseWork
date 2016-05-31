package com.awesomedevelop.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klem on 31.05.16.
 */

public class Update {
    @SerializedName("up")
    @Expose
    private List<Up> up = new ArrayList<Up>();

    /**
     *
     * @return
     * The up
     */
    public List<Up> getUp() {
        return up;
    }

    /**
     *
     * @param up
     * The up
     */
    public void setUp(List<Up> up) {
        this.up = up;
    }
}
