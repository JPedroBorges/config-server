package pt.jpborges.configserver.repository.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.ResponseBody;

@Document(collection = "config")
@ResponseBody
public class ConfigParam {
    @Id
    private String _id;
    private String label;
    private String value;
    private boolean enable;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String description;

    public ConfigParam(String label, String value, boolean enable) {
        this.label = label;
        this.value = value;
        this.enable = enable;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
