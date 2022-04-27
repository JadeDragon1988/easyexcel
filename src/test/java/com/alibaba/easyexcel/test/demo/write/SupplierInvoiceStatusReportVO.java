package com.alibaba.easyexcel.test.demo.write;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SupplierInvoiceStatusReportVO {
    private String company;

    private String dpp;

    private String processByOrder;

    private String supplierType;

    private String supplierInvoiceCode;

    private String supplierName;

    private BigDecimal orderNumber;

    private String proformaNumber;

    private String fapiaoNumber;

    private BigDecimal amount;

    private String currency;

    // latest shipment date
    @DateTimeFormat(value = "yyyyMMdd")
    private LocalDate proformaIssueDate;

    // real invoice issue date
    @DateTimeFormat(value = "yyyyMMdd")
    private LocalDate invoiceDate;

    @DateTimeFormat(value = "yyyyMMdd")
    private LocalDate dueDate;

    private String orderStatus;

    @DateTimeFormat(value = "yyyyMMdd")
    private LocalDate paymentDate;

    // 以下字段用于报表逻辑判断计算
    @ExcelIgnore
    private String proformaUuid; // 区分是否线下票/有没有proforma阶段
    @ExcelIgnore
    private String fapiaoType;
    @ExcelIgnore
    private LocalDate fapiaoIssueDate;
    @ExcelIgnore
    private BigDecimal billingProposalLineProformaLineAmount;
    @ExcelIgnore
    private BigDecimal billingProposalLineProformaLineQuantity;
    @ExcelIgnore
    private LocalDate fapiaoReceivedDate;
    @ExcelIgnore
    private String fapiaoLineUuid;
    @ExcelIgnore
    private BigDecimal fapiaoLinePrice;
    @ExcelIgnore
    private BigDecimal fapiaoLineQuantity;
    @ExcelIgnore
    private LocalDate matchingDate;
}
