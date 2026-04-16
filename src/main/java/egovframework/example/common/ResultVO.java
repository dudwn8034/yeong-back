package egovframework.example.common;

import lombok.Getter;

/**
 * 공통 API 응답 래퍼
 * 모든 API 응답은 이 클래스를 통해 일관된 형식으로 반환됨
 */
@Getter
public class ResultVO<T> {

  private final boolean success;
  private final String message;
  private final T data;

  // 외부 생성자 노출 차단
  private ResultVO(boolean success, String message, T data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  /**
   * 성공 응답 (데이터 포함)
   */
  public static <T> ResultVO<T> ok(T data) {
    return new ResultVO<>(true, "성공", data);
  }

  /**
   * 성공 응답 (메시지만, 데이터 없음)
   */
  public static <T> ResultVO<T> ok(String message) {
    return new ResultVO<>(true, message, null);
  }

  /**
   * 실패 응답
   */
  public static <T> ResultVO<T> fail(String message) {
    return new ResultVO<>(false, message, null);
  }
}
