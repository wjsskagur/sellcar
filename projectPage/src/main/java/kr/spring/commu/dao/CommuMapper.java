package kr.spring.commu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.commu.domain.CommuVO;

public interface CommuMapper {
	public List<CommuVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO board (board_num,board_name,board_con,board_img,board_filename,board_auth,mem_id,ip,board_hit,reg_date) VALUES(board_seq.nextval,#{board_name},#{board_con},#{board_img},#{board_filename},#{board_auth},#{mem_id},#{ip},#{board_hit},SYSDATE)")
	public void insert(CommuVO board);
	@Select("SELECT * FROM board b JOIN member m on b.mem_id=m.mem_id WHERE b.board_num=#{board_num}")
	public CommuVO selectBoard(Integer board_num);
	@Update("UPDATE board SET board_hit=board_hit+1 WHERE board_num=#{board_num}")
	public void updateHit(Integer board_num);
	public void update(CommuVO board);
	@Delete("DELETE FROM board WHERE board_num=#{board_num}")
	public void delete(Integer board_num);
}
