package _Summary_;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@SuppressWarnings("unchecked")
public class Questions_in_Labels {
    public ArrayList<Question> readQuestionsFromJson(String jsonPath) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Question> questions = new ArrayList<>();

        try (FileReader reader = new FileReader(jsonPath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            Set<Integer> existingQuestions = new HashSet<>();
            jsonArray.forEach(item -> {
                Question question = new Question();
                question.parseJsonObject((JSONObject) item);
                if (!existingQuestions.contains(question.getNumber())) {
                    questions.add(question);
                    existingQuestions.add(question.getNumber());
                }
            });

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public ArrayList<Label> readLabelsFromJson(String jsonPath) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Label> labels = new ArrayList<>();

        try (FileReader reader = new FileReader(jsonPath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            Set<Integer> existingLabels = new HashSet<>();
            jsonArray.forEach(item -> {
                Label label = new Label();
                label.parseJsonObject((JSONObject) item);
                if (!existingLabels.contains(label.getId())) {
                    labels.add(label);
                    existingLabels.add(label.getId());
                }
            });

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return labels;
    }

    public ArrayList<Integer> convertLabelsToIds(ArrayList<Label> labels, ArrayList<String> labelsName) {
        ArrayList<Integer> labelIds = new ArrayList<>();

        labels.forEach(label -> {
            if (labelsName.contains(label.getName())) {
                labelIds.add(label.getId());
            }
        });

        return labelIds;
    }

    /** check if the question is selected by labels  */
    public boolean isLabeled(Question q, ArrayList<Integer> labelIds) {
        return q.getLabels().stream().anyMatch(labelIds::contains);
    }

    public ArrayList<Question> findAllQuestionsUnderLabels(String[] labelsName) {
        ArrayList<Question> questions = this.readQuestionsFromJson("src/_Summary_/Questions.json");
        ArrayList<Label> labels = this.readLabelsFromJson(("src/_Summary_/Labels.json"));

        ArrayList<String> labelNames = new ArrayList<>();
        Collections.addAll(labelNames, labelsName);
        ArrayList<Integer> ids = this.convertLabelsToIds(labels, labelNames);

        ArrayList<Question> selectedQuestions = new ArrayList<>();
        questions.forEach(question -> {
            if (isLabeled(question, ids)) {
                selectedQuestions.add(question);
            }
        });

        return selectedQuestions;
    }

    public static void main(String[] args) {
        Questions_in_Labels tool = new Questions_in_Labels();

        String[] labelNames = {"substring"};
        System.out.println(tool.findAllQuestionsUnderLabels(labelNames));
    }

}
