package com.example.task5;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public interface Builder {
    public void addText(String text, int textSize, Color textColor);
    public void ImageScroll(Image image);
    public void TextAnimation( boolean button);

    public Indicator build();


}
