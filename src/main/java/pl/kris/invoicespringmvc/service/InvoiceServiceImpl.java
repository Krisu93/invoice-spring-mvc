package pl.kris.invoicespringmvc.service;

import org.springframework.stereotype.Service;
import pl.kris.invoicespringmvc.model.Invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private List<Invoice> invoiceList;

    public InvoiceServiceImpl() {
        this.invoiceList = initInvoices();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return this.invoiceList;
    }

    @Override
    public void deleteInvoice(Long id) {
        Invoice invoice = this.invoiceList.stream().filter(x-> x.getId().equals(id)).findAny().get();
        this.invoiceList.remove(invoice);
    }

    @Override
    public void updateInvoice(Invoice newInvoice) {
        Invoice invoice = this.invoiceList.stream().filter(x-> x.getId().equals(newInvoice.getId())).findAny().get();
        int index = this.invoiceList.indexOf(invoice);
        this.invoiceList.set(index, newInvoice);
    }

    @Override
    public void addInvoice(Invoice newInvoice) {
        List<Long> ids = this.invoiceList.stream().map(Invoice::getId).collect(Collectors.toList());
        newInvoice.setId(1L + Collections.max(ids));
        this.invoiceList.add(newInvoice);
    }

    private List<Invoice> initInvoices(){
        Invoice i1 = new Invoice(1L, BigDecimal.valueOf(100), LocalDate.of(2022,10,10),  "LiveBook: Spring Boot 1");
        Invoice i2 = new Invoice(2L, BigDecimal.valueOf(200), LocalDate.of(2023,2,12),  "LiveBook: Spring Boot 2");
        Invoice i3 = new Invoice(3L, BigDecimal.valueOf(550), LocalDate.of(2025,7,10),  "LiveBook: Spring Boot 3");

        List<Invoice> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);

        return list;
    }
}
