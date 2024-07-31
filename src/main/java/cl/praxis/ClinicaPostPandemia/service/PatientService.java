package cl.praxis.ClinicaPostPandemia.service;

import cl.praxis.ClinicaPostPandemia.model.Patient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private static List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient(1, "12345678-9", "Sara Cabrera", "Influenza", true));
        patients.add(new Patient(2, "23456789-0", "Benjamín Rojas", "Diabetes", true));
        patients.add(new Patient(3, "34567890-1", "Pablo Cortés", "Hipertensión", true));
        patients.add(new Patient(4, "45678901-2", "Pedro Fuentes", "Influenza", true));
        patients.add(new Patient(5, "56789012-3", "Jorge Aguilera", "Diabetes", true));
        patients.add(new Patient(6, "67890123-4", "Marcos Carvajal", "Hepatitis", true));
        patients.add(new Patient(7, "78901234-5", "Fernando López", "Covid 19", true));
        patients.add(new Patient(8, "89012345-6", "Hernán Rojas", "Influenza", true));
        patients.add(new Patient(9, "90123456-7", "Jorge Castillo", "Covid 19", true));
        patients.add(new Patient(10, "7890123-4", "Sonia Álvarez", "Diabetes", true));
    }

    public List<Patient> findAll() {
        return patients;
    }

    public Patient findById(int id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addPatient(Patient patient) {
        int newId = patients.size() + 1;
        patient.setId(newId);
        patients.add(patient);
    }

    public void updatePatient(Patient patient) {
        Patient existingPatient = findById(patient.getId());
        if (existingPatient != null) {
            int index = patients.indexOf(existingPatient);
            patients.set(index, patient);
        } else {
            throw new RuntimeException("Patient not found with id " + patient.getId());
        }
    }

    public void deletePatient(int id) {
        patients.removeIf(p -> p.getId() == id);
    }
}
