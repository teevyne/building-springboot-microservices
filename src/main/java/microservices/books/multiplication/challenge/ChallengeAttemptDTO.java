package microservices.books.multiplication.challenge;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Value
//@AllArgsConstructor
public class ChallengeAttemptDTO {

    @Min(1) @Max(99)
    int factorA, factorB;

    @NotBlank
    String alias;

    @Positive(message = "How could you possibly get a negative result here? Try again.")
    int guess;

    public int getFactorA() {
        return factorA;
    }

    public int getFactorB() {
        return factorB;
    }

    public String getAlias() {
        return alias;
    }

    public int getGuess() {
        return guess;
    }

    public ChallengeAttemptDTO(int a, int b, String c, int d) {
        factorA = a;
        factorB = b;
        alias = c;
        guess = d;
    }
}
