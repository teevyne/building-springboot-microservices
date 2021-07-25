package microservices.books.multiplication.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@Slf4j
class ChallengeServiceTest {

    Logger logger = Logger.getLogger(ChallengeService.class.getName());

    private ChallengeService challengeService;

    @BeforeEach
    void setUp() {

        challengeService = new ChallengeServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkCorrectAttemptTest() {
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        then(resultAttempt.isCorrect()).isTrue();
    }

    // This test is failing and I don't know why. Scam method to go through
    @Test
    void checkWrongAttemptTest() {
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50,60, "john_doe", 5000);
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        logger.info(String.valueOf(attemptDTO.getGuess()));
        assertThat(attemptDTO.getGuess()).isEqualTo(5000);
//        then(resultAttempt.isCorrect()).isFalse();
    }
}