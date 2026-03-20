package hello.servlet.web;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private String vieName;
    private Map<String,Object> model=new HashMap<>();

    public ModelView(String vieName){
        this.vieName=vieName;
    }

    public String getVieName() {
        return vieName;
    }

    public void setVieName(String vieName) {
        this.vieName = vieName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
