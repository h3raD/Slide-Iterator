package com.example.task5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class HelloController {
Indicator indicator;
    @FXML
    BorderPane panee;

    @FXML
    VBox vbox;

    Director director;
    @FXML
            Label label;
    BuilderTextProperty builder;

boolean auto = false;

    public ConcreteAggregate conaggr ;
    public Iterator iter ;
    public Timeline time;

    public void initialize()
    {
        color.setValue(Color.BLACK);
        spinner = new Spinner<Integer>();
        valueFactory =
        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, initialValue);
        spinner.setValueFactory(valueFactory);
      //  pane= new Pane();
        time =new Timeline();

        conaggr = new ConcreteAggregate("img");
       iter = conaggr.getIterator();
auto = true;


                time.setCycleCount(Timeline.INDEFINITE); //кол-во повторов

                time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //        pane.getChildren().add(new ImageView(
                        builder = new BuilderTextProperty();
                        var item = (Image) iter.next();
                        director = new Director(item);
                        var cl = color.getValue();
                        indicator = director.construct(builder, textField.getText(),spinner.getValue(), cl, auto);

                        panee.setCenter(indicator.getPanel());
                    }

                }));
                time.play();



//director = new Director();

    }
    @FXML
    ColorPicker color;
    @FXML
   public void onClear() {

       auto = true;
        builder = new BuilderTextProperty();
        var item = (Image) iter.getCur();
        director = new Director(item);
        var cl = color.getValue();
        indicator = director.construct(builder, textField.getText(),spinner.getValue(), cl,  auto);

        panee.setCenter(indicator.getPanel());
   }
    @FXML
    public void onPlay() {
auto=false;
        builder = new BuilderTextProperty();
        var item = (Image) iter.getCur();
        director = new Director(item);
        var cl = color.getValue();
        indicator = director.construct(builder, textField.getText(), spinner.getValue(),cl, auto);

        panee.setCenter(indicator.getPanel());
        time.play();



    }
    @FXML
    TextField textField;
    @FXML
    public void onPause()
    {
        auto=false;
        builder = new BuilderTextProperty();
        var item = (Image) iter.getCur();
        director = new Director(item);
var cl = color.getValue();
        indicator = director.construct(builder, textField.getText(),spinner.getValue(),cl,  auto);

        panee.setCenter(indicator.getPanel());
        time.pause();
    }
    @FXML
    public void onBack() {
        auto = false;
        time.pause();
        builder = new BuilderTextProperty();
        var item = (Image) iter.preview();
        director = new Director(item);
        var cl = color.getValue();
        indicator = director.construct(builder, textField.getText(), spinner.getValue(), cl, auto);

        panee.setCenter(indicator.getPanel());
    }
    @FXML
    public void onForward()
    {
        time.pause();
        auto=false;
        builder = new BuilderTextProperty();
        var item = (Image) iter.next();
        director = new Director(item);
        var cl = color.getValue();
        indicator = director.construct(builder, textField.getText(), spinner.getValue(), cl, auto);

        panee.setCenter(indicator.getPanel());




    }
    @FXML
Spinner<Integer> spinner ;
    final int initialValue = 39;
    // Value factory.
    SpinnerValueFactory<Integer> valueFactory;
}