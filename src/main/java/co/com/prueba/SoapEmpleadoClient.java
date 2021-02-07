package co.com.prueba;

import co.com.prueba.wsdl.AgregarEmpleadoRequest;
import co.com.prueba.wsdl.Empleado;
import co.com.prueba.wsdl.EmpleadoResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapEmpleadoClient extends WebServiceGatewaySupport {
    public EmpleadoResponse agregarEmpleado(Empleado empleado) {
        AgregarEmpleadoRequest request = new AgregarEmpleadoRequest();
        request.setEmpleado(empleado);
        EmpleadoResponse response = (EmpleadoResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/empleados", request);
     return response;
    }

}
