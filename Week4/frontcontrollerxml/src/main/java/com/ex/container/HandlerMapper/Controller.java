package com.ex.container.HandlerMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by August Duet on 6/6/2017.
 */
public class Controller {

    private String path;
    private String clazz;
    private List<Handler> handlerList = new ArrayList<>();

    public Controller() {
    }

    public String getClazz() {
        return clazz;
    }

    @XmlAttribute(name="class")
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getPath() {
        return path;
    }

    @XmlAttribute(name="path")
    public void setPath(String path) {
        this.path = path;
    }

    public List<Handler> getHandlerList() {
        return handlerList;
    }

    @XmlElement(name="handler")
    public void setHandlerList(List<Handler> handlerList) {
        this.handlerList = handlerList;
    }
}
