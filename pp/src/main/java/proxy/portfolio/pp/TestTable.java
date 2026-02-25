package proxy.portfolio.pp;

import jakarta.persistence.Entity;
// import jakarta.persistence.GenerationValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TestTable")
public class TestTable {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
