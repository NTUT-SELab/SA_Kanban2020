package ddd.kanban.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Initialization {
    private static AnchorPane anchorPane = new AnchorPane();
    private static Scene scene;

    public static void InitialButton(){
        JFXButton jfxButton = new JFXButton();
        jfxButton.setText("Test");
        jfxButton.setLayoutX(100);
        jfxButton.setLayoutY(200);
        jfxButton.getStyleClass().add("button-raised");
        jfxButton.prefWidth(50);
        jfxButton.prefHeight(20);
        jfxButton.setPrefWidth(50);
        jfxButton.setPrefHeight(20);
        anchorPane.getChildren().add(jfxButton);
    }

    public static void setBanner() throws IOException {
        AnchorPane bannerPane = new AnchorPane();

        JFXButton jfxButton = new JFXButton("Home");
        jfxButton.getStyleClass().add("banner-home-button");
        jfxButton.setLayoutX(20);
        jfxButton.setLayoutY(15);

        JFXTextField jfxTextField = new JFXTextField();
        jfxTextField.setLayoutX(120);
        jfxTextField.setLayoutY(15);
        jfxTextField.setPromptText("Search Board");
        jfxTextField.getStyleClass().add("banner-search-input");

        Label bannerTitle = new Label();
        bannerTitle.setLayoutX(350);
        bannerTitle.setLayoutY(10);
        bannerTitle.setText("Kanban");
        bannerTitle.setAlignment(Pos.CENTER);
        bannerTitle.getStyleClass().add("banner-title-label");

        JFXButton accountButton = new JFXButton("A");
        accountButton.setLayoutX(750);
        accountButton.setLayoutY(15);
        accountButton.getStyleClass().add("banner-account-button");

        bannerPane.getChildren().add(jfxButton);
        bannerPane.getChildren().add(jfxTextField);
        bannerPane.getChildren().add(bannerTitle);
        bannerPane.getChildren().add(accountButton);
        bannerPane.getStyleClass().add("banner");

        anchorPane.getChildren().add(bannerPane);
    }

    public static Scene InitialScene() throws IOException {
        setBanner();
        InitialButton();
        scene = new Scene(anchorPane, 800, 600);
        scene.getStylesheets().add("button-styles.css");
        return scene;
    }
}
