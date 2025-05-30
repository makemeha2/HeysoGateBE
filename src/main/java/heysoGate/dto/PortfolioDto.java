package heysoGate.dto;

import lombok.Data;

@Data
public class PortfolioDto {
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private String thumbnailUrl;
    private Integer sortOrder;
}

