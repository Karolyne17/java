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
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(EmployeView.class)
    private String nom;

    @JsonView(CommandeView.class)
    private float prix;

    @ManyToOne
    Employe gestionnaire;
}
