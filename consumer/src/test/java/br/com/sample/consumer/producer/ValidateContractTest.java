package br.com.sample.consumer.producer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"br.com.example:producer:+:stubs:3000"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ValidateContractTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void validatePaymentApprovedContract() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                getUrl("v1/payments/1/status"), String.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseEntity.getBody(), equalTo( "{\"approved\":true}"));
    }

    @Test
    public void validatePaymentNotApprovedContract() {

        ResponseEntity response =  restTemplate.getForEntity(getUrl("v1/payments/41/status"), String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.PRECONDITION_FAILED));
        assertThat(response.getBody(), equalTo( "{\"approved\":false}"));

    }

    private String getUrl(String path){
        return String.format("http://localhost:3000/%s", path);
    }
}
