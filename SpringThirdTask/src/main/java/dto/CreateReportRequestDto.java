package dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateReportRequestDto {

    @NotBlank(message = "Name shouldn't be blank")
    private String name;


}