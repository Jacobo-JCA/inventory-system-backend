//package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//@Embeddable
//class TaxSummary {
//    /**
//     * Código del impuesto.
//     * SRI: Obligatorio. '2' = IVA.
//     */
//    @XmlElement(required = true)
//    private String codigo;
//
//    /**
//     * Código de la tarifa del impuesto.
//     * SRI: Obligatorio. '0'=IVA 0%, '2'=IVA 12% (o 15% según aplique), '6'=No Objeto IVA.
//     */
//    @XmlElement(required = true)
//    private String codigoPorcentaje;
//
//    /**
//     * Suma de las bases imponibles para este impuesto y tarifa.
//     * SRI: Obligatorio. Valor numérico con 2 decimales.
//     */
//    @XmlElement(required = true)
//    private BigDecimal baseImponible;
//
//    /**
//     * Valor total del impuesto para esta tarifa.
//     * SRI: Obligatorio. Valor numérico con 2 decimales.
//     */
//    @XmlElement(required = true)
//    private BigDecimal valor;
//}
