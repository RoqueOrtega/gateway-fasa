package ar.com.sgifasa.gateway.controller;

import ar.com.sgifasa.gateway.dto.RemitosEnvioRequest;
import ar.com.sgifasa.gateway.dto.RemitosEnvioResponse;
import ar.com.sgifasa.gateway.dto.RemitosRequest;
import ar.com.sgifasa.gateway.dto.RemitosResponse;
import ar.com.sgifasa.gateway.service.RemitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiRemitosController {

    @Autowired
    RemitoService remitoService;

    @PostMapping("/api/remitos")
    public ResponseEntity<RemitosResponse> informarRemito(@RequestBody RemitosRequest request){
        return remitoService.informarRemito(request);
    }

    @PostMapping("/api/remitos/{id}/enviar")
    public ResponseEntity<RemitosEnvioResponse> enviarWhatsApp(@PathVariable String id,
                                                               @RequestBody RemitosEnvioRequest request){
        System.out.println("El id recibido es: "+id);
        return remitoService.enviarRemito(id, request);
    }
}
