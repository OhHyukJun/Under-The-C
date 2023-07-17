package UnderTheC.DeepSea.repository;

import UnderTheC.DeepSea.Entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {


    Recommendation findByUserID(String userID);

    Optional<Recommendation> findByUserIDAndEvaluationID(String userID, int evaluationID);
}
