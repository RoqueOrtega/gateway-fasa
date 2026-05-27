package ar.com.sgifasa.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RemitosRequest {
    private Integer puntoVenta;
    private String fechaEmision;
    private Integer codigoTipoRemito;
    private String cuitEmisor;
    private String cuitReceptor;
    private String nombreReceptor;
    private String domicilioReceptor;
    private String predio;
    private String rodal;
    private String domicilioFiscal;
    private String condicionIva;
    private Integer tipoTransporte;
    private String cuitTransportista;
    private String nombreTransportista;
    private String dominioVehiculo;
    private String dominioAcoplado;
    private String conductor;
    private String dniConductor;
    private String origenDomicilio;
    private String origenLocalidad;
    private String origenProvincia;
    private String origenCodigoPostal;
    private String destinoDomicilio;
    private String destinoLocalidad;
    private String destinoProvincia;
    private String destinoCodigoPostal;
    private List<ItemRemitoDto> items;
    private String observaciones;
}
