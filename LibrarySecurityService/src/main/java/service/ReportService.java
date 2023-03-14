package service;

import dto.ReportResponseDto;

import java.util.List;

public interface ReportService {

    List<ReportResponseDto> findAll();
}