package ma.enset.tp2;

import ma.enset.tp2.entities.Patient;
import ma.enset.tp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner{

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Patient p1 = new Patient();
		p1.setNom("aaaaa");
		p1.setDateNaissanec(new Date());
		p1.setScore(1212);
		p1.setMalade(true);

		Patient p2 = new Patient(null, "bbbbb", new Date(), false,  1212);

		Patient p3 = Patient.builder().build();

		// save patients in db
//		patientRepository.save(p1);
//		patientRepository.save(p2);
//		patientRepository.save(p3);

		List<Patient> patients = patientRepository.findAll();
		patients.forEach(System.out::println);

		Patient patient = patientRepository.findById(Long.valueOf(1)).get();
		System.out.println(patient);

		System.out.println("the PatientRepository method test : ");
		patients = patientRepository.search("%a%");
		patients.forEach(System.out::println);
		int score = 10;
		System.out.println("Patients with score great than " + score);
		patients = patientRepository.searchByScore(score);
		//patients = patientRepository.findByScoreGreaterThan(score);
		patients.forEach(System.out::println);


	}
}
