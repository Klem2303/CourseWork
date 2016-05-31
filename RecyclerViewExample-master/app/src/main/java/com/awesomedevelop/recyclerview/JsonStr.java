package com.awesomedevelop.recyclerview;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonStr {
    @SerializedName("path")
    @Expose
    private List<Path> path = new ArrayList<>();
    public List<Path> getPath() {
        return path;
    }
    public void setPath(List<Path> path) {
        this.path = path;
    }
}

