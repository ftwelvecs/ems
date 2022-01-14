package kz.f12.school.model.dto;

import lombok.Data;

@Data
public class DepartmentDTO extends DictDTO {
    RegionDTO region;
    Integer regionId;
    Boolean isActive;
}
