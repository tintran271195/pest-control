package com.example.pestcontrol.service.Report;

import com.example.pestcontrol.model.Report;
import com.example.pestcontrol.repository.IReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReportService implements IReportService {
    private final IReportRepository reportRepository;

    @Override
    public Iterable<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void remove(Long id) {
        reportRepository.deleteById(id);
    }
}
