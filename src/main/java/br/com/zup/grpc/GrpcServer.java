package br.com.zup.grpc;

import br.com.zup.grpc.service.HelloServiceImpl;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GrpcServer {
    public static void main(String[] args) {

        log.info("Starting HelloService server...");
        var server = ServerBuilder
                .forPort(50051)
                .addService(new HelloServiceImpl()).build();

        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            if (Thread.interrupted()) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
