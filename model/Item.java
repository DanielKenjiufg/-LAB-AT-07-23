package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="Item")
public class Item {
    
    @DatabaseField(generatedId = true)
    private int id;
        
    @DatabaseField(dataType=DataType.STRING)    
    private String nomeItem;
    
    @DatabaseField(dataType=DataType.INTEGER)        
    private int quantidade;
    
    @DatabaseField(dataType=DataType.DOUBLE)        
    private double preco;
    

//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie nomeItem*/
    public String getNomeItem(){
        return this.nomeItem;
    }//end method getNomeItem

    /**SET Method Propertie nomeItem*/
    public void setNomeItem(String nomeItem){
        this.nomeItem = nomeItem;
    }//end method setNomeItem

    /**GET Method Propertie quantidade*/
    public int getQuantidade(){
        return this.quantidade;
    }//end method getQuantidade

    /**SET Method Propertie quantidade*/
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }//end method setQuantidade

    /**GET Method Propertie preço*/
    public double getPreco(){
        return this.preco;
    }//end method getPreco

    /**SET Method Propertie preço*/
    public void setPreco(double preco){
        this.preco = preco;
    }//end method setPreco

//End GetterSetterExtension Source Code


}//End class