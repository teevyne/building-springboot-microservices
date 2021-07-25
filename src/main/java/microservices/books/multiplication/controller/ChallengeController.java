package microservices.books.multiplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.books.multiplication.challenge.Challenge;
import microservices.books.multiplication.challenge.ChallengeGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
//@RequiredArgsConstructor
@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final Logger logger = Logger.getLogger(Challenge.class.getName());

    private final ChallengeGeneratorService challengeGeneratorService;

    public ChallengeController(ChallengeGeneratorService challengeGeneratorService) {
        this.challengeGeneratorService = challengeGeneratorService;
    }

    @GetMapping("/random")
    Challenge getRandomChallenge() {
        Challenge challenge = challengeGeneratorService.randomChallenge();
        logger.info("Generating a random challenge: {}");
        return challenge;
    }
}