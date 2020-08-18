package kr.spring.qa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.qa.domain.QaVO;
import kr.spring.qa.domain.ReplyVO;

public interface QaMapper {
	public List<QaVO> selectList(Map<String,Object> map);
	public List<ReplyVO> readReply(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO qnaboard (num,title,content,uploadfile,filename,ip,mem_num) VALUES (board_seq.nextval,#{title},#{content},#{uploadfile},#{filename},#{ip},#{mem_num})")
	public void insert(QaVO qa);
	@Select("SELECT * FROM qnaboard b JOIN member m ON b.mem_num=m.mem_num WHERE b.num=#{num}")
	public QaVO selectBoard(Integer num);
	@Update("UPDATE qnaboard SET hit=hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	public void update(QaVO qa);
	@Delete("DELETE FROM qnaboard WHERE num=#{num}")
	public void delete(Integer num);
	@Insert("INSERT INTO reply (bno, rno, content, writer) VALUES (#{bno}, reply_seq.nextval, #{content], #{writer})")
	public int insert(ReplyVO vo);
}
