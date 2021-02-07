package co.com.prueba;

import co.com.prueba.wsdl.Empleado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.GregorianCalendar;

@RestController
public class EmpleadoController {
    @Autowired
    private SoapEmpleadoClient empleadoClient;

    @PostMapping(path = "/agregarEmpleado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Empleado agregarEmpleado(@RequestBody EmpleadoDto empleadoDto) throws JsonProcessingException, DatatypeConfigurationException {
        GregorianCalendar date = GregorianCalendar.from(empleadoDto.getBirthDate().atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar dateConverte = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);

        Empleado empleado =new Empleado();
        empleado.setNombres(empleadoDto.getNombres());
        empleado.setApellidos(empleadoDto.getApellidos());
        empleado.setTipoDoc(empleadoDto.getTipoDoc());
        empleado.setNumeroDoc(empleadoDto.getNumeroDoc());
        empleado.setBirthDate(dateConverte);
        empleado.setVinculadoDate(null);
        empleado.setSalario(empleadoDto.getSalario());
        empleado.setCargo(empleadoDto.getCargo());
        ObjectMapper objectMapper = new ObjectMapper();
        String Json = objectMapper.writeValueAsString(empleadoDto);
        System.out.println(Json);
        return empleadoClient.agregarEmpleado(empleado).getEmpleado();
    }

}
