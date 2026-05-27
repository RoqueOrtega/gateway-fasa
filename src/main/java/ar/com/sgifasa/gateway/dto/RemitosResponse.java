package ar.com.sgifasa.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RemitosResponse {
    private Boolean success;
    private String cae;
    private String vencimientoCae;
    private RemitoDto remito;
}
