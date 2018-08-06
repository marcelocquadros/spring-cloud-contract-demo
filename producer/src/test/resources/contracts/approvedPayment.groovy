import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath '/v1/payments/1/status'
    }
    response {
        status 200
        body("""{"approved":true}""")
        headers {
            contentType(applicationJson())
        }
    }
}