package dto;

import lombok.Builder;
import lombok.Data;
import model.Report;
@Data
@Builder
public class ReportResponseDto {
    private Integer id;

    private String name;


    public static ReportResponseDto fromEntity(Report report) {
        return ReportResponseDto.builder()
                .id(report.getId())
                .name(report.getName())
                .build();
    }
}
