import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/fraudcheck'

        headers {
            contentType(applicationJson())
        }

        body([
                customerId: $(regex('[0-9]{11}')),
                totalAmount: 10001
        ])
    }
    response {
        status 200

        headers {
            contentType(applicationJson())
        }

        body([
                fraudCheckStatus: 'FRAUD',
                rejectionReason: 'Amount too high'
        ])

    }
}