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

    private ArrayList<Integer> benchmarks;

    private boolean worthyToTryAgain;

    public Question() {
    }

    public Question(String name, int number, ArrayList<Integer> labels, ArrayList<Integer> prerequisites,
                    ArrayList<Integer> benchmarks, boolean worthyToTryAgain) {
        this.name = name;
        this.number = number;
        this.labels = labels;
        this.prerequisites = prerequisites;
        this.benchmarks = benchmarks;
        this.worthyToTryAgain = worthyToTryAgain;
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

    public ArrayList<Integer> getBenchmarks() {
        return benchmarks;
    }

    public void setBenchmarks(ArrayList<Integer> benchmarks) {
        this.benchmarks = benchmarks;
    }

    public boolean isWorthyToTryAgain() {
        return worthyToTryAgain;
    }

    public void setWorthyToTryAgain(boolean worthyToTryAgain) {
        this.worthyToTryAgain = worthyToTryAgain;
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
        this.worthyToTryAgain = Boolean.parseBoolean(properties[5]);
        this.labels = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
        this.benchmarks = new ArrayList<>();

        readArrayProperty(properties[2], this.labels);

        readArrayProperty(properties[3], this.prerequisites);

        readArrayProperty(properties[4], this.benchmarks);
    }

    public void printQuestion() {
        String print = "";

        print += "Number: " + this.number + " Name: " + this.name + " " + printArrayProperty("labels", this.labels) +
                " " + printArrayProperty("prerequisites", this.prerequisites) + " " +
                printArrayProperty("benchmarks", this.benchmarks) + " WorthyToTryAgain: " + this.worthyToTryAgain;

        System.out.println(print);
    }
}
