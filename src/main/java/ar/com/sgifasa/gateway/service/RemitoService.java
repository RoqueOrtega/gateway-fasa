package ar.com.sgifasa.gateway.service;

import ar.com.sgifasa.gateway.dto.RemitosEnvioRequest;
import ar.com.sgifasa.gateway.dto.RemitosEnvioResponse;
import ar.com.sgifasa.gateway.dto.RemitosRequest;
import ar.com.sgifasa.gateway.dto.RemitosResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemitoService {

    private final RestTemplate restTemplate;

    public RemitoService() {
        this.restTemplate = new RestTemplateBuilder().build();;
    }

    public ResponseEntity<RemitosResponse> informarRemito(RemitosRequest request){
        System.out.println("RemitoService.informarRemito() - recibio una petision request");
        //Se debe preparar para INVOCAR al endpoint de la API de Remitos de Lautaro
        String endPointRemitos = "https://remitero-afip.vercel.app/api/remitos";
        //Se prepara los headers (son generícos)
        HttpHeaders headers1 = new HttpHeaders();
        headers1.set("Content-Type", "application/json");
        //Va en el requestEntity (puede tener body y/o headers)
        HttpEntity<String> entity= new HttpEntity(request, headers1);
        try {
            //INVOCA al endpoint de la API y obtiene el RESPONSE
            ResponseEntity<RemitosResponse> responseRemitos = this.restTemplate.exchange(endPointRemitos, HttpMethod.POST,entity, RemitosResponse.class);
            //Analiza el response si devuelve un estado distinto al 200
            if (!responseRemitos.getStatusCode().equals(HttpStatus.OK)){
                return new ResponseEntity("No se logró informar el remito en ARCA.", responseRemitos.getStatusCode());
            }
            return responseRemitos;
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<RemitosEnvioResponse> enviarRemito(String id, RemitosEnvioRequest request){
        System.out.println("RemitoService.enviarRemito() - recibio una petision request");
        //Se debe preparar para INVOCAR al endpoint de la API de Remitos de Lautaro
        String endPointEnvioRemitos = "https://remitero-afip.vercel.app/api/remitos/"+id+"/enviar";
        //Se prepara los headers (son generícos)
        HttpHeaders headers1 = new HttpHeaders();
        headers1.set("Content-Type", "application/json");
        //Va en el requestEntity (puede tener body y/o headers)
        HttpEntity<String> entity= new HttpEntity(request, headers1);
        try {
            //INVOCA al endpoint de la API y obtiene el RESPONSE
            ResponseEntity<RemitosEnvioResponse> responseRemitos = this.restTemplate.exchange(endPointEnvioRemitos, HttpMethod.POST,entity, RemitosEnvioResponse.class);
            //Analiza el response si devuelve un estado distinto al 200
            if (!responseRemitos.getStatusCode().equals(HttpStatus.OK)){
                return new ResponseEntity("No se logró enviar el remito por WhatsApp", responseRemitos.getStatusCode());
            }
            return responseRemitos;
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
