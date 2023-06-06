package de.arvato.kiosk.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockControllerTest {


    @Autowired
    StockController stockController;
    @Test
    void testLoadItemsWithCat() {
        assertThat(stockController).isNotNull();
    }

    @Value(value="${local.server.port}")
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        StockItem[] items = this.restTemplate.getForObject("http://localhost:" + port + "/stock/süßes",
                StockItem[].class);
        assertThat(items.length).isEqualTo(3);
    }

}
