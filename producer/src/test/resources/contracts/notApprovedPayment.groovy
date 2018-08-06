import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/v1/payments/10/status'
    }
    response {
        status 412
        body("""{"approved":false}""")
        headers {
            contentType(applicationJson())
        }
    }
}
