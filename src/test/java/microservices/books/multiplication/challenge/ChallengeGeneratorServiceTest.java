package microservices.books.multiplication.challenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChallengeGeneratorServiceTest {

    private ChallengeGeneratorService challengeGeneratorService;

    @Spy
    private Random random;

    @BeforeEach
    void setUp() {
        challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGenerateRandomFactorsIsBetweenLimits(){

        given(random.nextInt(89)).willReturn(20, 30);
        Challenge challenge = challengeGeneratorService.randomChallenge();
        then(challenge).isEqualTo(new Challenge(31, 41));

    }
}