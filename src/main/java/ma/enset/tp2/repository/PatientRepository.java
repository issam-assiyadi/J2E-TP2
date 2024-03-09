package ma.enset.tp2.repository;

import ma.enset.tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    // search by name
    List<Patient> findByNomContains(String mc);
    @Query("SELECT p FROM Patient p where p.nom like :x")
    List<Patient> search(@Param("x") String mc);


    // to find patients with a score greater than a specific score
    List<Patient> findByScoreGreaterThan(int score);
    @Query("select p from  Patient  p where p.score > :x")
    List<Patient> searchByScore(@Param("x") int score);

}
