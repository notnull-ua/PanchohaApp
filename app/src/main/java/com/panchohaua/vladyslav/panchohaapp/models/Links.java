package com.panchohaua.vladyslav.panchohaapp.models;

/**
 * Created by Vladyslav on 21.04.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private Link self;
    @SerializedName("next")
    @Expose
    private Link next;
    @SerializedName("last")
    @Expose
    private Link last;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getLast() {
        return last;
    }

    public void setLast(Link last) {
        this.last = last;
    }

}