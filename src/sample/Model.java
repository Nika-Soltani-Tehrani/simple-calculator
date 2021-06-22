package sample;

public class Model {

    public float calculate1(long num1, long num2, String operator)
    {
        switch (operator)
        {
            case "+":
                return num1 + num2;

            case "-":
                return num1 - num2;

            case "*":
                return num1 * num2;

            case "/":
            {
                if (num2 != 0){
                    return (float) num1 / num2;
                }
                else
                    return 0;
            }

            case "^":
                return (float) Math.pow(num1,num2) ;



            default:
                return 0;
        }

    }

    public double calculate2(long num1, String operator)
    {
        switch (operator)
        {

            case "sin":
                return Math.sin(num1);

            case "cos":
                return Math.cos(num1);

            default:
                return 0;
        }

    }
}