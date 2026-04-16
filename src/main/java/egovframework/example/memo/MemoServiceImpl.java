package egovframework.example.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 메모 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

  private final MemoMapper memoMapper;

  /** 메모 전체 목록 조회 */
  @Transactional(readOnly = true)
  @Override
  public List<MemoVO> getMemoList() {
    return memoMapper.selectMemoList();
  }

  /** 단건 메모 조회 - 존재하지 않으면 예외 발생 */
  @Transactional(readOnly = true)
  @Override
  public MemoVO getMemo(Long memoId) {
    MemoVO memo = memoMapper.selectMemo(memoId);
    if (memo == null) {
      throw new IllegalArgumentException("존재하지 않는 메모입니다. memoId=" + memoId);
    }
    return memo;
  }

  /**
   * 메모 등록
   * useGeneratedKeys 설정으로 insert 후 memoVO.memoId에 생성된 PK가 자동으로 채워짐
   */
  @Transactional
  @Override
  public MemoVO createMemo(MemoVO memoVO) {
    memoMapper.insertMemo(memoVO);
    // insert 시 채워진 memoId로 DB에서 완전한 객체(reg_dt 포함) 재조회
    return memoMapper.selectMemo(memoVO.getMemoId());
  }

  /** 메모 수정 후 갱신된 객체 반환 */
  @Transactional
  @Override
  public MemoVO updateMemo(MemoVO memoVO) {
    // 존재 여부 검증
    getMemo(memoVO.getMemoId());
    memoMapper.updateMemo(memoVO);
    return memoMapper.selectMemo(memoVO.getMemoId());
  }

  /** 메모 삭제 */
  @Transactional
  @Override
  public void deleteMemo(Long memoId) {
    // 존재 여부 검증
    getMemo(memoId);
    memoMapper.deleteMemo(memoId);
  }
}
