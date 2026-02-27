package proxy.portfolio.pp;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "Projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_name", length = 100, nullable = false)
    private String projectName;

    @Column(unique = true, length = 200, nullable = false)
    private String slug;

    @Column(name = "internal_endpoint", nullable = false)
    private String internalEndpoint;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "respository_url", columnDefinition="TEXT")
    private String repositoryUrl;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectScreenShot> screenshots = new ArrayList<>();
}
