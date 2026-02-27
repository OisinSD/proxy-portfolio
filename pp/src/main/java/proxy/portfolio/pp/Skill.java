package proxy.portfolio.pp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "Skills")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "proficiency_level", length = 200, nullable = false)
    private String proficiencyLevel;


    @Column(name = "narrative", length = 300, nullable = false)
    private String narrative;

    @Column(name = "category", length = 200)
    private String category;

}
