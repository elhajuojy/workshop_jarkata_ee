package ma.yc.todo_app_workshop.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.yc.todo_app_workshop.enums.Priority;
import ma.yc.todo_app_workshop.enums.Progress;

@Entity
@Table(name = "TODO")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Progress progress;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ManyToOne
    private User user ;

}
