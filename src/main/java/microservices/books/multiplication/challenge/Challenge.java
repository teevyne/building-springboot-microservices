package microservices.books.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
public class Challenge {

    private int factorA;

    private int factorB;

    public Challenge(int a, int b) {
        factorA = a;
        factorB = b;
    }

}
