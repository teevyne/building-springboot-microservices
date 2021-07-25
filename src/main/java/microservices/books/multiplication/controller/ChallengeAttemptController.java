package microservices.books.multiplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.books.multiplication.challenge.ChallengeAttempt;
import microservices.books.multiplication.challenge.ChallengeAttemptDTO;
import microservices.books.multiplication.challenge.ChallengeService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
//@RequiredArgsConstructor
@RestController
@RequestMapping("/attempts")
public class ChallengeAttemptController {

    private final ChallengeService challengeService;

    public ChallengeAttemptController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping
    ResponseEntity<ChallengeAttempt> postResult(@RequestBody @Valid ChallengeAttemptDTO attemptDTO) {
        return ResponseEntity.ok(challengeService.verifyAttempt(attemptDTO));
    }
}
