package br.com.sample.consumer.producer;


import br.com.sample.consumer.domain.FraudCheckStatus;
import br.com.sample.consumer.dto.FraudCheckRequest;
import br.com.sample.consumer.dto.FraudCheckResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"br.com.example:producer:+:stubs:3000"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ValidateContractCheckFraudTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
    public void shouldRespondFraudDetected() {

        FraudCheckRequest request = new FraudCheckRequest();
        request.setCustomerId("12345678901");
        request.setTotalAmount(BigDecimal.valueOf(10001));

        ResponseEntity<FraudCheckResult> responseEntity = restTemplate.postForEntity(
                getUrl("/fraudcheck"),
                request,
                FraudCheckResult.class
        );

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        assertEquals(responseEntity.getBody().getFraudCheckStatus(), FraudCheckStatus.FRAUD);
        assertEquals(responseEntity.getBody().getRejectionReason(), "Amount too high");

    }

    @Test
    public void shouldRespondFraudOK() {

        FraudCheckRequest request = new FraudCheckRequest();
        request.setCustomerId("12345678901");
        request.setTotalAmount(BigDecimal.valueOf(100));

        ResponseEntity<FraudCheckResult> responseEntity = restTemplate.postForEntity(
                getUrl("/fraudcheck"),
                request,
                FraudCheckResult.class
        );

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        assertEquals(responseEntity.getBody().getFraudCheckStatus(), FraudCheckStatus.OK);
        assertEquals(responseEntity.getBody().getRejectionReason(), null);

    }
    private String getUrl(String path){
        return String.format("http://localhost:3000/%s",  path);
    }
}

