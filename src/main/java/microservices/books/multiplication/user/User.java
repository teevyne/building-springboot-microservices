package microservices.books.multiplication.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
public class User {

    private int id;

    private String alias;

    public User(int id, String alias) {
        this.id = id;
        this.alias = alias;
    }
}
