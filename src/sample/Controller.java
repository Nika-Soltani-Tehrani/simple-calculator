package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
    private boolean cosine = false;
    private Model model = new Model();

    @FXML
    public void processNumbers(ActionEvent event)
    {
        if (start)
        {
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent event)
    {
        String value = ((Button)event.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(result.getText());

            if (operator.equals("sin") || operator.equals("cos"))
            {
                double output = model.calculate2(number1,operator);
                result.setText(String.valueOf(output));
                operator = "";
                cosine = true;
            }
            else
            {
                result.setText(number1 + " " + operator + " ");
            }
        }
        else
        {
            if (!cosine){
                if (operator.isEmpty())
                    return;
                long number2 = Long.parseLong(result.getText().split(" ")[2]);
                System.out.println(number2);
                float output = model.calculate1(number1, number2, operator);
                result.setText(String.valueOf(output));
                operator = "";
            }
        }
        cosine = false;

    }


    @FXML
    public void AC(ActionEvent event)
    {
        //System.out.println("button");
        //String value = ((Button)event.getSource()).getText();
        result.setText("");
        start = true;

    }
}