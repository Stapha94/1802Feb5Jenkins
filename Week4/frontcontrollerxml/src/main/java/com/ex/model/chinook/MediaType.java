package com.ex.model.chinook;

/**
 * Created by August on 6/18/2017.
 */
public class MediaType {

    private long mediaTypeId;
    private String name;

    MediaType() {
    }

    public long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
