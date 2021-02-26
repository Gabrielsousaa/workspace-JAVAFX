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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.servicos.departamento_Servico;

public class DepartamentoListaController implements Initializable {

    @FXML
    private departamento_Servico servico;
    @FXML
    private TableView<Departamento> tableviewDepartamento;

    @FXML
    private TableColumn<Departamento, Integer> tableColumnID;

    @FXML
    private TableColumn<Departamento, String> tableColumnName;

    @FXML
    private Button btnew;
    @FXML
    private ObservableList<Departamento> obslist; //carrega os departamentos setados

    @FXML
    public void onBtNewAction()//metodo que adiciona funcao ao botao configure no scenebuilder
    {
        System.out.println("onButtonAction"); // faz com que o botao apareça uma mensagem no terminal 

    }

    public void setDepartamentoServico(departamento_Servico servico)//retorna os serviço ja predefinidos na classe departamento_Servico
    {
        this.servico = servico;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        InitializableNodes();

    }

    private void InitializableNodes() { // metodo que faz a tabela ser exibida com ID e name
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableviewDepartamento.prefHeightProperty().bind(stage.heightProperty());

    }

    public void updateTableView() {
    if(servico == null)
    {
    throw new IllegalStateException("Service was null");
    
    }
    List<Departamento> list = servico.findAll();
    obslist = FXCollections.observableArrayList(list);
    tableviewDepartamento.setItems(obslist);
    
    
    }

}
