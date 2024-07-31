package cl.praxis.ClinicaPostPandemia.model;

public class Patient {
    private int id;
    private String rut;
    private String name;
    private String condition;

    private boolean isHospitalized;

    public Patient() {
    }

    public Patient(int id, String rut, String name, String condition,  boolean isHospitalized) {
        this.id = id;
        this.rut = rut;
        this.name = name;
        this.condition = condition;
        this.isHospitalized = isHospitalized;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean getIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(boolean hospitalized) {
        isHospitalized = hospitalized;
    }


    // Método para obtener el estado del paciente como String
    public String getHospitalizationStatus() {
        return isHospitalized ? "Sí" : "De Alta";
    }
}
