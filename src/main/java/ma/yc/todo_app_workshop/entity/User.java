package ma.yc.todo_app_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "TODOUSERS")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
    private String username;
    private String password ;
    private String email ;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER)
    private Collection<Todo> todos = new ArrayList<>();
}
