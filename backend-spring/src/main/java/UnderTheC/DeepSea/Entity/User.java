package UnderTheC.DeepSea.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Id
    @Column(length = 15)
    private String ID;
    @Column(length = 20)
    private String passwd;
    @Column(length = 20)
    private String email;
}
