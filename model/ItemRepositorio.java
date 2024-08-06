package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class ItemRepositorio
{
    private static Database database;
    private static Dao<Item, Integer> dao;
    private List<Item> loadedItens;
    private Item loadedItem;
    
    public ItemRepositorio(Database database) {
        ItemRepositorio.setDatabase(database);
        loadedItens = new ArrayList<Item>();
    }
    
    public static void setDatabase(Database database) {
        ItemRepositorio.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Item.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Item.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Item create(Item item) {
        int nrows = 0;
        try {
            nrows = dao.create(item);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedItem = item;
            loadedItens.add(item);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return item;
    }    

    public void update(Item Item) {
      // TODO
    }

    public void delete(Item Item) {
      // TODO
    }
    
    public Item loadFromId(int id) {
        try {
            this.loadedItem = dao.queryForId(id);
            if (this.loadedItem != null)
                this.loadedItens.add(this.loadedItem);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedItem;
    }    
    
    public List<Item> loadAll() {
        try {
            this.loadedItens =  dao.queryForAll();
            if (this.loadedItens.size() != 0)
                this.loadedItem = this.loadedItens.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedItens;
    }
}