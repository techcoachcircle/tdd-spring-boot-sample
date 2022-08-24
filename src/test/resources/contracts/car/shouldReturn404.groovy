package contracts.car


org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/cars/prius'
        headers {
            contentType('application/json')
        }
    }
    response {
        status NOT_FOUND()
    }
}
