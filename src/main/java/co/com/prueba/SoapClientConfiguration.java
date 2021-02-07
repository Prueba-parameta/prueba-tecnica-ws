package co.com.prueba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
// this package must match the package in the <generatePackage> specified in
// pom.xml
        marshaller.setContextPath("co.com.prueba.wsdl");
        return marshaller;
    }

    @Bean
    public SoapEmpleadoClient empleadoClient(Jaxb2Marshaller marshaller) {
        SoapEmpleadoClient client = new SoapEmpleadoClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
