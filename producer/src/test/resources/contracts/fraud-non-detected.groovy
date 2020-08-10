import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        urlPath '/fraudcheck'

        headers {
            contentType(applicationJson())
        }

        body([
                customerId: $(regex('[0-9]{11}')),
                totalAmount: 100
        ])
    }
    response {
        status 200

        headers {
            contentType(applicationJson())
        }

        body([
                fraudCheckStatus: 'OK',
                rejectionReason: null
        ])

    }
}