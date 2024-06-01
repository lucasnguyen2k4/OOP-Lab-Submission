package AimsProject.hust.soict.dsai.GUIProject.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private Color col = Color.BLACK;
    @FXML
    void drawingAreaMouseDragged (MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, col);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    void changeBlack(){
        col = Color.BLACK;
    }
    void changeWhite(){
        col = Color.WHITE;
    }
    @FXML
    void clearButtonPressed (ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}