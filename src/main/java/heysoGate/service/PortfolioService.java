package heysoGate.service;

import heysoGate.dto.PageResultDto;
import heysoGate.dto.PortfolioDto;
import heysoGate.dto.PortfolioRequestDto;
import heysoGate.mapper.PortfolioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioMapper portfolioMapper;

    public PageResultDto<PortfolioDto> getPortfolioList(PortfolioRequestDto dto) {
        List<PortfolioDto> list = portfolioMapper.selectPortfolioList(dto);
        int total = portfolioMapper.countPortfolio(dto);

//        Map<String, Object> result = new HashMap<>();
//        result.put("data", list);
//        result.put("total", total);
//        result.put("page", dto.getPageIndex());
//        result.put("size", dto.getPageSize());

        return new PageResultDto<>(list, dto.getPage(), dto.getSize(), total);
    }

    public void createPortfolio(PortfolioDto dto) {
        portfolioMapper.insertPortfolio(dto);
    }
}
