package _Summary_;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("unchecked")
public class Questions_in_Labels {
    /** Read Questions from specified .csv file */
    public ArrayList<Question> readQuestionsFromCsv(String jsonPath) {
        ArrayList<Question> questions = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(jsonPath));
            scanner.next(); // skip the header

            while(scanner.hasNext()) {
                String questionString = scanner.next();
                Question question = new Question();
                question.parseCsvObject(questionString);
                questions.add(question);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return questions;
    }

    /** Read Labels from specified .csv file */
    public ArrayList<Label> readLabelsFromCsv(String jsonPath) {
        ArrayList<Label> labels = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(jsonPath));
            scanner.next(); // skip the header

            while(scanner.hasNext()) {
                String labelString = scanner.next();
                Label label = new Label();
                label.parseCsvObject(labelString);
                labels.add(label);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return labels;
    }

    /** convert label name (string) to id by a given mapper named labels */
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
        ArrayList<Question> questions = this.readQuestionsFromCsv("src/_Summary_/Questions.json");
        ArrayList<Label> labels = this.readLabelsFromCsv(("src/_Summary_/Labels.csv"));

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

        ArrayList<Question> questions = tool.readQuestionsFromCsv("src/_Summary_/Questions.csv");
        ArrayList<Label> labels = tool.readLabelsFromCsv("src/_Summary_/Labels.csv");

        questions.forEach(Question::printQuestion);
        labels.forEach(Label::printLabel);
    }

}
