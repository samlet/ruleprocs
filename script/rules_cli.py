from py4j.java_gateway import JavaGateway, JavaObject, GatewayParameters
from py4j.java_gateway import java_import, get_field

host="localhost"
port=4333
callback_port=4334
gateway = JavaGateway(python_proxy_port=callback_port,
                      gateway_parameters=GatewayParameters(address=host, port=port, auto_field=True))
j = gateway.new_jvm_view()
java_import(j, 'org.kie.api.*')

ks=j.KieServices.get()
kc = ks.getKieClasspathContainer()

java_import(j, 'org.drools.examples.helloworld.*')
j.HelloWorldExample.execute(ks,kc)

