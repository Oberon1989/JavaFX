package com.Oberon1989;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MainController {
    public final double METER = 100;
    @FXML
    private Slider weightSlider;
    @FXML
    private Slider heightSlider;
    @FXML
    private Label weightShow;
    @FXML
    private Label heightShow;
    @FXML
    Label output;

    public void initialize() {
        output.setText("");
        weightShow.setText(Double.toString(weightSlider.getValue()));
        heightShow.setText(Double.toString(heightSlider.getValue()));
        weightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            weightShow.setText(Double.toString(newValue.intValue()));
            Calculate(heightSlider.getValue(), weightSlider.getValue());
        });
        heightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            heightShow.setText(Double.toString(newValue.intValue()));
            Calculate(heightSlider.getValue(), weightSlider.getValue());
        });
    }

    public void Calculate(double h, double w) {
        double bodyMassIndex = 0;
        double height = h;
        double weight = w;
        height = height / METER;
        bodyMassIndex = weight / (height * height);
        String resume = "";

        if (bodyMassIndex < 15.99) {
            resume = String.format("Индекс массы тела %.2f\r\nВыраженный дефицит массы тела.\r\nНизкий риск сердечно-сосудистых заболеваний.\r\nНеобходима срочная консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex >= 16 && bodyMassIndex <= 18.49) {
            resume = String.format("Индекс массы тела %.2f\r\nНедостаточная (дефицит) масса тела.\r\nНизкий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex >= 18.50 && bodyMassIndex <= 24.99) {
            resume = String.format("Индекс массы тела %.2f\r\nНормальный.\r\nОбычный риск сердечно-сосудистых заболеваний.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex >= 25.00 && bodyMassIndex <= 29.99) {
            resume = String.format("Индекс массы тела %.2f\r\nИзбыточная масса тела (предожирение).\r\nПовышенный риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex >= 30.00 && bodyMassIndex <= 34.99) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение первой степени.\r\nВысокий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex >= 35.00 && bodyMassIndex <= 39.00) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение второй степени.\r\nОчень высокий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        } else if (bodyMassIndex > 40) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение третьей степени (морбидное).\r\nЧрезвычайно высокий риск сердечно-сосудистых заболеваний.\r\nНеобходима срочная консультация специалиста.", bodyMassIndex);
            output.setText(resume);
        }
    }
}


