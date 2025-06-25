//package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;
//
//import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlElementWrapper;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "invoice_details")
//@Entity
//class InvoiceInformation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    /**
//     * Fecha de emisión de la factura.
//     * SRI: Obligatorio. Formato dd/MM/yyyy.
//     */
//    @XmlElement(required = true)
//    private String fechaEmision;
//
//    /**
//     * Indica si el emisor está obligado a llevar contabilidad.
//     * SRI: Obligatorio. 'SI' o 'NO'.
//     */
//    @XmlElement(required = true)
//    private String obligadoContabilidad;
//
//    /**
//     * Tipo de identificación del comprador (cliente).
//     * SRI: Obligatorio. '04'=RUC, '05'=Cédula, '06'=Pasaporte, '07'=Consumidor Final, '08'=ID Exterior.
//     */
//    @XmlElement(required = true)
//    private String tipoIdentificacionComprador;
//
//    /**
//     * Razón Social o Nombres y Apellidos del comprador (cliente).
//     * SRI: Obligatorio. Máx 300. Si es '07', debe ser "CONSUMIDOR FINAL".
//     */
//    @XmlElement(required = true)
//    private String razonSocialComprador;
//
//    /**
//     * Número de identificación del comprador (cliente).
//     * SRI: Obligatorio. Máx 13. Si es '07', debe ser "9999999999999".
//     */
//    @XmlElement(required = true)
//    private String identificacionComprador;
//
//    /**
//     * Suma de todos los 'precioTotalSinImpuesto' de los detalles.
//     * SRI: Obligatorio. Valor numérico con 2 decimales.
//     */
//    @XmlElement(required = true)
//    private BigDecimal totalSinImpuestos;
//
//    /**
//     * Suma de todos los 'descuento' de los detalles.
//     * SRI: Obligatorio. Valor numérico con 2 decimales.
//     */
//    @XmlElement(required = true)
//    private BigDecimal totalDescuento;
//
//    /**
//     * Contiene los totales agrupados por cada tipo de impuesto.
//     * SRI: Obligatorio. Debe haber al menos un 'totalImpuesto'.
//     */
//    @XmlElementWrapper(name = "totalConImpuestos", required = true)
//    @XmlElement(name = "totalImpuesto", required = true)
//    private List<TaxSummary> totalConImpuestos;
//
//    /**
//     * Valor de la propina.
//     * SRI: Obligatorio. Generalmente '0.00'. Valor numérico con 2 decimales.
//     */
//    @XmlElement(required = true)
//    private BigDecimal propina;
//
//    /**
//     * Valor total de la factura.
//     * SRI: Obligatorio. (totalSinImpuestos - totalDescuento + totalValorImpuestos + propina).
//     */
//    @XmlElement(required = true)
//    private BigDecimal importeTotal;
//
//    /**
//     * Moneda utilizada.
//     * SRI: Obligatorio (aunque la ficha a veces lo marca opcional, es buena práctica incluirlo). 'DOLAR'.
//     */
//    @XmlElement
//    private String moneda = "DOLAR";
//
//    /**
//     * Contiene las formas de pago. Para efectivo, solo una entrada.
//     * SRI: Obligatorio. Debe haber al menos un 'pago'.
//     */
//    @XmlElementWrapper(name = "pagos", required = true)
//    @XmlElement(name = "pago", required = true)
//    private List<Payment> payments;
//}