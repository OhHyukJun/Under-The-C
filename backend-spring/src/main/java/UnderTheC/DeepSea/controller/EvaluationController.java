package UnderTheC.DeepSea.controller;

import UnderTheC.DeepSea.Entity.Evaluation;
import UnderTheC.DeepSea.Entity.User;
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
@Tag(name = "Evaluation API", description = "강의 평가 API")
@RequestMapping("/evaluation")

public class EvaluationController {
    EvaluationRepository evaluationRepository;

    EvaluationController(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }



/*
    @GetMapping("")
    @Operation(summary = "강의 평가 검색", description = "Evaluation 테이블의 모든 강의 반환", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public List<Evaluation> searchEvaluation(
            @RequestParam("lectureDivide") String lectureDivide,
            @RequestParam("searchType") String searchType,
            @RequestParam("search") String search
    ) {
        List<Evaluation> list = null;
        if(search == null ) {
            list = findAll();
        }else{
            list =
        }
        //evaluation = evaluationRepository.find();
        return list;
    }
*/
    @GetMapping("/find")
    @Operation(summary = "강의 평가 모두 찾기", description = "Evaluation 테이블의 모든 강의 평가 반환", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public List<Evaluation> findAll() {
        List<Evaluation> evaluation = null;
        evaluation = evaluationRepository.findAll();
        return evaluation;
    }


    @GetMapping("/view")
    @Operation(summary = "강의 평가 보기", description = "Evaluation 테이블의 evaluationID로 특정 강의 평가 반환", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public Optional<Evaluation> findByEvaluationID(@RequestParam("evaluationID") String evaluationID) {
        Optional<Evaluation> evaluation = null;
        evaluation = evaluationRepository.findById(evaluationID);
        return evaluation;
    }


    @PostMapping("")
    @Operation(summary = "강의 평가 추가", description = "Evaluation 테이블에 강의 평가 추가", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public Evaluation addByEvaluationName(
            @RequestParam("evaluationID") int evaluationID,
            @RequestParam("userID") String userID,
            @RequestParam("lectureName") String lectureName,
            @RequestParam("professorName") String professorName,
            @RequestParam("lectureYear") int lectureYear,
            @RequestParam("semesterDivide") String semesterDivide,
            @RequestParam("lectureDivide") String lectureDivide,
            @RequestParam("evaluationTitle") String evaluationTitle,
            @RequestParam("evaluationContent") String evaluationContent,
            @RequestParam("totalScore") String totalScore,
            @RequestParam("creditScore") String creditScore,
            @RequestParam("comfortableScore") String comfortableScore,
            @RequestParam("lectureScore") String lectureScore,
            @RequestParam("likeCount") int likeCount
            )
    {
        Evaluation evaluation = null;
        evaluation = new Evaluation();
        evaluation.setEvaluationID(evaluationID);
        evaluation.setUserID(userID);
        evaluation.setLectureName(lectureName);
        evaluation.setProfessorName(professorName);
        evaluation.setLectureYear(lectureYear);
        evaluation.setSemesterDivide(semesterDivide);
        evaluation.setLectureDivide(lectureDivide);
        evaluation.setEvaluationTitle(evaluationTitle);
        evaluation.setEvaluationContent(evaluationContent);
        evaluation.setTotalScore(totalScore);
        evaluation.setCreditScore(creditScore);
        evaluation.setTotalScore(totalScore);
        evaluation.setCreditScore(creditScore);
        evaluation.setComfortableScore(comfortableScore);
        evaluation.setLectureScore(lectureScore);
        evaluation.setLikeCount(likeCount);
        evaluationRepository.save(evaluation);
        return evaluation;
    }
/*
    @PostMapping("/update/{id}")
    @Operation(summary = "강의 평가 수정", description = "Evaluation 테이블에 강의 평가 수정", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })

    public Evaluation updateEvaluation(
            @RequestParam("evaluationID") String evaluationID,
            String lectureName,
            String professorName,
            int lectureYear,
            String semesterDivide,
            String lectureDivide,
            String evaluationTitle,
            String evaluationContent,
            String totalScore,
            String creditScore,
            String comfortableScore,
            String lectureScore,
            int likeCount
    )*/

    @DeleteMapping("")
    @Operation(summary = "강의평가 삭제", description = "Evaluation 테이블에 지정된 evaluationID로 강의평가 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "성공")
    })
    public Evaluation deleteByLectureName(@RequestParam("evluationID") String evaluationID) {
        Optional<Evaluation> evaluation = null;
        //Optional<User> user = null;
        evaluation = evaluationRepository.findById(evaluationID);
        evaluationRepository.deleteById(evaluationID);
        return evaluation.get();
    }
}