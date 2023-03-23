package _Summary_;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String name;

    private int number;

    private ArrayList<Integer> labels;

    private ArrayList<Integer> prerequisites;

    public Question() {
    }

    public Question(String name, int number, ArrayList<Integer> labels, ArrayList<Integer> prerequisites) {
        this.name = name;
        this.number = number;
        this.labels = labels;
        this.prerequisites = prerequisites;
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

    public ArrayList<Integer> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Integer> prerequisites) {
        this.prerequisites = prerequisites;
    }

    private void readArrayProperty(String arrayStr, ArrayList<Integer> property) {
        String[] labelsArray = arrayStr.replaceAll("[\\[\\]\"]", "").split(";");
        for (String labelStr : labelsArray) {
            try {
                property.add(Integer.parseInt(labelStr));
            } catch (NumberFormatException ignored) {}
        }
    }

    private String printArrayProperty(String name, ArrayList<Integer> property) {
        StringBuilder print = new StringBuilder(name + ": [ ");

        for (Integer item : property) {
            print.append(item).append(" ");
        }

        print.append("],");

        return print.toString();
    }

    public void parseCsvObject(String str) {
        String[] properties = str.split(",");

        this.number = Integer.parseInt(properties[0]);
        this.name = properties[1];
        this.labels = new ArrayList<>();
        this.prerequisites = new ArrayList<>();

        readArrayProperty(properties[2], this.labels);

        readArrayProperty(properties[3], this.prerequisites);
    }

    public void printQuestion() {
        String print = "";

        print += "Number: " + this.number + " Name: " + this.name + " " + printArrayProperty("labels", this.labels) +
                " " + printArrayProperty("prerequisites", this.prerequisites);

        System.out.println(print);
    }
}
