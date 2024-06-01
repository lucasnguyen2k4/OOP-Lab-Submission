package AimsProject.hust.soict.dsai.screen;

import AimsProject.hust.soict.dsai.aims.cart.Cart.Cart;
import AimsProject.hust.soict.dsai.media.Playable;
import AimsProject.hust.soict.dsai.exception.PlayerException;
import AimsProject.hust.soict.dsai.media.Media;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CartScreenController {
    private Cart cart;
    private Stage stage;
    @FXML private Pane pane;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableView<Media> tblMedia;
    @FXML private ToggleGroup filterCategory;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private Label costLabel;
    @FXML private TextField tfFilter;
    @FXML private Button placeOrder;

    @FXML
    void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
        alert.setTitle("Order created");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert;
        alert = new Alert(Alert.AlertType.NONE, media.playGUI());
        alert.setTitle("Playing");
        alert.setHeaderText(null);
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(Math.round(cart.totalCost()*100.0)/100.0 + " $");
    }

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );
        tblMedia.setItems(this.cart.getItemsOrdered());

        costLabel.setText(Math.round(cart.totalCost()*100.0)/100.0 + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                    private void updateButtonBar(Media media) {
                        btnRemove.setVisible(true);
                        if (media instanceof Playable) {
                            btnPlay.setVisible(true);
                        } else {
                            btnPlay.setVisible(false);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilteredMedia(newValue);
                    }
                    private void showFilteredMedia(String keyword) {
                        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());
                        if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String idString = String.valueOf(media.getID());
                                return idString.equals(keyword);
                            });
                        } else if (!keyword.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String title = media.getTitle().toLowerCase();
                                return title.contains(keyword.toLowerCase());
                            });
                        } else {
                            filteredList.setPredicate(null);
                        }
                        tblMedia.setItems(filteredList);
                    }
                });
    }
}