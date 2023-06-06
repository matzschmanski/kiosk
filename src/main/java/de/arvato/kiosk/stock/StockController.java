package de.arvato.kiosk.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    public ResponseEntity<StockItem[]> getStock() {
        StockItem[] stockItems = stockService.loadStockItems();
        return ResponseEntity.status(HttpStatus.OK)
//                .header("Custom-Header", "Value")
                .body(stockItems);
    }

    @GetMapping("/stock/{category}")
    public ResponseEntity<StockItem[]> getStockWithCategory(@PathVariable String category) {
        StockItem[] stockItems = stockService.loadStockItemsWithCategory(category);
        return ResponseEntity.status(HttpStatus.OK)
                .body(stockItems);
    }

}
