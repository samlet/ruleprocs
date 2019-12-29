package sagas.rules;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import py4j.CallbackClient;
import py4j.GatewayServer;
import sagas.langs.id.IndonesiaNer;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static py4j.GatewayServer.*;

@Singleton
public class ApplicaEntryPoint {
    @Inject
    private Stack stack;
    private Provider<IndonesiaNer> indonesiaNer;
    public ApplicaEntryPoint() {
    }

    public void start() throws UnknownHostException{
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

    public Stack getStack() {
        return stack;
    }

    public IndonesiaNer getIndonesiaNer(){
        return this.indonesiaNer.get();
    }

    public static void main(String[] args) throws UnknownHostException {
        Injector injector;
        injector=Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

            }
        });
        injector.getInstance(ApplicaEntryPoint.class).start();
    }

}

