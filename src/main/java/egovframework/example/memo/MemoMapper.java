package egovframework.example.memo;

// eGovFramework 전용 @Mapper 사용 (MyBatis 기본 애너테이션과 구분)
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

/**
 * 메모 MyBatis 매퍼 인터페이스
 * MemoMapper.xml과 연결됨
 */
@Mapper
public interface MemoMapper {

  /** 메모 전체 목록 조회 (등록일 내림차순) */
  List<MemoVO> selectMemoList();

  /** 단건 메모 조회 */
  MemoVO selectMemo(Long memoId);

  /** 메모 등록 (useGeneratedKeys로 memoId 자동 채움) */
  int insertMemo(MemoVO memoVO);

  /** 메모 수정 */
  int updateMemo(MemoVO memoVO);

  /** 메모 삭제 */
  int deleteMemo(Long memoId);
}
