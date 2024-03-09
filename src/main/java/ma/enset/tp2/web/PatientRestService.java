package ma.enset.tp2.web;

import ma.enset.tp2.entities.Patient;
import ma.enset.tp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PatientRestService {

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient findPatientByid(@PathVariable("id") Long id) {
        return patientRepository.findById(id).get();
    }

}
