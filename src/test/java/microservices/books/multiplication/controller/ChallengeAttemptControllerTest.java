package microservices.books.multiplication.controller;

import microservices.books.multiplication.challenge.ChallengeAttempt;
import microservices.books.multiplication.challenge.ChallengeAttemptDTO;
import microservices.books.multiplication.challenge.ChallengeService;
import microservices.books.multiplication.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeAttemptController.class)
class ChallengeAttemptControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @MockBean
    private ChallengeService challengeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<ChallengeAttemptDTO> jsonRequestAttempt;

    @Autowired
    private JacksonTester<ChallengeAttempt> jsonResultAttempt;

    @Test
    void postValidResult() throws Exception {
        // given
        User user = new User(1, "john");
        long attemptId = 5L;
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 70, "john", 3500);
        ChallengeAttempt expectedResponse = new ChallengeAttempt(
                attemptId, user, 50, 70, 3500, true);
        given(challengeService.verifyAttempt(eq(attemptDTO))).willReturn(expectedResponse);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                post("/attempts").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestAttempt.write(attemptDTO).getJson())).andReturn().getResponse();

        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(jsonResultAttempt.write(expectedResponse).getJson());
    }

    @Test
    void postInvalidResult() throws Exception {
        // given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(1000, -7, "john", -7000);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                post("/attempts").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestAttempt.write(attemptDTO).getJson())).andReturn().getResponse();

        then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}