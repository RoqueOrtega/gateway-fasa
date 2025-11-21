package ar.com.sgifasa.gateway.controller;

import ar.com.sgifasa.gateway.dto.OrdenIbcDto;
import ar.com.sgifasa.gateway.service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiRodalesController {

    @Autowired
    private OrdenesService ordenesService;

    @GetMapping("/api-rodales")
    public ResponseEntity<List<OrdenIbcDto>> controles(@RequestParam("from")String from,
                                                       @RequestHeader("x-api-key") String apiKey){
        return ordenesService.ordenes(from, apiKey);
    }
}
