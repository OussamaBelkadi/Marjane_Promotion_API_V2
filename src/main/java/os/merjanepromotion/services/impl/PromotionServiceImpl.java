package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.*;
import os.merjanepromotion.entity.*;
import os.merjanepromotion.exceptions.business.NotFoundException;
import os.merjanepromotion.exceptions.business.OutOfTimeExpection;
import os.merjanepromotion.mapper.ProduitMapper;
import os.merjanepromotion.mapper.PromotiomMapper;
import os.merjanepromotion.repository.ProductRepository;
import os.merjanepromotion.repository.PromotionRepository;
import os.merjanepromotion.repository.ResponsableRayonRepository;
import os.merjanepromotion.services.PromotionService;
import os.merjanepromotion.util.Observer.Observable;
import os.merjanepromotion.util.Observer.ObservableImpl;
import os.merjanepromotion.util.Observer.Observer;
import os.merjanepromotion.util.Observer.ResponsableObserver;

import java.time.LocalTime;
import java.util.*;

@Service
@Transactional
@Slf4j
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ProductRepository productRepository;

    private final ResponsableRayonRepository responsableRayonRepository;
    private final ObservableImpl promotionObservable;
    private final ResponsableObserver responsableObserver;


//    Logger logger = org.slf4j.LoggerFactory.getLogger(PromotionServiceImpl.class);


    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository, ProductRepository productRepository, ResponsableRayonRepository responsableRayonRepository, ObservableImpl promotionObservable, ResponsableObserver responsableObserver) {
        this.promotionRepository = promotionRepository;
        this.productRepository = productRepository;
        this.responsableRayonRepository =  responsableRayonRepository;
        this.promotionObservable = promotionObservable;
        this.responsableObserver = responsableObserver;
    }

    @Override
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto) {
        log.info("addPromotion" , produitDto , promotionDto);
        Produit produit = ProduitMapper.produitMapper.toEntity(produitDto);
        Promotion promotion = PromotiomMapper.promotionMapper.toEntity(promotionDto);
        Optional<Produit> optionalProduit = productRepository.findById(produit.getId());
        if (optionalProduit.isPresent()){

            produit = optionalProduit.get();
            double prix = produit.getPrix();
            double pourcentage = promotion.getPrecentage()/100;
            double prixPromotion = prix - (prix * pourcentage);
            produit.setPrix(prixPromotion);
            productRepository.save(produit);
            //TODO: Tu dois avoir le responsable rayon consernner et tu dois remplire table Rayon
            Long id = 0L;
//            ResponsableRayon responsableRayon = null;
            Categorie categorie = produit.getCatfegorie();
//            Rayon rayon = categorie.getRayon();
//            ResponsableRayon responsableRayon = rayon.getResponsableRayon();
//            Categorie categorie = produit.getCategorie();
            promotionObservable.subscriber(responsableObserver);
            System.out.println(categorie);
//            responsableObserver.setResponsableRayon(responsableRayon);
            promotionObservable.addPromotion(promotion);
//            responsablenotif(id);
//            promotionRepository.save(promotion);

            produitDto = ProduitMapper.produitMapper.toDto(produit);
            return produitDto;
        }else {
            throw new NotFoundException("Le produit n'existe pas");
        }
    }

    private void responsablenotif(Long id){
        Optional<ResponsableRayon> responsableRayon = responsableRayonRepository.findById(id);
        if (responsableRayon.isPresent()){
            ResponsableRayon responsableRayon1 = responsableRayon.get();
            responsableObserver.setResponsableRayon(responsableRayon1);
        }else {
            throw  new NotFoundException("Il a aucun responassable rayon pour ce rayon");
        }
    }
    @Override
    public List<PromotionDto> getAll() {

        log.info("getAll");
        List<PromotionDto> promotionDtos = new ArrayList<>();
        this.promotionRepository.findAll().forEach(promotion -> {
            promotionDtos.add(PromotiomMapper.promotionMapper.toDto(promotion));
        });

        return promotionDtos;
    }

    @Override
    public Collection<PromotionDto> consulterListPromotionValide() {
        log.info("consulterListPromotionValide");
        Collection<PromotionDto> promotionDtos = new ArrayList<>();
        isCurrentTimeInRange();
        for (Promotion promotion : promotionRepository.findAll()) {
            promotionDtos.add(PromotiomMapper.promotionMapper.toDto(promotion));
        }
        return promotionDtos;
    }

    @Override
    public Collection<PromotionDto> consulterListPromotionValideParId(int id) {
        log.info("consulterListPromotionValideParId");
//        Long id = Long.getLong(id);
        Long idLong = Long.valueOf(id);
        this.promotionRepository.findById(idLong );
        return null;
    }



    @Override
    public Collection<PromotionDto> consulterListPromotionPourResponsableRayon(int id) {
//        logger.info("consulter List Promotion Par Responsable Rayon");
        Collection<PromotionDto> promotionDtos = new ArrayList<>();
        isCurrentTimeInRange();

        Long idLong = Long.valueOf(id);


        Optional<ResponsableRayon> responsableRayon = responsableRayonRepository.findById(idLong);

        if (responsableRayon.isPresent()){
                responsableRayon.get().getRayon().getCategorie().getProduits().forEach(
                        produit -> {

                            Date dateFin = produit.getPromotion().getDateFin();
                            Date dateDebut = produit.getPromotion().getDateDebut();

                            if (produit.getQuantite() > 0 &&  !dateDebut.before(new Date()) && !dateFin.after(new Date())){
                                promotionDtos.add(PromotiomMapper.promotionMapper.toDto(produit.getPromotion()));
                            }

                        }

                );

                promotionDtos.add(PromotiomMapper.promotionMapper.toDto(responsableRayon.get().getRayon().getCategorie().getPromotion()));
                return promotionDtos;


        }else {
            throw new NotFoundException("Le responsable n'existe pas");
        }


    }

    public  boolean isCurrentTimeInRange() {
        final LocalTime START_TIME = LocalTime.of(8, 0); // 8 AM
        final LocalTime END_TIME = LocalTime.of(12, 0); // 12 PM
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(START_TIME) || currentTime.isAfter(END_TIME)) {

            throw  new
                    OutOfTimeExpection("les promotions soient consultables par les" +
                    " responsable des rayon seulement entre 8h-12h00 du matin ,");
        }

        return true;
    }



}
