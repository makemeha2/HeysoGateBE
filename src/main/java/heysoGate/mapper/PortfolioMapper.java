package heysoGate.mapper;

import heysoGate.dto.PortfolioDto;
import heysoGate.dto.PortfolioRequestDto;

import java.util.List;

public interface PortfolioMapper {
    List<PortfolioDto> selectPortfolioList(PortfolioRequestDto dto);
    int countPortfolio(PortfolioRequestDto dto);
    void insertPortfolio(PortfolioDto dto);
}
