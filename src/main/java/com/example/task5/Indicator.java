package com.example.task5;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Indicator {
    private StackPane panel = new StackPane();

    public void addImage(Image image) {
        var view = new ImageView();
        view.setImage(image);
        view.setFitHeight(300); view.setFitWidth(300);

        panel.getChildren().add(view);

    }

    public void addText(Label text){
        this.panel.getChildren().add(text);
    }

    public StackPane getPanel(){
        return this.panel;
    }
    public void show(Pane pane){

            pane.getChildren().add(panel);

    }
}