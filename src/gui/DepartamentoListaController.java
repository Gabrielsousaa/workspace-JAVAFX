package gui;

import model.entidades.Departamento;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import Application.Main;
import javafx.stage.Stage;
 

public class DepartamentoListaController implements Initializable{
     @FXML
     private TableView<Departamento> tableviewDepartamento;
     
     @FXML 
     private TableColumn<Departamento,Integer> tableColumnID;
    
     @FXML 
     private TableColumn<Departamento,String> tableColumnName;
     
     @FXML
     private Button btnew;
    
     @FXML
    public void onBtNewAction()
    {
        System.out.println("onButtonAction");
    
    }
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    InitializableNodes();
    
    }

    private void InitializableNodes() {
    tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
    tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    
    Stage stage = (Stage) Main.getMainScene().getWindow();
    tableviewDepartamento.prefHeightProperty().bind(stage.heightProperty());
    
    }
    
    
    
    
    
    
}
