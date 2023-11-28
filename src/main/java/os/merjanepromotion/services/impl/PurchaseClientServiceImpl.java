package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.dto.clientDto.ClientDto;
import os.merjanepromotion.dto.clientDto.FideliterDto;
import os.merjanepromotion.dto.clientDto.RequestRegisterClientDto;
import os.merjanepromotion.entity.Client;
import os.merjanepromotion.entity.Fidelite;
import os.merjanepromotion.entity.Produit;
import os.merjanepromotion.entity.PurchaseHistory;
import os.merjanepromotion.mapper.ProductMapper;
import os.merjanepromotion.mapper.ProduitMapper;
import os.merjanepromotion.mapper.client.RequestClientMapper;
import os.merjanepromotion.mapper.client.RequestFideliterMapper;
import os.merjanepromotion.repository.ClientRepository;
import os.merjanepromotion.repository.FideliteRepository;
import os.merjanepromotion.repository.ProduitRepository;
import os.merjanepromotion.repository.PurchaseRepository;
import os.merjanepromotion.services.PurschaseClientService;
import os.merjanepromotion.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class PurchaseClientServiceImpl implements PurschaseClientService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FideliteRepository fideliteRepository;
    @Autowired
    private ProduitRepository produitRepository;

    private RequestClientMapper INSTANCEClient;
    private ProduitMapper INSTANCEProduit;
    private RequestFideliterMapper INSTANCEFideliter;
    public PurchaseClientServiceImpl(){
       this.INSTANCEClient = RequestClientMapper.INSTANCE;
       this.INSTANCEProduit = ProduitMapper.produitMapper;
       this.INSTANCEFideliter = RequestFideliterMapper.INSTANCE;
    }


    private Client register(ClientDto clientDto) {
        Client client = INSTANCEClient.toEntity(clientDto);
        client.setCodeClient(Helper.codeGenerater(10));
        return clientRepository.save(client);
    }
    private Fidelite fidelite(FideliterDto fideliterDto, Client client){
        Fidelite fidelite = INSTANCEFideliter.toEntity(fideliterDto);
        Optional<Fidelite> clientCartExist = fideliteRepository.findByClient(client);
        if(clientCartExist.isPresent()){
            double total = fidelite.getTotal() + clientCartExist.get().getTotal();
            fidelite = clientCartExist.get();
            fidelite.setTotal(total);
            fidelite = fideliteRepository.save(fidelite);
        }else {
            fidelite.setClient(client);
            fidelite = fideliteRepository.save(fidelite);
        }
        return fidelite;
    }
    private PurchaseHistory makePurchase(ProduitDto produitDto , Client client){
        Produit produit = INSTANCEProduit.toEntity(produitDto);
        Optional<Produit> produit1 = produitRepository.findById(produit.getId());
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        if (produit1.isPresent()){
            purchaseHistory.setProduit(produit);
            purchaseHistory.setClient(client);
            purchaseHistory =purchaseRepository.save(purchaseHistory);
        }
        return  purchaseHistory;
    }
    @Override
    public ClientDto purchase(RequestRegisterClientDto registerClientDto) {
        ClientDto  clientDto = registerClientDto.getClientDto();
        ProduitDto produitDto = registerClientDto.getProduitDto();
        FideliterDto fideliterDto = registerClientDto.getFidelite();
        Client client = INSTANCEClient.toEntity(clientDto);
        client = clientRepository.findByCodeClient(client.getCodeClient());
        if ( client != null){

            this.fidelite(fideliterDto, client);
//            fidelite.setClient(client1);
//            System.out.println(fidelite.toString());
//            fideliteRepository.save(fidelite);
            this.makePurchase(produitDto, client);

        }else {
            client = this.register(clientDto);
            this.fidelite(fideliterDto, client);
            this.makePurchase(produitDto, client);
        }
        return null;
    }
}
