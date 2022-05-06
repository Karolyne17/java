package mns.dfs.eval.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mns.dfs.eval.views.CommandeView;
import mns.dfs.eval.views.EmployeView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

public class Employe extends Utilisateur{

    @JsonView(EmployeView.class)
    private boolean administrateur;

    @OneToMany(mappedBy = "gestionnaire")
    @JsonView(EmployeView.class)
    Set<Article> listeArticleAgerer;
}
