package egovframework.example.memo;

import egovframework.example.common.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 메모 CRUD REST API 컨트롤러
 * 기본 경로: /api/memos
 */
@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {

  private final MemoService memoService;

  /**
   * 메모 전체 목록 조회
   * GET /api/memos
   */
  @GetMapping
  public ResponseEntity<ResultVO<List<MemoVO>>> getMemoList() {
    List<MemoVO> list = memoService.getMemoList();
    return ResponseEntity.ok(ResultVO.ok(list));
  }

  /**
   * 단건 메모 조회
   * GET /api/memos/{memoId}
   */
  @GetMapping("/{memoId}")
  public ResponseEntity<ResultVO<MemoVO>> getMemo(@PathVariable Long memoId) {
    MemoVO memo = memoService.getMemo(memoId);
    return ResponseEntity.ok(ResultVO.ok(memo));
  }

  /**
   * 메모 등록
   * POST /api/memos
   */
  @PostMapping
  public ResponseEntity<ResultVO<MemoVO>> createMemo(@RequestBody MemoVO memoVO) {
    MemoVO created = memoService.createMemo(memoVO);
    return ResponseEntity.status(HttpStatus.CREATED).body(ResultVO.ok(created));
  }

  /**
   * 메모 수정
   * PUT /api/memos/{memoId}
   */
  @PutMapping("/{memoId}")
  public ResponseEntity<ResultVO<MemoVO>> updateMemo(
      @PathVariable Long memoId,
      @RequestBody MemoVO memoVO) {
    // URL의 memoId를 body 객체에 주입
    memoVO.setMemoId(memoId);
    MemoVO updated = memoService.updateMemo(memoVO);
    return ResponseEntity.ok(ResultVO.ok(updated));
  }

  /**
   * 메모 삭제
   * DELETE /api/memos/{memoId}
   */
  @DeleteMapping("/{memoId}")
  public ResponseEntity<ResultVO<Void>> deleteMemo(@PathVariable Long memoId) {
    memoService.deleteMemo(memoId);
    return ResponseEntity.ok(ResultVO.ok("삭제되었습니다."));
  }
}
