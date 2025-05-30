package heysoGate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultDto<T> {
    private List<T> content;     // 실제 데이터 리스트
    private int page;            // 현재 페이지 번호 (0부터 시작)
    private int size;            // 한 페이지당 데이터 수
    private long totalElements; // 전체 아이템 개수
    private int totalPages;     // 전체 페이지 수

    public PageResultDto(List<T> content, int page, int size, long totalElements) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }
}
