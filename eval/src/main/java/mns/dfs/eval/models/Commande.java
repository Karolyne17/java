package mns.dfs.eval.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mns.dfs.eval.views.CommandeView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date datePaiement;

    @ManyToOne
    @JsonView(CommandeView.class)
    Utilisateur client;

    @OneToMany(mappedBy = "commande")
    @JsonView(CommandeView.class)
    Set<LigneCommande> listeLigneCommande;


}
