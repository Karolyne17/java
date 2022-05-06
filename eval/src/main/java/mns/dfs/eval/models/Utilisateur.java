package mns.dfs.eval.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mns.dfs.eval.views.CommandeView;
import mns.dfs.eval.views.EmployeView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(EmployeView.class)
    private Integer id;

    @JsonView({CommandeView.class, EmployeView.class})
    private String login;

    @JsonView(EmployeView.class)
    private String password;

    @ManyToMany
    Set<MoyenPaiement> listeMoyenPaiement;

    @OneToMany(mappedBy = "client")
    Set<Commande> listeCommande;
}
