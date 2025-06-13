package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;

import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
class TaxInformation {
    /**
     * Ambiente de operación.
     * SRI: Obligatorio. '1' = Pruebas, '2' = Producción.
     */
    @XmlElement(required = true)
    private String ambiente;

    /**
     * Tipo de emisión. Para offline siempre es '1'.
     * SRI: Obligatorio. '1' = Normal.
     */
    @XmlElement(required = true)
    private String tipoEmision;

    /**
     * Razón social del emisor.
     * SRI: Obligatorio. Máximo 300 caracteres.
     */
    @XmlElement(required = true)
    private String razonSocial;

    /**
     * RUC del emisor.
     * SRI: Obligatorio. 13 dígitos numéricos.
     */
    @XmlElement(required = true)
    private String ruc;

    /**
     * Clave de acceso generada (49 dígitos).
     * SRI: Obligatorio. Se genera según algoritmo del SRI.
     */
    @XmlElement(required = true)
    private String claveAcceso;

    /**
     * Código del tipo de documento.
     * SRI: Obligatorio. '01' para Factura.
     */
    @XmlElement(required = true)
    private String codDoc;

    /**
     * Código del establecimiento (001, 002, etc.).
     * SRI: Obligatorio. 3 dígitos.
     */
    @XmlElement(required = true)
    private String estab;

    /**
     * Código del punto de emisión (001, 002, etc.).
     * SRI: Obligatorio. 3 dígitos.
     */
    @XmlElement(required = true)
    private String ptoEmi;

    /**
     * Número secuencial de la factura.
     * SRI: Obligatorio. 9 dígitos.
     */
    @XmlElement(required = true)
    private String secuencial;

    /**
     * Dirección de la matriz del emisor.
     * SRI: Obligatorio. Máximo 300 caracteres.
     */
    @XmlElement(required = true)
    private String dirMatriz;
}
