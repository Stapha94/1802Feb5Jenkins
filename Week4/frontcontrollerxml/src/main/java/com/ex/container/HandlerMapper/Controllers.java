package com.ex.container.HandlerMapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by August Duet on 6/6/2017.
 */
@XmlRootElement
public class Controllers {
    List<Controller> controllerList = new ArrayList<>();

    public Controllers() {
    }

    public List<Controller> getControllerList() {
        return controllerList;
    }

    @XmlElement(name="controller")
    public void setControllerList(List<Controller> controllerList) {
        this.controllerList = controllerList;
    }
}
