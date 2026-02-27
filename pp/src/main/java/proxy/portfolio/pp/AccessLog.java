package proxy.portfolio.pp;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.time.OffsetDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AccessLog")
public class AccessLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

    @Column(name = "accessed_at", nullable = false, updatable = false)
    private OffsetDateTime accessedAt;

    @Column(name = "ip_address", columnDefinition = "TEXT")
    private String ipAddress;

    @Column(name = "user_agent", nullable = false, length = 200)
    private String userAgent;
}
