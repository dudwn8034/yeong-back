-- 메모 테스트 테이블 DDL
-- 프론트-백 연결 검증용 CRUD 테스트 테이블

CREATE TABLE tb_memo (
  memo_id    SERIAL        PRIMARY KEY,          -- 자동 증가 기본키
  title      VARCHAR(100)  NOT NULL,             -- 메모 제목
  content    VARCHAR(500),                        -- 메모 내용 (선택)
  reg_dt     TIMESTAMP     NOT NULL DEFAULT NOW(), -- 등록일시 (자동)
  upd_dt     TIMESTAMP                            -- 수정일시
);

-- 테이블 코멘트
COMMENT ON TABLE  tb_memo          IS '메모 테스트 테이블';
COMMENT ON COLUMN tb_memo.memo_id  IS '메모 ID (자동증가 PK)';
COMMENT ON COLUMN tb_memo.title    IS '메모 제목';
COMMENT ON COLUMN tb_memo.content  IS '메모 내용';
COMMENT ON COLUMN tb_memo.reg_dt   IS '등록일시';
COMMENT ON COLUMN tb_memo.upd_dt   IS '수정일시';
