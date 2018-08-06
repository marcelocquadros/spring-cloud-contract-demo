package br.com.example.producer;

import br.com.example.producer.controllers.PaymentRestController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class MockMvcTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new PaymentRestController());
    }
}
