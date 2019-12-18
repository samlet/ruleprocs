package sagas.rules;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import py4j.CallbackClient;
import py4j.GatewayServer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static py4j.GatewayServer.*;

public class ApplicaEntryPoint {

    private Injector injector;

    public ApplicaEntryPoint() {
        this.injector=Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

            }
        });
    }

    public Stack getStack() {
        return injector.getInstance(Stack.class);
    }
    public static void main(String[] args) throws UnknownHostException {
        // entryPoint, port, defaultAddress(), connectTimeout, readTimeout, customCommands,
        //	 new CallbackClient(pythonPort, defaultAddress()), ServerSocketFactory.getDefault()
        int port = 4333;
        int callbackPort = 4334;
        InetAddress defaultAddress=InetAddress.getByName("0.0.0.0");
        GatewayServer gatewayServer = new GatewayServer(
                new ApplicaEntryPoint(),
                port, defaultAddress,
                DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT, null,
                new CallbackClient(callbackPort, defaultAddress));
        gatewayServer.start();
        System.out.println(".. drools servant started");
    }

}

