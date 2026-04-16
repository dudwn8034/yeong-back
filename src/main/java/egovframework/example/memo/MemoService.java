package egovframework.example.memo;

import java.util.List;

/**
 * 메모 서비스 인터페이스
 */
public interface MemoService {

  /** 메모 전체 목록 조회 */
  List<MemoVO> getMemoList();

  /** 단건 메모 조회 */
  MemoVO getMemo(Long memoId);

  /** 메모 등록 후 저장된 객체 반환 */
  MemoVO createMemo(MemoVO memoVO);

  /** 메모 수정 후 갱신된 객체 반환 */
  MemoVO updateMemo(MemoVO memoVO);

  /** 메모 삭제 */
  void deleteMemo(Long memoId);
}
