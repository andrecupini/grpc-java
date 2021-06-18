package br.com.zup.grpc.service;

import br.com.zup.grpc.HelloRequest;
import br.com.zup.grpc.HelloResponse;
import br.com.zup.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        log.info("Request received! Sending a response...");

        String message = "Hello, " +
                request.getFirstName() +
                " " +
                request.getLastName() +
                " - This message came from: " +
                request.getLocation();

                HelloResponse response = HelloResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
