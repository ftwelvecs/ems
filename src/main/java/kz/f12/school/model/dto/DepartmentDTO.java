package kz.f12.school.model.dto;

public class DepartmentDTO extends DictDTO {
    RegionDTO region;

    public RegionDTO getRegion() {
        return region;
    }

    public void setRegion(RegionDTO region) {
        this.region = region;
    }
}
