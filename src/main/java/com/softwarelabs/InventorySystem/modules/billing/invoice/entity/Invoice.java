//package com.softwarelabs.InventorySystem.modules.billing.invoice.entity;
//
//import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlAttribute;
//import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlElementWrapper;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "invoices")
//@Entity
//public class Invoice {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idInvoice;
//    /**
//     * Contiene la información fiscal y de identificación del comprobante.
//     * SRI: Campo Obligatorio. Agrupa datos del emisor y del documento.
//     */
//    @XmlElement(required = true)
//    private TaxInformation taxInformation;
//
//    /**
//     * Contiene la información específica de la factura y del comprador.
//     * SRI: Campo Obligatorio. Detalles de la transacción y del cliente.
//     */
//    @XmlElement(required = true)
//    private InvoiceInformation invoiceInformation;
//
//    /**
//     * Contiene la lista de productos o servicios facturados.
//     * SRI: Campo Obligatorio. Debe existir al menos un detalle.
//     */
//    @XmlElementWrapper(name = "detalles", required = true)
//    @XmlElement(name = "detalle", required = true)
//    private List<DetailItem> details;
//
//    /**
//     * Atributo fijo para identificar el tipo de comprobante.
//     * SRI: Obligatorio, valor fijo "comprobante".
//     */
//    @XmlAttribute(name = "id")
//    private final String idReceipt = "comprobante";
//
//    /**
//     * Versión del formato de la factura. Usa "1.1.0" para 6 decimales o "1.0.0" para 2.
//     * SRI: Obligatorio. Se recomienda "1.1.0".
//     */
//    @XmlAttribute(name = "version")
//    private String schemaVersion  = "1.1.0";
//}
