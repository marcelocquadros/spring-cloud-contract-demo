package br.com.example.producer;

import br.com.example.producer.controllers.FraudDetectionController;
import br.com.example.producer.domain.Product;
import br.com.example.producer.eventhandler.ProductEventHandler;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public abstract class ContractTestBase {

    @Autowired
    private ProductEventHandler productEventHandler;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }


    public void emitProductCreatedEvent() {
        Product product = new Product(1L, "Awesome Jeans",
                BigDecimal.valueOf(49.99),
                BigDecimal.valueOf(35.50));

        productEventHandler.handleCreated(product);
    }

}
