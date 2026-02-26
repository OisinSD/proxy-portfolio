package proxy.portfolio;

import org.springframework.stereotype.Repository;

import proxy.portfolio.pp.ProjectScreenShot;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectScreenShotRepo extends JpaRepository<ProjectScreenShot, Integer>{
    
}
