package _Summary_;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Label {
    private String name;

    private int id;

    public Label() {
    }

    public Label(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void parseJsonObject(JSONObject obj) {
        String name = (String) obj.get("name");
        int id = Integer.parseInt(obj.get("id").toString());

        this.name = name;
        this.id = id;
    }

    public void parseCsvObject(String str) {
        String[] properties = str.split(",");
        this.id = Integer.parseInt(properties[0]);
        this.name = properties[1];
    }
}
