package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import Application.Main;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

import model.servicos.departamento_Servico;

public class MainViewController implements Initializable {

    static Object getMainScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private MenuItem menuitemVendedor;
    @FXML
    private MenuItem menuitemDepartamento;
    @FXML
    private MenuItem menuItemSobre;

    @FXML
    public void onMenuItemVendedorAction() {

    }

    @FXML
    public void onMenuSobreAction() {
        loadView("/gui/Sobre.fxml");
        
    }

    @FXML

    public void onMenuDepartamentoAction() {
        
    loadView2("/gui/Iista_Departamento.fxml");
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
   // synchronized = garante que a função do try catch seja executado
    private synchronized void loadView(String absoluteName) {
        try {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newvBox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVbox =(VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);           
            mainVbox.getChildren().addAll(newvBox.getChildren());
        } catch (IOException e) {
            
            Alerts.showAlert("IO EXCEPTION","ERROR LOADING VIEW",e.getMessage(),AlertType.ERROR);

        }

    }
    
    
        private synchronized void loadView2(String absoluteName) {
        try {
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newvBox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVbox =(VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);           
            mainVbox.getChildren().addAll(newvBox.getChildren());
            
            DepartamentoListaController controller = loader.getController();
            controller.setDepartamentoServico(new departamento_Servico());
            controller.updateTableView();
            
            
        } catch (IOException e) {
            
            Alerts.showAlert("IO EXCEPTION","ERROR LOADING VIEW",e.getMessage(),AlertType.ERROR);

        }

    }
    
    
    
    
    
}
