import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath $(regex('/v1/payments/[0-9]/status'))
    }
    response {
        status 200
        body("""{"approved":true}""")
        headers {
            contentType(applicationJson())
        }
    }
}