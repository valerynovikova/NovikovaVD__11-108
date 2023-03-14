package service;

import dto.ReportResponseDto;
import repository.ReportRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<ReportResponseDto> findAll() {
        return reportRepository.findAll().stream().map(u -> ReportResponseDto.builder()
                .name(u.getName())
                .id(u.getId())
                .build()
        ).collect(Collectors.toList());
    }
}
