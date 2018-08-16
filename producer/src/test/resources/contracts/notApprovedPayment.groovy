import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath $(regex('/v1/payments/[1-9][0-9]{1,8}/status'))
    }
    response {
        status 412
        body("""{"approved":false}""")
        headers {
            contentType(applicationJson())
        }
    }
}
