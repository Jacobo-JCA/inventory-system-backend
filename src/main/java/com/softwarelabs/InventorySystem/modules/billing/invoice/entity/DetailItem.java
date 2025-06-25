package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;

import java.math.BigDecimal;
import java.util.List;

public class DetailItem {
    /**
     * Código principal del producto/servicio.
     * SRI: Obligatorio. Máximo 25 caracteres.
     */
    //@XmlElement(required = true)
    private String codigoPrincipal;

    /**
     * Descripción del producto/servicio.
     * SRI: Obligatorio. Máximo 300 caracteres.
     */
    //@XmlElement(required = true)
    private String descripcion;

    /**
     * Cantidad del ítem.
     * SRI: Obligatorio. Numérico, hasta 6 decimales.
     */
    //@XmlElement(required = true)
    private BigDecimal cantidad;

    /**
     * Precio unitario del ítem.
     * SRI: Obligatorio. Numérico, hasta 6 decimales.
     */
    //@XmlElement(required = true)
    private BigDecimal precioUnitario;

    /**
     * Descuento aplicado al ítem.
     * SRI: Obligatorio. Si no hay descuento, enviar 0.00. Numérico con 2 decimales.
     */
    //@XmlElement(required = true)
    private BigDecimal descuento;

    /**
     * Subtotal del ítem sin impuestos.
     * SRI: Obligatorio. (cantidad * precioUnitario) - descuento. Numérico con 2 decimales.
     */
    //@XmlElement(required = true)
    private BigDecimal precioTotalSinImpuesto;

    /**
     * Impuestos aplicados a este detalle.
     * SRI: Obligatorio. Debe haber al menos un impuesto (incluso si es IVA 0%).
     */
    //@XmlElementWrapper(name = "impuestos", required = true)
   //@XmlElement(name = "impuesto", required = true)
    private List<TaxInformation> impuestos;

    int[] numbers = new int[4];
}


