package heysoGate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioRequestDto {

    private String keyword;
    private Integer page = 0;
    private Integer size = 10;

    public Integer getOffset() {
        if (page == null || size == null) return 0;
        return page * size;
    }
}
