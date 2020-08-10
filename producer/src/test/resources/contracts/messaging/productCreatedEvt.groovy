package contracts.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should produce valid product event'
    label 'product.created'
    input {
        // the contract will be triggered by a method
        triggeredBy('emitProductCreatedEvent()')
    }
    outputMessage {
        sentTo 'product-exchange'
        headers {
            header('contentType': 'application/json')
            header('__TypeId__', 'br.com.example.producer.domain.Product')
        }
        body ([
                id: $(consumer(9), producer(regex("[0-9]+"))),
                name: "Awesome Jeans",
                salesPrice: 49.99,
                purchasePrice: 35.50
        ])
    }
}