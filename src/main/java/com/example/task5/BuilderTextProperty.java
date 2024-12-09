package com.example.task5;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BuilderTextProperty implements Builder{
    Indicator indicator = new Indicator();
    public ConcreteAggregate conaggr = new ConcreteAggregate("img");
    public Iterator iter = conaggr.getIterator();
    public Timeline time =new Timeline();
    @Override
    public void addText(String text, int textSize, Color textColor) {
      this.text.setText(text);
      this.text.setFont(new Font("System",textSize ));
this.text.setTextFill(textColor);
        //pane.getChildren().add(label);
        indicator.addText(this.text);
    }

    @Override
    public void ImageScroll(   Image image) {

        this.indicator.addImage(image);
    }
    Label text = new Label();
    @Override
    public void TextAnimation( boolean button) {
//


        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), text);
        rotateTransition.setToAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);


        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), text);
        scaleTransition.setToX(-1);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);

if(button) {
    rotateTransition.play();
    scaleTransition.play();

}
else {
    rotateTransition.stop();
    scaleTransition.stop();
}

    }

    @Override
    public Indicator build() {
        return indicator;
    }
}
