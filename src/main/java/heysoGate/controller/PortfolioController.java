package heysoGate.controller;

import heysoGate.dto.ApiResponse;
import heysoGate.dto.PageResultDto;
import heysoGate.dto.PortfolioDto;
import heysoGate.dto.PortfolioRequestDto;
import heysoGate.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @Operation(summary = "포트폴리오 목록 조회", description = "검색어로 포트폴리오를 페이징 조회합니다.")
    @GetMapping
    public ApiResponse<PageResultDto<PortfolioDto>> getPortfolioList(@RequestParam(required = false) String keyword,
                                                                     @RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "10") Integer size) {

        PortfolioRequestDto request = new PortfolioRequestDto();
        request.setKeyword(keyword);
        request.setPage(page);
        request.setSize(size);

        return ApiResponse.success(portfolioService.getPortfolioList(request));
    }

    @Operation(summary = "포트폴리오 저장", description = "포트폴리오 저장합니다.")
    @PostMapping
    public ApiResponse<String> createPortfolio(@RequestBody PortfolioDto dto) {
        portfolioService.createPortfolio(dto);
        return ApiResponse.success("", null);
    }
}
