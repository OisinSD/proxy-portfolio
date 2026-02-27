package proxy.portfolio.pp;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ProjectScreenShots")
public class ProjectScreenShot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;
    
    @Column(name = "image_url", columnDefinition="TEXT", nullable = false)
    private String imageUrl;

    @Column(name = "caption", length = 300)
    private String caption;

    @Column(name = "display_order")
    private int displayOrder;
}
