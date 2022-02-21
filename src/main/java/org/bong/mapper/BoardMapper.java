package org.bong.mapper;

import org.bong.domain.BoardVO;
import org.bong.domain.Criteria;

import java.util.List;


public interface BoardMapper {
    // @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

    public List<BoardVO> getListWithPaging(Criteria cri);

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);

    public int getTotalCount(Criteria cri);

    public BoardVO test();
}
