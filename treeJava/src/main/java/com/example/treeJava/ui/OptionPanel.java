package com.example.treeJava.ui;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class OptionPanel extends JPanel {

    JTextField input;

    public void setInput(JTextField input) {
        this.input = input;
    }

    public Integer getInputValue(){
        Integer inputValue = Integer.parseInt(input.getText());
        return inputValue;
    }

}
