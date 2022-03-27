package pl.kris.invoicespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kris.invoicespringmvc.service.InvoiceService;
import pl.kris.invoicespringmvc.model.Invoice;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getAllInvoices(Model model){
        model.addAttribute("allInvoices", invoiceService.getAllInvoices());
        return "gui";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        invoiceService.deleteInvoice(id);
        return "redirect:/";
    }

    @GetMapping(path = "/edit/{id}")
    public String getEditForm(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("invoice", invoiceService.getAllInvoices().stream().filter(x->x.getId().equals(id)).findAny().get());
        return "edit-form";
    }

    @PostMapping(path = "/edit")
    public String submitEditForm(@ModelAttribute Invoice invoice) {
        System.out.println(invoice);
        invoiceService.updateInvoice(invoice);
        return "redirect:/";
    }

    @GetMapping(path = "/add")
    public String getAddForm() {
        return "add-form";
    }

    @PostMapping(path = "/add")
    public String submitAddForm(@ModelAttribute Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return "redirect:/";
    }
}
