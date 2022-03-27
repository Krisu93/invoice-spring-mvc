package pl.kris.invoicespringmvc.service;

import pl.kris.invoicespringmvc.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    void deleteInvoice(Long id);
    void updateInvoice(Invoice newInvoice);
    void addInvoice(Invoice newInvoice);
}
