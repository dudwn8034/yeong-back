package egovframework.example.memo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 메모 도메인 객체
 * tb_memo 테이블과 매핑됨
 */
@Getter
@Setter
@NoArgsConstructor
public class MemoVO {

  /** 메모 고유 식별자 */
  private Long memoId;

  /** 메모 제목 */
  private String title;

  /** 메모 본문 */
  private String content;

  /** 등록일시 */
  private LocalDateTime regDt;

  /** 수정일시 */
  private LocalDateTime updDt;
}
