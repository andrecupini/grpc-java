package br.com.zup.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcClient {
    public static void main(String[] args) {
        log.info("Stating HelloService client...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        log.info("Sending request...");
        var helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("André")
                .setLastName("Cupini")
                .setFrom("java grpc client")
                .build());

        log.info("Server response was: {}", helloResponse.getMessage());

        channel.shutdown();

    }
}
