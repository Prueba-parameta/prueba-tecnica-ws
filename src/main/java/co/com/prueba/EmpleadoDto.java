package co.com.prueba;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class EmpleadoDto {

    private String nombres;

    private String apellidos;

    private String tipoDoc;

    private String numeroDoc;

    private LocalDate birthDate;

    private LocalDate vinculadoDate;

    private String cargo;
    private double salario;

    public EmpleadoDto() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getVinculadoDate() {
        return vinculadoDate;
    }

    public void setVinculadoDate(LocalDate vinculadoDate) {
        this.vinculadoDate = vinculadoDate;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
