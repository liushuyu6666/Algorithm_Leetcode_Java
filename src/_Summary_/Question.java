package _Summary_;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question {
    private String name;

    private int number;

    private ArrayList<Integer> labels;

    public Question() {
    }

    public Question(String name, int number, ArrayList<Integer> labels) {
        this.name = name;
        this.number = number;
        this.labels = labels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Integer> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Integer> labels) {
        this.labels = labels;
    }

    @SuppressWarnings("unchecked")
    public void parseJsonObject(JSONObject obj) {
        String name = (String) obj.get("name");
        int number = Integer.parseInt(obj.get("number").toString());
        JSONArray jsonArray = (JSONArray) obj.get("labels");
        ArrayList<Integer> labels = new ArrayList<>();

        jsonArray.forEach(item -> labels.add(Integer.parseInt(item.toString())));

        this.name = name;
        this.number = number;
        this.labels = labels;
    }
}
