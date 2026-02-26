package proxy.portfolio.pp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ProjectTech")
public class ProjectTech {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tech_id", nullable = false)
    private Technology technology;
}
