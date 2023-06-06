package de.arvato.kiosk.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class StockService {
    public final ObjectMapper objectMapper;
    public StockService(){
       this.objectMapper= new ObjectMapper();
    }

    public StockItem[] loadStockItems(){
        try {
            return objectMapper.readValue(getData(), StockItem[].class);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
            return new StockItem[0];
        }
    }
    public StockItem[] loadStockItemsWithCategory(String category){
        return loadStockItems();
    }

    public File getData(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("static/inventory.json");
        File file = null;
        if (url != null) {
            file = new File(url.getFile());
        } else {
            System.out.println("File not found.");
        }
        return file;
    }
}
