package proxy.portfolio.pp;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.Optional;

@SpringBootTest
@Transactional
// @DataJpaTest
public class SkillRepoIntegrationTest {
    
    @Autowired
    private SkillRepo skillRepo;
    @Autowired
    private ProjectSkillRepo projectSkillRepo;
    @Autowired
    private ProjectRepo projectRepo;

    @Test
    void shouldSaveAndRetrieveSkill(){

        // Arrange
        Skill mySkill = new Skill();
        mySkill.setName("JavaSpringBoot");
        mySkill.setProficiencyLevel("Intermediate");
        mySkill.setNarrative("I Gained Skill in Java Spring Boot by doing this Portfolio Project");
        mySkill.setCategory("Coding Language");

        // Act
        Skill savedSkill = skillRepo.save(mySkill);
        Integer id = savedSkill.getId();

        // Assert on Save
        assertThat(id).isNotNull();
        assertThat(savedSkill.getName()).isEqualTo("JavaSpringBoot");

        // Act (Retrieve)
        Optional<Skill> foundSkillOptional = skillRepo.findById(id);

        // Assert on Retrieve
        assertThat(foundSkillOptional).isPresent();

    }

    @Test
    void shouldNotFindMissingSkill(){

        // Act
        Optional<Skill> foundSkillOptional = skillRepo.findById(99999); //Non-existant ID

        // Assert
        assertThat(foundSkillOptional).isNotPresent(); 

    }

    @Test
    void shouldThrowExceptionWhenMissingForeignKey(){

        // Arrange skill
        Skill mySkill = new Skill();
        mySkill.setName("Testing");
        mySkill.setCategory("Testing");
        mySkill.setNarrative("Learning Right Now");
        mySkill.setProficiencyLevel("Beginner");

        // Act 
        skillRepo.saveAndFlush(mySkill);

        // Arrange Project
        Project myProject = new Project();
        myProject.setProjectName("Test Project");
        myProject.setSlug("Test Project " + System.currentTimeMillis());
        myProject.setInternalEndpoint("http://localhost:8080/test");
        // myProject.setIsActive(true);
        myProject.setRepositoryUrl("https://github.com/user/repo");
        
        // Act 
        projectRepo.saveAndFlush(myProject);

        // Arrange join table
        ProjectSkill pSkill = new ProjectSkill();
        // pSkill.setProject(myproject); // Purposefully omitting the project id -> expecting a DataIntegrityVioloation error
        pSkill.setSkill(mySkill);
        
        // ProjectSkill projectSkill = projectSkill.save(mySkill);

        // Act
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, 
            () -> {
                projectSkillRepo.saveAndFlush(pSkill);
            });
    }
}
