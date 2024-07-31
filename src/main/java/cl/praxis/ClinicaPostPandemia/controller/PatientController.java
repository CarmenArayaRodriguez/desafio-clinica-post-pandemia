package cl.praxis.ClinicaPostPandemia.controller;

import cl.praxis.ClinicaPostPandemia.model.Patient;
import cl.praxis.ClinicaPostPandemia.service.PatientService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
        logger.info("PatientController instanciado y PatientService inyectado");
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<Patient> patients = patientService.findAll();
        logger.info("Listando pacientes");
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/patients/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findById(id);
        if (patient != null) {
            model.addAttribute("patient", patient);
            return "edit-patient";
        }
        return "redirect:/patients";
    }

    @PostMapping("/patients/edit")
    public String updatePatient(@ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}

