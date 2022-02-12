package pl.kowalecki.blooddonationapi.model;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;


public class ResultModel {

    boolean result;
    String text;

    public ResultModel(boolean result, String text) {
        this.result = result;
        this.text = text;
    }

    public ResultModel() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "result=" + result +
                ", text='" + text + '\'' +
                '}';
    }
}
