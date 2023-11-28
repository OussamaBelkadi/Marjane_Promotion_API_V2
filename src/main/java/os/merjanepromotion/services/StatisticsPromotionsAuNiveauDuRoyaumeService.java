package os.merjanepromotion.services;

import os.merjanepromotion.dto.PromotionStatistiques;

import java.util.Collection;

public interface StatisticsPromotionsAuNiveauDuRoyaumeService {

    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String...status);
}
