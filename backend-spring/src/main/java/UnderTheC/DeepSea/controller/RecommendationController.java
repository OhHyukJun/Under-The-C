package UnderTheC.DeepSea.controller;
import UnderTheC.DeepSea.Entity.Evaluation;
import UnderTheC.DeepSea.Entity.Lecture;
import UnderTheC.DeepSea.Entity.Recommendation;
import UnderTheC.DeepSea.controller.EvaluationController;
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
    EvaluationController evaluationController;

    RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @PostMapping("/recommend")
    @Operation(summary = "강의 평가 추천", description = "user id, evaluationID 받아와서 recommendation테이블에 추가", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public Recommendation recommendEvaluation(
            @RequestParam("userID") String userID,
            @RequestParam("evaluationID") int evaluationID,
            @RequestParam("recIndex") int recID
    ) {
        Recommendation recommendation = null;
        recommendation = new Recommendation();
        recommendation.setUserID(userID);
        recommendation.setEvaluationID(userID);


        Optional<Evaluation> evaluation = null;
        evaluation = evaluationRepository.findById(String.valueOf(evaluationID));
        int temp =evaluation.get().getLikeCount();
        if(evaluation.get().getUserID()==userID && evaluation.get().getEvaluationID()==evaluationID){
            temp--; //추천 삭제
            evaluation.get().setLikeCount(temp);
        }
        else{
            temp++;
            evaluation.get().setLikeCount(temp);
        }
        return recommendation;
    }



}
