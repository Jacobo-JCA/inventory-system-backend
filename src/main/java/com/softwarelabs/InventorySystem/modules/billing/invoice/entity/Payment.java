package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
class Payment {
    /**
     * Código de la forma de pago.
     * SRI: Obligatorio. '01' = SIN UTILIZACION DEL SISTEMA FINANCIERO (incluye efectivo).
     */
    @XmlElement(required = true)
    @Column(nullable = false)
    private final String formaPago = "01"; // Fijo para tu caso
    /**
     * Monto total pagado con esta forma.
     * SRI: Obligatorio. Debe ser igual al 'importeTotal' de la factura.
     */
    @XmlElement(required = true)
    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal total;


}
