package microservices.books.multiplication.challenge;

/**
 * Verifies if an attempt coming from the presentation layer is correct or not.
 *
 * @return the resulting ChallengeAttempt object
 */

public interface ChallengeService {

    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);

}
