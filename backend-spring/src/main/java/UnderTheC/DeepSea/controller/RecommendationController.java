package UnderTheC.DeepSea.controller;
import UnderTheC.DeepSea.Entity.Evaluation;
import UnderTheC.DeepSea.Entity.Recommendation;
import UnderTheC.DeepSea.repository.RecommendationRepository;
import UnderTheC.DeepSea.repository.EvaluationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@Tag(name = "recommendation API", description = "추천 API")
@RequestMapping("/recommendation")
public class RecommendationController {
    RecommendationRepository recommendationRepository;
    EvaluationRepository evaluationRepository;

    RecommendationController(RecommendationRepository recommendationRepository, EvaluationRepository evaluationRepository) {
        this.recommendationRepository = recommendationRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @PostMapping("/recommend")
    @Operation(summary = "강의 평가 추천, 취소", description = "user id, evaluationID 받아와서 recommendation 테이블에 추가", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public Recommendation recommendEvaluation(@RequestBody Recommendation recommendationRequest
    ) {
        String userID = recommendationRequest.getUserID();
        int evaluationID = recommendationRequest.getEvaluationID();

        Recommendation recommendation = null;
        recommendation = new Recommendation();
        recommendation.setUserID(userID);
        recommendation.setEvaluationID(evaluationID);
        recommendation.setCreated(recommendationRequest.getCreated());


        //같은 userID와 EvaluationID를 가진 Recommendation 객체가 있다면, 추천 삭제
        Optional<Recommendation> existingRecommendation = recommendationRepository.findByUserIDAndEvaluationID(userID, evaluationID);
        Optional<Evaluation> evaluation = evaluationRepository.findById(String.valueOf(evaluationID));
        if (evaluation.isPresent()) {
            if (existingRecommendation.isPresent()) {
                recommendationRepository.delete(existingRecommendation.get());

                if (evaluation.isPresent()) {
                    int temp = evaluation.get().getLikeCount();
                    temp--; // 추천 취소
                    evaluation.get().setLikeCount(temp);
                    evaluationRepository.save(evaluation.get());
                }
            } else {
                if (evaluation.isPresent()) {
                    int temp = evaluation.get().getLikeCount();
                    temp++; //추천
                    evaluation.get().setLikeCount(temp);
                    evaluationRepository.save(evaluation.get());
                    return recommendationRepository.save(recommendation);
                }
            }
            return recommendationRequest;
        } else {
            throw new IllegalArgumentException("평가 ID에 해당하는 객체를 찾을 수 없습니다.");
        }
    }
    @GetMapping("/all")
    @Operation(summary = "모든 추천 조회", description = "recommendation 테이블에 있는 모든 추천 조회", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}

