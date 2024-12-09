package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ImageView view;

    public ConcreteAggregate conaggr = new ConcreteAggregate("img");
    public Iterator iter = conaggr.getIterator();
    public Timeline time =new Timeline();

    public void initialize()
    {
        time.setCycleCount(Timeline.INDEFINITE); //кол-во повторов

        time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
 view.setImage((Image)
                            iter.next());
                }

        }));
        time.play();
    }
    @FXML
    public void playButtonClick()
    {
  //      view.setImage((Image)iter.next());
        time.play();

    }
    @FXML
    public void pauseButtonClick()
    {
time.pause();
    }
    @FXML
    public void stopButtonClick()
    {
        view.setImage((Image)iter.getFirst());
        time.stop();

    }
    @FXML
    protected void onHelloButtonClick()
    {

        view.setImage((Image)iter.next());
        //EvHandler();
    }
    @FXML
    protected void prevButtonClick()
    {
        view.setImage((Image)iter.preview());

    }

}