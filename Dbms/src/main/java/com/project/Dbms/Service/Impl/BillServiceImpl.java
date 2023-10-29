package com.project.Dbms.Service.Impl;



import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.UnitValue;

import com.project.Dbms.DTO.MedicineDTO;
import com.project.Dbms.Domain.Bills;

import com.project.Dbms.Domain.Medicine;
import com.project.Dbms.Repository.BillRepository;
import com.project.Dbms.Repository.MedicineRepository;
import com.project.Dbms.Service.BillService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.SplittableRandom;
import java.util.stream.Stream;

@Service
@Log4j2
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private MedicineRepository medicineRepository;
    @Override
    public List<Bills> viewBills() {
     return billRepository.findAll();
    }

    private void createPdf(String dest, List<LinkedHashMap> medBought,Integer totalPaid){

        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest))) {
            pdfDoc.addNewPage();

            Document document = new Document(pdfDoc, PageSize.A4);
            document.setMargins(30, 20, 30, 60);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

            Paragraph citizen = new Paragraph()
                    .add(new Text("Pharmacy Management System"));
            citizen.setFont(font).setBold().setFontSize(12);
            document.add(citizen);

            Paragraph stars1 = new Paragraph()
                    .add(new Text("*********************************************************************************"));
            stars1.setFont(font).setFontSize(8);
            document.add(stars1);

            Paragraph billId = new Paragraph()
                    .add(new Text("Bill ID : "))
                    .add(new Text(dest));
            billId.setFont(font).setFontSize(8);
            document.add(billId);

            Paragraph date = new Paragraph()
                    .add(new Text("Date : "))
                    .add(new Text(LocalDateTime.now().toString()));
            date.setFont(font).setFontSize(8);
            document.add(date);

            Paragraph totalPaidPara = new Paragraph()
                    .add(new Text("Total Paid : " + totalPaid));
            totalPaidPara.setFont(font).setFontSize(8);
            document.add(totalPaidPara);

            Paragraph stars2 = new Paragraph()
                    .add(new Text("*********************************************************************************"));
            stars2.setFont(font).setFontSize(8);
            document.add(stars2);

            Table table = new Table(UnitValue.createPercentArray(new float[]{50,50,50,50,50,50}));

            table.addCell(new Cell()
                    .add(new Paragraph(new Text("Medicine ID")))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text("Name")))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text("Company Name")))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text("Price Per Unit")))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text("No of Units")))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text("Sub Total Price")))
                    .setFontSize(8));

            addRows(table,medBought);
            document.add(table);

            Paragraph stars3 = new Paragraph()
                    .add(new Text("*********************************************************************************"));
            stars3.setFont(font).setFontSize(8);
            document.add(stars3);

            Paragraph thankYou = new Paragraph()
                    .add(new Text("Thank you, Please Visit Again"));

            thankYou.setFont(font).setFontSize(8);
            document.add(thankYou);

            document.close();

        }
        catch (Exception e){
            log.error(e.getMessage());
        }

    }



    private void addRows(Table table,List<LinkedHashMap> medicines) {

        for(LinkedHashMap med : medicines){
            table.addCell(new Cell()
                    .add(new Paragraph(new Text(med.get("medId").toString())))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text(med.get("name").toString())))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text(med.get("companyName").toString())))
                    .setFontSize(8));
            table.addCell(new Cell()
                    .add(new Paragraph(new Text(med.get("pricePerUnit").toString())))
                    .setFontSize(8));

            table.addCell(new Cell()
                    .add(new Paragraph(new Text(med.get("quantity").toString())))
                    .setFontSize(8));
            updateQuantity(Long.valueOf(med.get("medId").toString()), (Integer) med.get("quantity"));

            Integer quantity= (Integer) med.get("quantity");
            Integer pricePerUnit = (Integer)med.get("pricePerUnit");
            Integer subtotal = quantity*pricePerUnit;

            table.addCell(new Cell().add(new Paragraph(new Text(subtotal.toString())))
                    .setFontSize(8));
        }

    }

    private String generate(final int length) {
        StringBuilder generatedOTP = new StringBuilder();
        SplittableRandom splittableRandom = new SplittableRandom();
        for (int i = 0; i < length; i++) {
            int randomNumber = splittableRandom.nextInt(0, 9);
            generatedOTP.append(randomNumber);
        }
        return generatedOTP.toString();
    }

    @Override
    public void purchaseAndPrint(List<LinkedHashMap> medicines, String name, Integer totalPaid) {
        String fileName = "Bill-"+generate(15);
        createPdf(fileName,medicines,totalPaid);
        Bills bill = new Bills();
        bill.setBillId(fileName);
        bill.setDate(LocalDate.now());
        bill.setGenerateBy(name);
        bill.setTotalPaid(totalPaid);
        billRepository.save(bill);

    }

    private void updateQuantity(Long medId, Integer quantity){
        Optional<Medicine> medicineOptional =  medicineRepository.findByMedId(medId);
        if(medicineOptional.isPresent()){
            Medicine med = medicineOptional.get();
            med.setQuantity(med.getQuantity()-quantity);
            medicineRepository.save(med);
        }
    }
}
