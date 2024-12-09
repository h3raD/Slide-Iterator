package com.example.task5;

import javafx.scene.LightBase;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Director {
    private Image image;

    public Director(Image image) {
        this.image = image;
    }

    public Indicator construct(BuilderTextProperty builderTwo, String text, int textSize, Color textColor,
                          boolean auto) {

        builderTwo.ImageScroll(this.image);

        builderTwo.addText(text, textSize, textColor);


        builderTwo.TextAnimation(auto);
        return builderTwo.build();


    }
}
