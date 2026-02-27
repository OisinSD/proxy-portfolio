package proxy.portfolio.pp;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProjectSkillRepo extends JpaRepository<ProjectSkill, Integer>{
    
}
