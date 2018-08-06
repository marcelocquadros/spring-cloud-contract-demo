import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath $(regex('/v1/payments/41/status'))
    }
    response {
        status 412
        body("""{"approved":false}""")
        headers {
            contentType(applicationJson())
        }
    }
}
