package com.ex.container.HandlerMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by August Duet on 6/6/2017.
 */
public class Handler {

    private String method;
    private String handle;
    private String path;

    public Handler() {
    }

    public String getMethod() {
        return method;
    }

    @XmlAttribute(name="method")
    public void setMethod(String method) {
        this.method = method;
    }

    public String getHandle() {
        return handle;
    }

   @XmlElement(name="handle")
    public void setHandle(String handle) {
        this.handle = handle;
    }

    @XmlAttribute(name="path")
    public void setPath(String path){ this.path = path; }

    public String getPath(){ return path; }
}
