package controller;

import dto.CreateReportRequestDto;
import dto.ReportResponseDto;
import lombok.AllArgsConstructor;
import model.Report;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ReportRepository;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ReportController {

    private final ReportRepository reportRepository;

    @PostMapping("/report")
    public ReportResponseDto createReport(@Valid @RequestBody CreateReportRequestDto report) {
        return ReportResponseDto.fromEntity(reportRepository.save(
                Report.builder()
                        .name(report.getName().trim())
                        .build()
        ));
    }

}
