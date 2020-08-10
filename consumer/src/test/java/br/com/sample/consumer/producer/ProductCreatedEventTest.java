package br.com.sample.consumer.producer;

import br.com.sample.consumer.listener.ProductListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = {"br.com.example:producer:+:stubs:3000"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ProductCreatedEventTest {

    @Autowired
    StubTrigger stubTrigger;

    @Autowired
    ProductListener productListener;

    @Test
    public void shouldReceiveNotification() {
        stubTrigger.trigger("product.created");
        assertEquals(this.productListener.getProduct().getName(), "Awesome Jeans" );
    }

}