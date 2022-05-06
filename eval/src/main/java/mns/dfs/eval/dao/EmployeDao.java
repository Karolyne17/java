package mns.dfs.eval.dao;

import mns.dfs.eval.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeDao extends JpaRepository<Employe, Integer> {

    @Query("SELECT COUNT(*) FROM Employe e WHERE e.administrateur = true")

    int compteAdmin();

    boolean existsByLogin(String login);
}
