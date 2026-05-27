package ar.com.sgifasa.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemRemitoDto {
    private String codigo;
    private String descripcion;
    private Integer cantidad;
    private String unidadMedida;
    private Double pesoNeto;
    private Double pesoBruto;
    private String especie;
    private Double largo;
    private String categoria;
    private Double m3Stereo;
    private Double tara;
    private String balanza;
}
