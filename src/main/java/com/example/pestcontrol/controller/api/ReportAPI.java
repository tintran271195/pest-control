package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Report;
import com.example.pestcontrol.service.Report.IReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/report")
@RequiredArgsConstructor
public class ReportAPI {
    private final IReportService reportService;

    @GetMapping()
    public ResponseEntity<Iterable<Report>> getAllReport(){
        Iterable<Report> reports = reportService.findAll();
        if (reports == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(reports, HttpStatus.OK);
        }
    }
}
