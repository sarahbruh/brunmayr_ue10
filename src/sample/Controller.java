package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Stack;

public class Controller {

    @FXML TextArea textarea = new TextArea();
    @FXML TextField textfield = new TextField();

    Stack<String> stack= new Stack<String>();
    StringBuilder numbers = new StringBuilder();
    StringBuilder lv = new StringBuilder();

    @FXML Button plus;
    @FXML Button minus;
    @FXML Button durch;
    @FXML Button mal;
    @FXML Button kehrwert;
    @FXML Button vertauschen;


    @FXML
    private void buttonClicked(MouseEvent me){
        try{
            Object node = me.getSource();
            Button btn = (Button) node;
            String s = btn.getText();
            numbers.append(Integer.valueOf(s));
            textfield.setText(String.valueOf(numbers));
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }

    @FXML
    public void setComma(){
        numbers.append(".");
        textfield.setText(numbers.toString());
    }

    @FXML
    public void setSign(){
        numbers.append("-");
        textfield.setText(numbers.toString());
    }

    @FXML
    public void enter(){
        try{
            stack.push(String.valueOf(numbers));
            lv.append(String.format("%s %n",numbers));
            textarea.setText(String.valueOf(lv));
            textfield.clear();
            numbers.delete(0,lv.length());
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }
    @FXML
    public void CE(){
        try{
            textfield.clear();
            numbers.delete(0,numbers.length());
        }
        catch(Exception ex){
            System.err.println("Error! Please enter a number!");
        }
    }
    @FXML
    public void C(){
        try{
            stack.clear();
            lv.delete(0,lv.length());
            numbers.delete(0,numbers.length());
            textarea.clear();
            textfield.clear();
        }
        catch(Exception ex){
            System.err.println("Error! Please enter a number!");
        }
    }

    @FXML
    public void Operatoren(){
        try{
            if(plus.isFocused()){

                double eins = Double.parseDouble(stack.pop());
                double zwei = Double.parseDouble(stack.pop());

                double ergebnis = eins + zwei;
                stack.push(String.valueOf(ergebnis));
                textarea.setText(String.valueOf(ergebnis));
            }
            else if(minus.isFocused()){

                double eins = Double.parseDouble(stack.pop());
                double zwei = Double.parseDouble(stack.pop());

                double ergebnis = zwei - eins;
                stack.push(String.valueOf(ergebnis));
                textarea.setText(String.valueOf(ergebnis));
            }
            else if(mal.isFocused()){
                double eins = Double.parseDouble(stack.pop());
                double zwei = Double.parseDouble(stack.pop());

                double ergebnis = eins * zwei;
                stack.push(String.valueOf(ergebnis));
                textarea.setText(String.valueOf(ergebnis));
            }
            else if(durch.isFocused()){

                double eins = Double.parseDouble(stack.pop());
                double zwei = Double.parseDouble(stack.pop());

                double ergebnis = zwei / eins;
                stack.push(String.valueOf(ergebnis));
                textarea.setText(String.valueOf(ergebnis));
            }
            else if(vertauschen.isFocused()){

                double eins = Double.parseDouble(stack.pop());
                double zwei = Double.parseDouble(stack.pop());

                stack.push(String.valueOf(zwei));
                stack.push(String.valueOf(eins));

                textarea.setText(String.valueOf(stack));
            }
            else if(kehrwert.isFocused()){

                double eins = Double.parseDouble(stack.pop());

                double ergebnis = 1/eins;
                textarea.setText(String.valueOf(ergebnis));
            }
        }
        catch(ArithmeticException ex){
            System.err.println("Error!");
        }
    }

}
