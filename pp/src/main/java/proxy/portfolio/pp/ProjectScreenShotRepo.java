package proxy.portfolio.pp;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectScreenShotRepo extends JpaRepository<ProjectScreenShot, Integer>{
    
}
