package ar.com.sgifasa.gateway.service;

import ar.com.sgifasa.gateway.dto.OrdenIbcDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrdenesService {

    private final RestTemplate restTemplate;

    private final String X_API_KEY = "GCCD_GraFvu0AUkmV2ajJQS-YWNdY6tf5bXG1SBGqPhxW4SW-AjWXSwb9xnxoyHQ";

    public OrdenesService() {
        this.restTemplate = new RestTemplateBuilder().build();;
    }


    public ResponseEntity<List<OrdenIbcDto>> ordenes(String from, String apiKey) {
        System.out.println("OrdenesService.ordenes() - recibio una petision request");
        //Se debe preparar para INVOCAR al endpoint de la API de Softland
        String endPointOrdenesCosecha = "https://gis.fasa.ibc.ar/api/ordenes/listar-cosecha?from="+from;
        //Se prepara los headers (son generícos)
        HttpHeaders headers1 = new HttpHeaders();
        headers1.set("x-api-key", apiKey);
        headers1.set("Content-Type", "application/json");
        //Va en el requestEntity (puede tener body y/o headers)
        HttpEntity<String> entity= new HttpEntity(headers1);
        try {
            //INVOCA al endpoint de la API y obtiene el RESPONSE
            ResponseEntity<List<OrdenIbcDto>> response= this.restTemplate.exchange(endPointOrdenesCosecha, HttpMethod.GET,entity,
                    new ParameterizedTypeReference<List<OrdenIbcDto>>() {});
            //Analiza el response si devuelve un estado distinto al 200
            if (!response.getStatusCode().equals(HttpStatus.OK)){
                return new ResponseEntity("No se logró enviar la interface.", response.getStatusCode());
            }
            return new ResponseEntity(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
