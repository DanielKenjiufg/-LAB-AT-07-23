package view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Item {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty nomeItem;
    private SimpleIntegerProperty quantidade;
    private SimpleDoubleProperty preco;
    
    public Item(int id, String nomeItem, 
                    int quantidade, double preco) {
        this.id = new SimpleIntegerProperty(id);
        this.nomeItem = new SimpleStringProperty(nomeItem);
        this.quantidade = new SimpleIntegerProperty(quantidade);
        this.preco = new SimpleDoubleProperty(preco);        
    }
    
//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id.get();
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id.set(id);
    }//end method setId

    /**GET Method Propertie nomeItem*/
    public String getNomeItem(){
        return this.nomeItem.get();
    }//end method getNomeItem

    /**SET Method Propertie nomeItem*/
    public void setNomeItem(String nomeItem){
        this.nomeItem.set(nomeItem);
    }//end method setNomeItem

    /**GET Method Propertie quantidade*/
    public int getQuantidade(){
        return this.quantidade.get();
    }//end method getQuantidade

    /**SET Method Propertie quantidade*/
    public void setQuantidade(int quantidade){
        this.quantidade.set(quantidade);
    }//end method setQuantidade

    /**GET Method Propertie preco*/
    public double getPreco(){
        return this.preco.get();
    }//end method getPreco
    /**SET Method Propertie matricula*/
    public void setPreco(double preco){
        this.preco.set(preco);
    }//end method setPreco

//End GetterSetterExtension Source Code


}//End class