package mns.dfs.eval.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import mns.dfs.eval.views.CommandeView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(CommandeView.class)
    private Integer quantite;

    @ManyToOne
    Commande commande;

    @ManyToOne
    @JsonView(CommandeView.class)
    Article article;
}
