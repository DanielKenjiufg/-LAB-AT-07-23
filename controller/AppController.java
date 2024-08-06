package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import model.ItemRepositorio;
import view.AppView;

public class AppController implements Initializable {
    @FXML
    private TableView<view.Item> tabela;
    @FXML
    private TableColumn<view.Item, Integer> idCol;
    @FXML
    private TableColumn<view.Item, String> nomeItemCol;
    @FXML
    private TableColumn<view.Item, Integer> quantidadeCol;
    @FXML
    private TableColumn<view.Item, Double> precoCol;
    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField quantidadeField;
    @FXML
    private TextField precoField;
    @FXML
    private Button addButton;
    
    AppView appView;
    
    private static model.Database database = new model.Database("app.sqlite");
    private static model.ItemRepositorio itemRepo = 
        new model.ItemRepositorio(database);
        
    public AppController() {
        this.appView = new AppView();
    }
    
    public static void main(String[] args) throws Exception {
        AppController appController = new AppController();
        appController.appView.run(args);
    }
    
    private void desabilitarBotoes(boolean add) {
        addButton.setDisable(add);    
    }
    
    private void desabilitarCampos(boolean desabilitado) {
        nomeField.setDisable(desabilitado);
        quantidadeField.setDisable(desabilitado);
        precoField.setDisable(desabilitado);
    }
    
    private void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        quantidadeField.setText("");
        precoField.setText("");        
    }
    
    @FXML
    public void onAddButtonAction() {
        try {
            model.Item item = new model.Item();
            item.setNomeItem(nomeField.getText());
            item.setQuantidade(Integer.parseInt(quantidadeField.getText()));
            item.setPreco(Double.parseDouble(precoField.getText()));
            model.Item item_salvo = itemRepo.create(item); 
            view.Item itemView = modelToView(item_salvo);
            tabela.getItems().add(itemView);
            tabela.getSelectionModel().select(itemView);    
            desabilitarCampos(true);
            desabilitarBotoes(false);            
        }
        catch(Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }    

    @FXML
    private void handleItemSelected(view.Item newSelection) {
        if (newSelection != null)
            idField.setText(Integer.toString(newSelection.getId()));
            nomeField.setText(newSelection.getNomeItem());
            quantidadeField.setText(Integer.toString(newSelection.getQuantidade()));
            precoField.setText(Double.toString(newSelection.getPreco()));
            desabilitarBotoes(false);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        nomeItemCol.setCellValueFactory(
                new PropertyValueFactory<>("nomeItem"));
        quantidadeCol.setCellValueFactory(
                new PropertyValueFactory<>("quantidade"));
        precoCol.setCellValueFactory(
                new PropertyValueFactory<>("preco"));
        tabela.setItems(loadAllItens());
        tabela.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldSelection, newSelection) -> {
                handleItemSelected(newSelection);
            });
    }
    
    private view.Item modelToView(model.Item item) {
        return new view.Item(
            item.getId(),
            item.getNomeItem(),
            item.getQuantidade(),
            item.getPreco()
        );
    }
    
    private ObservableList<view.Item> loadAllItens() {
        ObservableList<view.Item> lista = 
            FXCollections.observableArrayList();
        List<model.Item> listaFromDatabase = itemRepo.loadAll();
        for(model.Item item: listaFromDatabase) {
            lista.add(modelToView(item));
        }
        return lista;
    }
}