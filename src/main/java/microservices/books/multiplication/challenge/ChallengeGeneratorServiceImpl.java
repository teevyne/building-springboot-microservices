package microservices.books.multiplication.challenge;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {

    private static final int MINIMUM_FACTOR = 11;
    private static final int MAXIMUM_FACTOR = 100;
    private final Random random;

    private int next() {
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }

    public ChallengeGeneratorServiceImpl(){
        this.random = new Random();
    }

    public ChallengeGeneratorServiceImpl(Random random) {
        this.random = random;
    }

    @Override
    public Challenge randomChallenge() {
        return new Challenge(next(), next());
    }
}
