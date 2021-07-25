package microservices.books.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import microservices.books.multiplication.user.User;

@Getter
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
public class ChallengeAttempt {

    private Long id;

    private User userId;

    private int factorA;

    private int factorB;

    private int resultAttempt;

    private boolean correct;

    public ChallengeAttempt(Long id, User userId, int factorA, int factorB, int resultAttempt, boolean correct) {
        this.id = id;
        this.userId = userId;
        this.factorA = factorA;
        this.factorB = factorB;
        this.resultAttempt = resultAttempt;
        this.correct = correct;
    }

    public boolean isCorrect(){
        return true;
    }
}
